package calorias;

import java.util.ArrayList;

public interface ICaloriasCalculatorService {

    ResumenPlatoDTO generarResumenPlato(PlatoDTO plato);
    Double calcularCaloriasTotales(ArrayList<IngredienteYCalorias> ingredientesConCalorias, ArrayList<Ingrediente> ingredientesEnPlato);
    IngredienteYCalorias ingredienteConMasCalorias(ArrayList<IngredienteYCalorias> ingredientesYCaloriasEnPlato);
}
