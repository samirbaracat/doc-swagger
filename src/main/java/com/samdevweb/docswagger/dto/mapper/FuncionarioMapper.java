package com.samdevweb.docswagger.dto.mapper;

import com.samdevweb.docswagger.dto.FuncionarioResponseDTO;
import com.samdevweb.docswagger.model.Funcionario;

public class FuncionarioMapper {
    
    public static FuncionarioResponseDTO toFuncionarioResponseDTO(Funcionario funcionario) {
        FuncionarioResponseDTO funcionarioResponseDTO = new FuncionarioResponseDTO();
        funcionarioResponseDTO.setId(funcionario.getId());
        funcionarioResponseDTO.setPrimeiroNome(funcionario.getPrimeiroNome());
        funcionarioResponseDTO.setUltimoNome(funcionario.getUltimoNome());
        funcionarioResponseDTO.setEmail(funcionario.getEmail());
        return funcionarioResponseDTO;
    }
}
