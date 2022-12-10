package pe.edu.utp.soa.citasmedicas.service.api;

import pe.edu.utp.soa.citasmedicas.model.Reserva;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceAPI;

import java.util.List;

public interface ReporteServiceAPI extends GenericServiceAPI<Reserva, Integer> {

    public List<Reserva> findReservasByFechasEspMed(String start, String end, String cesp, Integer cmed);
}
