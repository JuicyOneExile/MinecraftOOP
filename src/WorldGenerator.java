import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WorldGenerator {
    private int[][] world;
    private int width;
    private int height;
    private BufferedImage blockImage;

    public WorldGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.world = new int[width][height];
        try {
            blockImage = ImageIO.read(WorldGenerator.class.getResourceAsStream("/grassblock.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateWorld();

    }

    private void generateWorld() {
        for(int x = 0; x < width; x++){
            for(int z = 0; z < height; z++){
                // Set every block to grass
                world[x][z] = 1;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWorld(int x, int z) {
        if(x < 0 || x >= width || z < 0 || z >= height){
            return 0;
        }
        return world[x][z];
    }

    public void render(Graphics g) {
        int blockSize = 10;
        for (int x = 0; x < width; x++) {
            for (int z = 0; z < height; z++) {
                int tileX = x * blockSize;
                int tileZ = z * blockSize;
                g.drawImage(blockImage, tileX, tileZ, blockSize, blockSize, null);
                g.setColor(Color.BLACK);
                g.drawRect(tileX, tileZ, blockSize, blockSize);
            }
        }
    }


}
