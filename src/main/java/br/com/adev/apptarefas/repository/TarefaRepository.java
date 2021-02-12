package br.com.adev.apptarefas.repository;
import br.com.adev.apptarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
