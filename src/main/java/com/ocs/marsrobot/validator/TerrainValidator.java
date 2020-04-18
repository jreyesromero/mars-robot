package com.ocs.marsrobot.validator;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class TerrainValidator {

    public boolean validateTerrain(ArrayList<ArrayList<String>> terrain) {
        List<String> invalidMaterials = new ArrayList<>();

        terrain.forEach(subTerrain -> {
            subTerrain.forEach(material -> {
                if (!isValidMaterial(material)) {
                    invalidMaterials.add(material);
                }
            });
        });

        return invalidMaterials.isEmpty();
    }

    private boolean isValidMaterial(String material) {
        switch (material.toUpperCase()) {
            case "FE":
            case "SE":
            case "W":
            case "SI":
            case "ZN":
            case "OBS":
                return true;
            default:
                return false;
        }

    }


}