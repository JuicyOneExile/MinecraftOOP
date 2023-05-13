import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemReader {
    public List<Item> readItemsFromFile(String filename) throws IOException {
        List<Item> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                String name = values[1].trim();
                int damage = Integer.parseInt(values[2].trim());
                int durability = Integer.parseInt(values[3].trim());

                Item item = new Item(id, name, damage, durability);
                items.add(item);
            }
        }

        return items;
    }
}
