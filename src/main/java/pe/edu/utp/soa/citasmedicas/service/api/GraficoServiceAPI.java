package pe.edu.utp.soa.citasmedicas.service.api;

import pe.edu.utp.soa.citasmedicas.model.Reserva;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceAPI;
import pe.edu.utp.soa.citasmedicas.model.Grafico;

import java.util.List;

public interface GraficoServiceAPI extends GenericServiceAPI<Reserva, Integer> {
    public List<Grafico> findCountReservasByAnio(Integer anio);

    public List<Grafico> findCountReservasByAnioByMed(Integer anio);
}
