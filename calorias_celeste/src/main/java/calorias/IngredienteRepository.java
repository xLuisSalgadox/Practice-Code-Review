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
        ArrayList<IngredienteYCalorias> ingredientesEnBase = cargarBase();
        ArrayList<IngredienteYCalorias> ingredientesConCalorias = buscarEnBaseDeDatosYCrearIngredienteConCalorias(ingredientesEnPlato, ingredientesEnBase);

        return ingredientesConCalorias;
    }

    private ArrayList<IngredienteYCalorias> buscarEnBaseDeDatosYCrearIngredienteConCalorias(ArrayList<Ingrediente> ingredientesEnPlato, ArrayList<IngredienteYCalorias> ingredientesEnBase) {
        ArrayList<IngredienteYCalorias> ingredientesConCalorias = new ArrayList<>();
        for(Ingrediente i : ingredientesEnPlato) {
            IngredienteYCalorias ingredienteConCalorias = ingredientesEnBase.stream().filter(ingrediente -> ingrediente.getName().equals(i.getNombre())).findFirst().get();
            ingredientesConCalorias.add(ingredienteConCalorias);
        }
        return ingredientesConCalorias;
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
