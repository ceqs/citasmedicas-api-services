package pe.edu.utp.soa.citasmedicas.service.api;

import pe.edu.utp.soa.citasmedicas.model.Paciente;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceAPI;

public interface PacienteServiceAPI extends GenericServiceAPI<Paciente, Integer> {

    Paciente findByUsuario(String usuario);
}
