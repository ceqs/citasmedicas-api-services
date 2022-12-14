package pe.edu.utp.soa.citasmedicas.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.soa.citasmedicas.model.Reserva;
import pe.edu.utp.soa.citasmedicas.service.api.ReporteServiceAPI;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@CrossOrigin("*")
public class ReporteApiController {

	@Autowired
	private ReporteServiceAPI reporteServiceAPI;

	@GetMapping(value = "/reportes")
	public List<Reserva> getByFechasEspMed(@RequestParam String start, @RequestParam String end, @RequestParam String cesp, @RequestParam String cmed) {
		System.out.println("entro al metodo");
		return reporteServiceAPI.findReservasByFechasEspMed(start, end, cesp, Integer.parseInt(cmed));
	}
}
