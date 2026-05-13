package com.example.CalcAtividade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OperacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double n1;
    private Double n2;
    private String operador;
    private Double result;

    public OperacaoModel() {}

    public OperacaoModel(Long id, Double n1, Double n2, String operador, Double result) {
        this.id = id;
        this.n1 = n1;
        this.n2 = n2;
        this.operador = operador;
        this.result = result;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getN1() { return n1; }
    public void setN1(Double n1) { this.n1 = n1; }

    public Double getN2() { return n2; }
    public void setN2(Double n2) { this.n2 = n2; }

    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }

    public Double getResult() { return result; }
    public void setResult(Double result) { this.result = result; }
}
