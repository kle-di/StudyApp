package repository;

import model.Material;
import model.MaterialType;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for materials.
 */
public class MaterialRepository {

    private final List<Material> materials = new ArrayList<>();

    public MaterialRepository() {
        materials.add(new Material(1, 101, MaterialType.READING, "Java Variables", "Variables store data. Use int, double, and String."));
        materials.add(new Material(2, 101, MaterialType.NOTES, "Control Flow Notes", "if/else, switch, for, while, and break."));

        materials.add(new Material(3, 102, MaterialType.READING, "Classes and Objects", "Classes define data and behavior with fields and methods."));

        materials.add(new Material(4, 201, MaterialType.READING, "Ancient Egypt", "The Nile enabled agriculture and centralized power."));
        materials.add(new Material(5, 202, MaterialType.NOTES, "Industrial Revolution", "Steam power and factories reshaped labor."));

        materials.add(new Material(6, 301, MaterialType.READING, "Array Basics", "Arrays have fixed size and direct indexing."));
        materials.add(new Material(7, 302, MaterialType.NOTES, "Tree Traversal", "Preorder, inorder, and postorder visit patterns."));
    }

    public List<Material> findByTopicId(int topicId) {
        List<Material> results = new ArrayList<>();
        for (Material material : materials) {
            if (material.getTopicId() == topicId) {
                results.add(material);
            }
        }
        return results;
    }
}
