package calorias;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

@Setter
@Getter
public class ResumenPlatoDTO {
    private Double caloriasTotales;
    private ArrayList<IngredienteYCalorias> caloriasPorIngrediente;
    private IngredienteYCalorias ingredienteConMasCalorias;
}
