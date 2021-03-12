package calorias;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class PlatoDTO {
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
}
