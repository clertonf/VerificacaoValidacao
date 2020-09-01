package br.ce.clertonf.servicos;

import br.ce.clertonf.exceptions.NaoDivisaoPorZeroException;

public class Calculadora {

	public int somar(int a, int b) {
		
		return a + b;
	}

	public int subtrair(int a, int b) {
		
		return a - b;
	}

	public int multiplicar(int a, int b) {
		
		return a*b;
	}

	public int dividir(int a, int b) throws NaoDivisaoPorZeroException {
		if(b == 0) {
			throw new NaoDivisaoPorZeroException();
		}
		return a/b;
	}

}
