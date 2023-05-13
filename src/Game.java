import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final String TITLE = "SandBoxPewPew";

    private boolean running = false;
    private Thread thread;
    private Player player;
    private WorldGenerator world;

    public Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(new KeyboardInput());
        world = new WorldGenerator(500, 500);
        player = new Player(1, "Player", 100, 10, world);
    }

    void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        if (!running) {
            return;
        }

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                render();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        stop();
    }

    private void render() throws IOException {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Draw game objects
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawString("Position: " + player.getX() + ", " + player.getZ(), 10, 70);
        // Draw world
        world.render(g);

        // Draw player
        player.render(g);

        g.dispose();
        bs.show();
    }



    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }

    private class KeyboardInput extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}
