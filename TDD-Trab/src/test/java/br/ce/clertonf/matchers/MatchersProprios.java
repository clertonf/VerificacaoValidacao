package br.ce.clertonf.matchers;

import java.util.Calendar;

public class MatchersProprios {
	
	public static DiaSemanaMatcher caiEm(Integer diaSemana)	{
		
		return new DiaSemanaMatcher(diaSemana);
	}
	
	public static DiaSemanaMatcher caiNumaSegunda() {
		return new DiaSemanaMatcher(Calendar.MONDAY);
	}
	
	public static DataDiferencaDiasMatcher ehHojeComDiferencaDias(Integer quantDias) {
		return new DataDiferencaDiasMatcher(quantDias);
	}
	
	public static DataDiferencaDiasMatcher ehHoje() {
		return new DataDiferencaDiasMatcher(0); // Hoje seria 0 dias
	}
}
