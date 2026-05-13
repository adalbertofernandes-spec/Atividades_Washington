package com.example.CalcAtividade.controller;

import com.example.CalcAtividade.dto.CalcRequest;
import com.example.CalcAtividade.model.OperacaoModel;
import com.example.CalcAtividade.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;


    @PostMapping
    public ResponseEntity<?> calcular(@RequestBody CalcRequest request) {
        try {
            OperacaoModel resultado = calculadoraService.calcular(request);
            return ResponseEntity.ok(resultado);
        } catch (ArithmeticException | IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("erro", e.getMessage()));
        }
    }


    @GetMapping("/historico")
    public ResponseEntity<List<OperacaoModel>> listarHistorico() {
        return ResponseEntity.ok(calculadoraService.listarHistorico());
    }

    @DeleteMapping("/historico/{id}")
    public ResponseEntity<?> excluirOperacao(@PathVariable Long id) {
        try {
            calculadoraService.excluirOperacao(id);
            return ResponseEntity.ok(Map.of("mensagem", "Operação #" + id + " removida com sucesso."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        }
    }

    @DeleteMapping("/historico")
    public ResponseEntity<?> limparHistorico() {
        calculadoraService.limparHistorico();
        return ResponseEntity.ok(Map.of("mensagem", "Histórico limpo com sucesso."));
    }
}
