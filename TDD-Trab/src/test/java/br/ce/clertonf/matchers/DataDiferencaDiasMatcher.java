package br.ce.clertonf.matchers;

import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import br.ce.clertonf.utils.DataUtils;

public class DataDiferencaDiasMatcher extends TypeSafeMatcher<Date> {

	private Integer quantDias;
	
	public DataDiferencaDiasMatcher(Integer quantDias) {
		this.quantDias = quantDias;
	}
	
	@Override
	public void describeTo(Description description) {
		

	}

	@Override
	protected boolean matchesSafely(Date data) {
		
		return DataUtils.isMesmaData(data, DataUtils.obterDataComDiferencaDias(quantDias));
	}

}
