 package br.ce.clertonf.servicos;

import static br.ce.clertonf.matchers.MatchersProprios.caiNumaSegunda;
import static br.ce.clertonf.matchers.MatchersProprios.ehHoje;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.clertonf.entidades.Filme;
import br.ce.clertonf.entidades.Locacao;
import br.ce.clertonf.entidades.Usuario;
import br.ce.clertonf.exceptions.FilmeSemEstoqueException;
import br.ce.clertonf.exceptions.LocadoraException;
import br.ce.clertonf.matchers.MatchersProprios;
import br.ce.clertonf.utils.DataUtils;

public class LocacaoServiceTest {

	private LocacaoService service;

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		service = new LocacaoService();

	}

	@Test // 
	public void deveAlugarFilme() throws Exception {
		//
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); 
		// Cenário

		Usuario usuario = new Usuario("User1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2 ", 1, 5.0));// 2 = dias e 5.0 

		// Ação

		Locacao locacao = service.alugarFilme(usuario, filmes); // Segurando na variável Locacao

		// Verificação
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(locacao.getDataLocacao(), ehHoje());
		error.checkThat(locacao.getDataRetorno(), MatchersProprios.ehHojeComDiferencaDias(1));

	}

	// Estrategia "elegante"
	// Garantir que a excecao seja tratada apenas por aquele motivo

	@Test(expected = FilmeSemEstoqueException.class)
	public void excecaoAoAlugarFilmeSemEstoque() throws Exception {

		// Cenario
		Usuario usuario = new Usuario("User1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2 ", 0, 4.0));

		// Acao
		service.alugarFilme(usuario, filmes);
	}

	// Forma Robusta
	@Test // Checagem do usuário

	public void naoAlugaFilmeSemUsuario() throws FilmeSemEstoqueException {

		// Cenario

		Usuario usuario = new Usuario("User1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2 ", 0, 4.0));

		// Acao
		try {
			service.alugarFilme(null, filmes);
			fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuário vazio"));

		}

	}

	// Forma nova
	@Test // Validar filme

	public void naoAlugaFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {

		// Cenario

		Usuario usuario = new Usuario("User1");

		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");

		// Acao
		service.alugarFilme(usuario, null);

	}

	// Não pode devolver o filme no domingo
	
	@Test
	public void naoDeveDevolverFilmeNoDomingo() throws FilmeSemEstoqueException, LocadoraException {
		//Funciona se hoje for sábado
		assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); 

		//Cenario
		Usuario usuario = new Usuario("User1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme", 1, 5.0));
		
		//Acao
		Locacao retorno = service.alugarFilme(usuario, filmes);
		
		//Verificacao
//		assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
		
		assertThat(retorno.getDataRetorno(), caiNumaSegunda());
	}

}
