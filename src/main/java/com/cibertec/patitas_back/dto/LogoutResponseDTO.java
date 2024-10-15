package com.cibertec.patitas_back.dto;

import java.util.Date;

public record LogoutResponseDTO(Boolean resultado, Date fecha, String mensaje) {

}
