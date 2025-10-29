package escolaSpring.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa implements Serializable {

    private String matricula;

    public Aluno() {
        super();
    }

    public Aluno(Long id, String nome, String cpf, String dataDeNascimento, String matricula) {
        super(id, nome, cpf, dataDeNascimento);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
}
