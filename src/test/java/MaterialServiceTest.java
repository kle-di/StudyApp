import model.Material;
import org.junit.jupiter.api.Test;
import repository.MaterialRepository;
import service.MaterialService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaterialServiceTest {

    @Test
    void returnsMaterialsByTopic() {
        MaterialService service = new MaterialService(new MaterialRepository());

        List<Material> materials = service.getMaterialsByTopic(101);

        assertEquals(2, materials.size());
    }
}
