package pe.edu.utp.soa.citasmedicas.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.soa.citasmedicas.service.api.GraficoServiceAPI;
import pe.edu.utp.soa.citasmedicas.model.Grafico;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@CrossOrigin("*")
public class GraficoApiController {

    @Autowired
    private GraficoServiceAPI graficoServiceAPI;

    @GetMapping(value = "/graficos")
    public List<Grafico> getByCountAnio(@RequestParam String anio) {
        System.out.println("entro al metodo");
        return graficoServiceAPI.findCountReservasByAnio(Integer.parseInt(anio));
    }

    @GetMapping(value = "/graficosM")
    public List<Grafico> getByCountAnioByMed(@RequestParam String anio) {
        System.out.println("entro al metodo");
        return graficoServiceAPI.findCountReservasByAnioByMed(Integer.parseInt(anio));
    }

}
