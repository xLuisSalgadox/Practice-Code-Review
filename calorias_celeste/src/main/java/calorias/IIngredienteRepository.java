package calorias;

import java.util.ArrayList;

public interface IIngredienteRepository {

    ArrayList<IngredienteYCalorias> generarListaDeIngredientesConCalorias(ArrayList<Ingrediente> ingredientesEnPlato);
    ArrayList<IngredienteYCalorias> cargarBase();
}
