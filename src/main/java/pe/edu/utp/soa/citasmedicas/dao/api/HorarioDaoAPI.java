package pe.edu.utp.soa.citasmedicas.dao.api;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.soa.citasmedicas.model.Horario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface HorarioDaoAPI extends CrudRepository<Horario, Integer> {

    List<Horario> findByMedicoIdAndFechaBetween(Integer idMedico, LocalDate start, LocalDate end);

    Horario findByMedicoIdAndHoraInicioAndHoraFin(Integer idMedico, LocalDateTime horaInicio, LocalDateTime horaFin);
}
