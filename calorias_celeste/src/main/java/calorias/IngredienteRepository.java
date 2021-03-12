package calorias;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
@Qualifier("repoIngredidentes")
public class IngredienteRepository implements IIngredienteRepository{

    @Override
    public ArrayList<IngredienteYCalorias> generarListaDeIngredientesConCalorias(ArrayList<Ingrediente> ingredientesEnPlato) {
        ArrayList<IngredienteYCalorias> res = new ArrayList<>();
        ArrayList<IngredienteYCalorias> ingredientesEnBase = null;
        ingredientesEnBase = cargarBase();

        for(Ingrediente i : ingredientesEnPlato) {
            IngredienteYCalorias ingredienteConCalorias = ingredientesEnBase.stream().filter(ingrediente -> ingrediente.getName().equals(i.getNombre())).findFirst().get();
            res.add(ingredienteConCalorias);
        }

        return res;
    }

    @Override
    public ArrayList<IngredienteYCalorias> cargarBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("food.json");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<IngredienteYCalorias>> typeRef = new TypeReference<>(){};
        ArrayList<IngredienteYCalorias> ingredientesParseados = null;
        try{
            ingredientesParseados = om.readValue(file, typeRef);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientesParseados;
    }
}
