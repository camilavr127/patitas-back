package com.cibertec.patitas_back.service;

import java.io.IOException;
import java.util.Date;

import com.cibertec.patitas_back.dto.LoginRequestDTO;
import com.cibertec.patitas_back.dto.LogoutRequestDTO;

public interface AuthInterface {
    String[] validarUsuario(LoginRequestDTO login) throws IOException;

    Date cerrarSesion(LogoutRequestDTO logoutRequestDTO) throws IOException;

}
