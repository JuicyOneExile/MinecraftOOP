import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    private int x;
    private int z;
    private WorldGenerator world;

    public Player(int id, String name, int health, int damage, WorldGenerator world) {
        super(id, name, health, damage);
        this.world = world;
        this.x = world.getWidth() / 2;
        this.z = world.getHeight() / 2;
    }

    public void attack() {
        // Player attack logic
    }

    public void render(Graphics g) throws IOException {
        BufferedImage image = ImageIO.read(Player.class.getResourceAsStream("/canvas.png"));
        BufferedImage resized = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(image, 0, 0, 10, 10, null);
        g2d.dispose();
        g.drawImage(resized, x, z, null);
    }




    public void move(int dx, int dz) {
        int newX = x + dx;
        int newZ = z + dz;
        if(world.getWorld(newX, newZ) != 1){
            // Player can't move to non-grass block
            return;
        }
        x = newX;
        z = newZ;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            move(0, -1); // Move up
        }

        if (key == KeyEvent.VK_A) {
            move(-1, 0); // Move left
        }

        if (key == KeyEvent.VK_S) {
            move(0, 1); // Move down
        }

        if (key == KeyEvent.VK_D) {
            move(1, 0); // Move right
        }
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}
