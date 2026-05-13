package com.example.CalcAtividade.service;

import com.example.CalcAtividade.dto.CalcRequest;
import com.example.CalcAtividade.model.OperacaoModel;
import com.example.CalcAtividade.repository.OperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraService {

	@Autowired
	private OperRepository operRepository;

	public OperacaoModel calcular(CalcRequest request) {
		Double n1 = request.getN1();
		Double n2 = request.getN2();
		String operador = request.getOperador();

		// RF06 – Validar entradas inválidas
		if (n1 == null || n2 == null || operador == null || operador.isBlank()) {
			throw new IllegalArgumentException("Parâmetros inválidos. Informe n1, n2 e operador.");
		}

		double resultado;

		switch (operador) {
			case "+" -> resultado = somar(n1, n2);           // RF01
			case "-" -> resultado = subtrair(n1, n2);        // RF02
			case "*" -> resultado = multiplicar(n1, n2);     // RF03
			case "/" -> resultado = dividir(n1, n2);         // RF04 + RF05
			case "%" -> resultado = porcentagem(n1, n2);
			case "^" -> resultado = potencia(n1, n2);
			case "sqrt" -> resultado = raizQuadrada(n1);
			default -> throw new IllegalArgumentException("Operador desconhecido: " + operador);
		}

		OperacaoModel operacao = new OperacaoModel();
		operacao.setN1(n1);
		operacao.setN2(n2);
		operacao.setOperador(operador);
		operacao.setResult(resultado);

		return operRepository.save(operacao); // RF09
	}

	// RF01
	private double somar(double n1, double n2) {
		return n1 + n2;
	}

	// RF02
	private double subtrair(double n1, double n2) {
		return n1 - n2;
	}

	// RF03
	private double multiplicar(double n1, double n2) {
		return n1 * n2;
	}

	// RF04 + RF05
	private double dividir(double n1, double n2) {
		if (n2 == 0) {
			throw new ArithmeticException("Divisão por zero não é permitida.");
		}
		return n1 / n2;
	}

	// Porcentagem: n1 * n2 / 100
	private double porcentagem(double n1, double n2) {
		return n1 * n2 / 100;
	}

	// Potenciação: n1 ^ n2
	private double potencia(double n1, double n2) {
		return Math.pow(n1, n2);
	}

	// Raiz quadrada (usa apenas n1)
	private double raizQuadrada(double n1) {
		if (n1 < 0) {
			throw new IllegalArgumentException("Não é possível calcular raiz quadrada de número negativo.");
		}
		return Math.sqrt(n1);
	}

	// RF10 – Exibir histórico
	public List<OperacaoModel> listarHistorico() {
		return operRepository.findAll();
	}

	// Excluir uma entrada do histórico por ID
	public void excluirOperacao(Long id) {
		if (!operRepository.existsById(id)) {
			throw new IllegalArgumentException("Operação com ID " + id + " não encontrada.");
		}
		operRepository.deleteById(id);
	}

	// Excluir todo o histórico
	public void limparHistorico() {
		operRepository.deleteAll();
	}
}
