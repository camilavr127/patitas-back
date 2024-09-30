package com.cibertec.patitas_back.service;

import java.io.IOException;

import com.cibertec.patitas_back.dto.LoginRequestDTO;

public interface AuthInterface {
    String[] validarUsuario(LoginRequestDTO login) throws IOException;

}
