package it.polito.tdp;

import java.util.List;

public class TestRegine {

	public static void main(String args[]) {
		RisolviRegine r = new RisolviRegine();
		
		List <List<Integer>>soluzioni = r.trovaRegine(8);
		System.out.println("ci sono : "+soluzioni.size()+" soluzioni \n");
		System.out.println(soluzioni);

	}
}
