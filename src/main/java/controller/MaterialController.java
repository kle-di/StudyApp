package controller;

import model.Material;
import service.MaterialService;

import java.util.List;

/**
 * Controller for material actions.
 */
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    public List<Material> listMaterialsByTopic(int topicId) {
        return materialService.getMaterialsByTopic(topicId);
    }
}
