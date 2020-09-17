package io.github.joaoroche.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciasDTO {
    private String Login;
    private String Senha;
}
