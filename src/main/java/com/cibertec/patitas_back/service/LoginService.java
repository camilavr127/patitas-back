package com.cibertec.patitas_back.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.cibertec.patitas_back.dto.LoginRequestDTO;

@Service
public class LoginService implements AuthInterface{

    @Autowired

    ResourceLoader resourceLoader;

    @Override
    public String[] validarUsuario(LoginRequestDTO login) throws IOException {
        String[] datos = null;
        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String linea;
            while ((linea = br.readLine())!= null) {
                String[] usuario = linea.split(";");
                if (usuario[0].equals(login.tipoDocumento()) &&
                    usuario[1].equals(login.numeroDocumento()) && 
                usuario[2].equals(login.password())) {
                    datos = new String[2];
                    datos[0] = usuario[3];
                    datos[1] = usuario[4];
                    break;
                }
            }

        } catch (IOException e) {
            throw new IOException(e);
        }
        return datos;

    }

}
