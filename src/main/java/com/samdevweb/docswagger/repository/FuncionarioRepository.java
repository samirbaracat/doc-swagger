package com.samdevweb.docswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samdevweb.docswagger.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    
}
