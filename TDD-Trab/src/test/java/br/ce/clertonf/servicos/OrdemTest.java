package br.ce.clertonf.servicos;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
 
public class OrdemTest {
	
	//Ordem de verificação dos testes em ordem alfabetica
	public static int contador = 0;
	
	@Test
	public void inicio() {
		contador = 1;
	}
	
	@Test
	public void verificar() {
		Assert.assertEquals(1, contador);
	}
	
}
