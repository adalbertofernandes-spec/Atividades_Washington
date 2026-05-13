package com.example.CalcAtividade.model;

public class CalculadoraModel {

    public double somar (double a, double b) {return a  + b;}

    public double subtrair (double a, double b) {return a  - b;}

    public double multiplicar (double a, double b) {return a  * b;}


    public double dividir (double a, double b) {
        if (b == 0){
            throw new ArithmeticException("Erro : Divisão por zero não permitida");
        }
        return a / b;
    }

    public double procentagem (double a , double b) { return a  * (b / 100) ;}

    public double potencia(double a , double b) { return Math.pow (a , b);}

    public double RaizQuadrada (double a ){
        if (a < 0 ) {
            throw new ArithmeticException("Erro: Raiz quadrada de numero negativo não permitido");
        }
        return Math.sqrt(a);
    }


}
