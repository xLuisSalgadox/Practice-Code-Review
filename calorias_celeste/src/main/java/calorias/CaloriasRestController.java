package calorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriasRestController {

    @Autowired
    @Qualifier("service1")
    private CaloriasCalculatorService caloriasService;

    @PostMapping(path = "/plato")
    public ResumenPlatoDTO generarResumenDePlato(@RequestBody PlatoDTO plato){
        return caloriasService.generarResumenPlato(plato);
    }

}
