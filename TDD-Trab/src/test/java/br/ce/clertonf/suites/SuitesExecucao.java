package br.ce.clertonf.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.clertonf.servicos.CalculoValorLocacaoTest;
import br.ce.clertonf.servicos.LocacaoService;
import br.ce.clertonf.servicos.LocacaoServiceTest;

//@RunWith(Suite.class)
@SuiteClasses({
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class
})

public class SuitesExecucao {
	
}
