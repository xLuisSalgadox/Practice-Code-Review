package calorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
@Service
@Qualifier("service1")
public class CaloriasCalculatorService implements ICaloriasCalculatorService{
    @Autowired
    @Qualifier("repoIngredidentes")
    private IIngredienteRepository ingredienterepository;

    @Override
    public ResumenPlatoDTO generarResumenPlato(PlatoDTO plato) {
        ArrayList<IngredienteYCalorias> ingredientesYCaloriasEnPlato = ingredienterepository.generarListaDeIngredientesConCalorias(plato.getIngredientes());
        Double caloriasTotales = calcularCaloriasTotales(ingredientesYCaloriasEnPlato, plato.getIngredientes());
        IngredienteYCalorias ingredienteConMasCalorias = ingredienteConMasCalorias(ingredientesYCaloriasEnPlato);

        return new ResumenPlatoDTO(caloriasTotales, ingredientesYCaloriasEnPlato, ingredienteConMasCalorias);
    }
    @Override
    public IngredienteYCalorias ingredienteConMasCalorias(ArrayList<IngredienteYCalorias> ingredientesYCaloriasEnPlato) {
        return Collections.max(ingredientesYCaloriasEnPlato, Comparator.comparing(IngredienteYCalorias::getCalories));
    }

    @Override
    public Double calcularCaloriasTotales(ArrayList<IngredienteYCalorias> ingredientesConCalorias, ArrayList<Ingrediente> ingredientesEnPlato) {
        Double caloriasTotales =  ingredientesConCalorias.stream().mapToDouble(ingredienteConCalorias -> dameCaloriasDeIngredienteConMismoNombre(ingredienteConCalorias, ingredientesEnPlato)).sum();
        return caloriasTotales;
    }

    private double dameCaloriasDeIngredienteConMismoNombre(IngredienteYCalorias ingredienteConCalorias, ArrayList<Ingrediente> ingredientesEnPlato) {
        return ingredientesEnPlato.stream().filter(ingrediente -> mismoNombre(ingrediente, ingredienteConCalorias)).findFirst().get().getPeso() * 100 * ingredienteConCalorias.getCalories();
    }

    private boolean mismoNombre(Ingrediente ingrediente, IngredienteYCalorias ingredienteConCalorias) {
        return ingrediente.getNombre().equals(ingredienteConCalorias.getName());
    }
}
