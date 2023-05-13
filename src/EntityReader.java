import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntityReader {
    public List<Entity> readItemsFromFile(String filename) throws IOException {
        List<Entity> entities = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                String name = values[1].trim();
                int health = Integer.parseInt(values[2].trim());
                int damage = Integer.parseInt(values[3].trim());

                Entity entity = new Entity(id, name, health, damage);
                entities.add(entity);
            }
        }

        return entities;
    }
}
