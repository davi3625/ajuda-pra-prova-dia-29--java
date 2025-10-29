package escolaSpring.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_professor")
public class Professor extends Pessoa implements Serializable {

    private String email;

    public Professor() {
        super();
    }

    public Professor(Long id, String nome, String cpf, String dataDeNascimento, String email) {
        super(id, nome, cpf, dataDeNascimento);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
