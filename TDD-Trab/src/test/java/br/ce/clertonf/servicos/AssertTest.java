package br.ce.clertonf.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.clertonf.entidades.Usuario;

public class AssertTest {
	@Test
	public void testandoAsserts() {
//		Assert.assertTrue(false); 
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
	   // Equals checa se o valor é igual ao outro
      //Assert.assertEquals(1, 2);
		Assert.assertEquals(1, 1);
		
		int i = 5;
		Integer i2 = 5;
		// no assertEquals isso não existe se comparar i com i2
		Assert.assertEquals(Integer.valueOf(i), i2 );
		Assert.assertEquals(i, i2.intValue() );
		
		//Strings
		Assert.assertEquals("celular", "celular" );
//		Assert.assertNotEquals("celular", "mesa");
		Assert.assertTrue("celular".equalsIgnoreCase("Celular"));
		Assert.assertTrue("celular".startsWith("ce"));
		
		Usuario user1 = new Usuario("User1");
		Usuario user2 = new Usuario("User1");
		Usuario user3 = null;
		
//		Assert.assertEquals(user1, user2);
//		Assert.assertEquals(user1, user1);
		
		Assert.assertSame(user2, user2);
		Assert.assertNotSame(user1, user2);
		
		Assert.assertNull(user3);
		
		
		
	}
	
}
