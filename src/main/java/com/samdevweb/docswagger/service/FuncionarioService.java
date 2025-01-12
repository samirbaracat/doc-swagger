package com.samdevweb.docswagger.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.samdevweb.docswagger.dto.FuncionarioDTO;
import com.samdevweb.docswagger.dto.FuncionarioResponseDTO;
import com.samdevweb.docswagger.dto.mapper.FuncionarioMapper;
import com.samdevweb.docswagger.exception.ResourceNotFoundException;
import com.samdevweb.docswagger.model.Funcionario;
import com.samdevweb.docswagger.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional(readOnly = true)
    public List<FuncionarioResponseDTO> listAll() {
        return funcionarioRepository.findAll()
            .stream()
            .map(funcionario -> {
                FuncionarioResponseDTO dto = FuncionarioMapper.toFuncionarioResponseDTO(funcionario);
                return dto;
            }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FuncionarioResponseDTO findById(String id) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado: " + id));
        FuncionarioResponseDTO dto = FuncionarioMapper.toFuncionarioResponseDTO(funcionario);
        return dto;
    }

    @Transactional
    public FuncionarioResponseDTO create(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(funcionarioDTO, funcionario);
        funcionarioRepository.save(funcionario);
        return FuncionarioMapper.toFuncionarioResponseDTO(funcionario);
    }

    @Transactional
    public FuncionarioResponseDTO update(String id, FuncionarioDTO funcionarioDTO) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado: " + id));
        BeanUtils.copyProperties(funcionarioDTO, funcionario, "id");
        funcionarioRepository.save(funcionario);
        return FuncionarioMapper.toFuncionarioResponseDTO(funcionario);
    }

    @Transactional
    public void delete(@PathVariable String id) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado: " + id));
        funcionarioRepository.delete(funcionario);
    }
    
}
