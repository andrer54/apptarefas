package br.com.adev.apptarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private String tarefa;
    private String status;
}
