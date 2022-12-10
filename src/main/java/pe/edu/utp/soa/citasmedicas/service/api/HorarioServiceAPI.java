package pe.edu.utp.soa.citasmedicas.service.api;

import pe.edu.utp.soa.citasmedicas.model.Horario;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface HorarioServiceAPI extends GenericServiceAPI<Horario, Integer> {
    List<Horario> searchHorarios(Integer idMedico, LocalDate start, LocalDate end);

    Horario searchHorarioByFechas(Integer idMedico, LocalDateTime horaInicio, LocalDateTime horaFin);
}
