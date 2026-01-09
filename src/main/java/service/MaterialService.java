package service;

import model.Material;
import repository.MaterialRepository;

import java.util.List;

/**
 * Material operations over the repository.
 */
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> getMaterialsByTopic(int topicId) {
        return materialRepository.findByTopicId(topicId);
    }
}
