package no.hvl.data102.filmarkiv.impl;

public class TabellHjelp {
	@SuppressWarnings("unchecked")
	public static <T> T[] utvid(T[] input, int nyStorrelse) {
		T[] utvidet = (T[]) new Object[nyStorrelse]; 
		
		for (int i = 0; i < input.length; i++) {
			utvidet[i] = input[i];
		}
	
		return utvidet;
	}
}
