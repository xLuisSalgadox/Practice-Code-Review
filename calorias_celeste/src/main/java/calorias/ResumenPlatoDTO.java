package calorias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class ResumenPlatoDTO {
    private Double caloriasTotales;
    private ArrayList<IngredienteYCalorias> caloriasPorIngrediente;
    private IngredienteYCalorias ingredienteConMasCalorias;
}
