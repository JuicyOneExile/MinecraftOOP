import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.createBufferStrategy(3);
        game.start();
    }


//    public static void start(){
//        WorldGenerator world = new WorldGenerator(10, 10);
//        Player player = new Player(1, "Player", 100, 10, world);
//        Game game = new Game(player);
//        game.start();
//
//        loadItems();
//        loadEntities();
//    }
//    public static void loadItems(){
//        String filename = "src/items.txt";
//        ItemReader reader = new ItemReader();
//        try {
//            List<Item> items = reader.readItemsFromFile(filename);
//
//            for(Item item : items){
//                System.out.println(item.toString());
//            }
//            // do something with the list of items
//        } catch (IOException e) {
//            System.err.println("Error reading from file: " + e.getMessage());
//        }
//    }
//    public static void loadEntities(){
//        String filename = "src/entities.txt";
//        EntityReader reader = new EntityReader();
//        try {
//            List<Entity> entities = reader.readItemsFromFile(filename);
//
//            for(Entity entity : entities){
//                System.out.println(entity.toString());
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading from file: " + e.getMessage());
//        }
//    }
}
