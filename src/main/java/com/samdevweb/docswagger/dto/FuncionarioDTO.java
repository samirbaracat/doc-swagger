package com.samdevweb.docswagger.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class FuncionarioDTO {
    
    @NotEmpty
    private String primeiroNome;
    @NotEmpty
    private String ultimoNome;
    @NotEmpty
    private String email;

}
