package com.cibertec.patitas_back.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.patitas_back.dto.LoginRequestDTO;
import com.cibertec.patitas_back.dto.LoginResponseDTO;
import com.cibertec.patitas_back.dto.LogoutRequestDTO;
import com.cibertec.patitas_back.dto.LogoutResponseDTO;
import com.cibertec.patitas_back.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        try {
            Thread.sleep(5000);
            String[] datosUsuario = loginService.validarUsuario(loginRequestDTO);
            System.out.println("Respuesta backend login: " + Arrays.toString(datosUsuario));
            if (datosUsuario == null) {
                return new LoginResponseDTO("01", "Error: Usuario no encontrado", "", "");
            }
            return new LoginResponseDTO("00", "", datosUsuario[0], datosUsuario[1]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new LoginResponseDTO("99", "Error: Ocurrió un problema", "", "");
        }
    }

    @PostMapping("/logout")
    public LogoutResponseDTO logout(@RequestBody LogoutRequestDTO logoutRequestDTO){
        try {
            Thread.sleep(5000);
            Date fechaLogout = loginService.cerrarSesion(logoutRequestDTO);
            System.out.println("Respuesta backend logout: " + fechaLogout);
            if (fechaLogout == null) {
                return new LogoutResponseDTO(false, null, "Error: No se pudo registrar");
            }
                return new LogoutResponseDTO(true, fechaLogout, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new LogoutResponseDTO(false, null, "Error: Ocurrió un problema");
        }

    }

}
