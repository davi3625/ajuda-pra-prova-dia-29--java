package escolaSpring.config;

import escolaSpring.entities.*;
import escolaSpring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private NotaRepository notaRepository;

    @Override
    public void run(String... args) throws Exception {

        // Professores
        Professor p1 = new Professor(null, "Carlos Silva", "11111111111", "1980-03-20", "carlos@escola.com");
        Professor p2 = new Professor(null, "Maria Souza", "22222222222", "1985-06-10", "maria@escola.com");
        professorRepository.saveAll(Arrays.asList(p1, p2));

        // Alunos
        Aluno a1 = new Aluno(null, "João Pedro", "33333333333", "2005-09-15", "A001");
        Aluno a2 = new Aluno(null, "Ana Clara", "44444444444", "2006-01-22", "A002");
        alunoRepository.saveAll(Arrays.asList(a1, a2));

        // Departamentos
        Departamento d1 = new Departamento(null, "Exatas");
        Departamento d2 = new Departamento(null, "Humanas");
        departamentoRepository.saveAll(Arrays.asList(d1, d2));

        // Matérias
        Materia m1 = new Materia(null, "Matemática", 80, p1);
        Materia m2 = new Materia(null, "História", 60, p2);
        materiaRepository.saveAll(Arrays.asList(m1, m2));

        // Notas
        Nota n1 = new Nota(null, 8.5, a1, m1);
        Nota n2 = new Nota(null, 9.2, a2, m2);
        Nota n3 = new Nota(null, 7.0, a1, m2);
        notaRepository.saveAll(Arrays.asList(n1, n2, n3));

        System.out.println("✅ Dados de teste inseridos com sucesso!");
    }
}
