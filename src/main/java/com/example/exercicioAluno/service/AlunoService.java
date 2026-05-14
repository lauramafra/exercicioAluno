package com.example.exercicioAluno.service;
import com.example.exercicioAluno.model.Aluno;
import com.example.exercicioAluno.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor

public class AlunoService {

    private final AlunoRepository repository;
    // READ — listar todas (era listar() no PessoaDAO)
    public List<Aluno> listar() {
        return repository.findAll();
    }
    // READ — buscar por ID
    public Aluno buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
    // CREATE — inserir (era inserir() no PessoaDAO)
    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }
    // UPDATE — atualizar (era atualizar() no PessoaDAO)
    public Aluno atualizar(Long id, Aluno dados) {
        Aluno aluno = buscarPorId(id);
        aluno.setNome(dados.getNome());
        aluno.setCurso(dados.getCurso());
        aluno.setMatricula(dados.getMatricula());
        return repository.save(aluno);
    }
    // DELETE — excluir (era excluir() no PessoaDAO)
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

