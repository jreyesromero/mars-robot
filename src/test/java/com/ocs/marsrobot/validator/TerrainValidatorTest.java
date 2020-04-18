package com.ocs.marsrobot.validator;

import com.ocs.marsrobot.validator.TerrainValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TerrainValidatorTest {

    private TerrainValidator terrainValidator;
    private ArrayList<ArrayList<String>> terrain = new ArrayList<ArrayList<String>>();

    @BeforeEach
    public void setUp() {
        terrainValidator = new TerrainValidator();
    }

    @Test
    public void checkValidMaterials() {
        ArrayList<String> materials = new ArrayList<String>();
        materials.add("Fe");
        materials.add("Se");
        materials.add("W");
        terrain.add(materials);

        ArrayList<String> moreMaterials = new ArrayList<String>();
        moreMaterials.add("Si");
        moreMaterials.add("Zn");
        moreMaterials.add("Obs");
        terrain.add(moreMaterials);

        Assertions.assertTrue(terrainValidator.validateTerrain(terrain));
    }

    @Test
    public void checkNotValidMaterials() {
        ArrayList<String> materials = new ArrayList<String>();
        materials.add("H2O");
        materials.add("H");
        materials.add("O");
        terrain.add(materials);

        Assertions.assertFalse(terrainValidator.validateTerrain(terrain));
    }

}