package pe.edu.utp.soa.citasmedicas.dao.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.edu.utp.soa.citasmedicas.model.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface ReservaDaoAPI extends CrudRepository<Reserva, Integer> {
    @Query(value = "SELECT * FROM reserva r \n" +
            " INNER JOIN medicos m on r.id_medico = m.id_medico \n" +
            " WHERE r.fecha_cita between :start and :end \n" +
            " and r.id_medico = case when :cmed = 0 then r.id_medico else :cmed end \n" +
            " and m.id_esp = case when :cesp = 0 then m.id_esp else :cesp end",
           nativeQuery = true)
    List<Reserva> findReservasByFechasEspMed(@Param("start") String start, @Param("end") String end, @Param("cesp") String cesp, @Param("cmed") Integer cmed);

    List<Reserva> findByMedicoIdAndFechaCitaBetween(Integer idMedico, LocalDate start, LocalDate end);

}
