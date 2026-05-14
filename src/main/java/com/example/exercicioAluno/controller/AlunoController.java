package com.example.exercicioAluno.controller;
import com.example.exercicioAluno.model.Aluno;
import com.example.exercicioAluno.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/escola")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService service;

    // GET /pessoas — lista todas (era case 2 no menu)
    @GetMapping
    public List<Aluno> listar() {
        return service.listar();
    }

    // GET /pessoas/{id} — busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // POST /pessoas — insere (era case 1 no menu)
    @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(service.salvar(aluno));
    }

    // PUT /pessoas/{id} — atualiza (era case 3 no menu)
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(
            @PathVariable Long id, @RequestBody Aluno dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    // DELETE /pessoas/{id} — exclui (era case 4 no menu)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
