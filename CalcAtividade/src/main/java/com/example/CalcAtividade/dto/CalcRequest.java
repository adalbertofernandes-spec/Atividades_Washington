package com.example.CalcAtividade.dto;

public class CalcRequest {
    private Double n1;
    private Double n2;
    private String operador;

    public CalcRequest() {
    }

    public CalcRequest(Double n1, Double n2, String operador) {
        this.n1 = n1;
        this.n2 = n2;
        this.operador = operador;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
