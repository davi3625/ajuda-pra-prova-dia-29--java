package escolaSpring.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_nota")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    public Nota() {}

    public Nota(Long id, double valor, Aluno aluno, Materia materia) {
        this.id = id;
        this.valor = valor;
        this.aluno = aluno;
        this.materia = materia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }
}
