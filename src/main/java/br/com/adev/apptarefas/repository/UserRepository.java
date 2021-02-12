package br.com.adev.apptarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adev.apptarefas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
