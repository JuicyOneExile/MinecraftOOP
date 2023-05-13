import java.awt.*;

public class WorldGenerator {
    private int[][] world;
    private int width;
    private int height;

    public WorldGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.world = new int[width][height];
        generateWorld();
    }

    private void generateWorld() {
        for(int x = 0; x < width; x++){
            for(int z = 0; z < height; z++){
                // Set every tile to grass
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
        int tileSize = 10; // size of each tile in pixels
        for (int x = 0; x < width; x++) {
            for (int z = 0; z < height; z++) {
                int tileX = x * tileSize;
                int tileZ = z * tileSize;
                g.setColor(new Color(50, 200, 50)); // grass color
                g.fillRect(tileX, tileZ, tileSize, tileSize);
                g.setColor(Color.BLACK); // outline color
                g.drawRect(tileX, tileZ, tileSize, tileSize);
            }
        }
    }

}
