package com.samdevweb.docswagger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samdevweb.docswagger.dto.FuncionarioDTO;
import com.samdevweb.docswagger.dto.FuncionarioResponseDTO;
import com.samdevweb.docswagger.exception.ResourceNotFoundException;
import com.samdevweb.docswagger.service.FuncionarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<FuncionarioResponseDTO> listAll() {
        return funcionarioService.listAll();
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponseDTO> findById(@PathVariable String id) throws ResourceNotFoundException {
        FuncionarioResponseDTO dto = funcionarioService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<FuncionarioResponseDTO> create(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioResponseDTO dto = funcionarioService.create(funcionarioDTO);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponseDTO> update(@PathVariable String id, @Valid @RequestBody FuncionarioDTO funcionarioDTO) throws ResourceNotFoundException {
        FuncionarioResponseDTO dto = funcionarioService.update(id, funcionarioDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws ResourceNotFoundException {
        funcionarioService.delete(id);
        return ResponseEntity.ok().body("Funcionário removido com sucesso");
    }
    
    
}
