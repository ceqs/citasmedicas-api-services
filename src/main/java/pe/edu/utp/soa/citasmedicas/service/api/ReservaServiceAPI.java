package pe.edu.utp.soa.citasmedicas.service.api;

import pe.edu.utp.soa.citasmedicas.model.Reserva;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceAPI;

import java.time.LocalDate;
import java.util.List;

public interface ReservaServiceAPI extends GenericServiceAPI<Reserva, Integer> {
    void sendEmail(String fecha, String horario, String medico, String receptor);

    List<Reserva> searchReservasPorFechas(Integer idMedico, LocalDate start, LocalDate end);
}
