package it.polito.tdp;

import java.util.ArrayList;
import java.util.List;

public class RisolviRegine {
	
	public List<List<Integer>> trovaRegine(int N) {//N è la dimensione
		List<Integer>parziale = new ArrayList<Integer>();//preparo una lista
		List<List<Integer>>soluzioni = new ArrayList<List<Integer>>();
		cercaRegine(N, parziale, 0, soluzioni);//avvia la ricorsione: dove metto la prima?: parto da riga 0
		
		return soluzioni;
	}
	/**
	 * @param N e la dimens della scacchiera
	 * @param parziale è l'insieme delle soluz gia presenti
	 * @param riga e la riga in cui devo inserire la regina
	 * il metodo genera le soluzioni possibili per riga
	 */
	private void cercaRegine(int N, List<Integer> parziale, int riga, List<List<Integer>>soluzioni) {
		if(riga == N) {//se ho trovato la soluzione finale la stampo
			soluzioni.add(new ArrayList<Integer>(parziale));
			return;
		}
		
		
		for(int col = 0; col<N; col++) {
			if(reginaCompatibile(parziale, riga, col)) {/*se è possibile metterla su questa colonna*/
				//aggiungi regina alla colonna col della soluz parziale
				parziale.add(col);
				cercaRegine(N,parziale,riga+1, soluzioni);
				parziale.remove(parziale.size()-1);
			}
		}
	}
	
	private boolean reginaCompatibile(List<Integer> parziale, int riga, int colonna) {
		boolean compatibile = true;
		for(int rigaR = 0; rigaR < parziale.size(); rigaR ++) {//rigaR e la riga della regina
			int colR = parziale.get(rigaR);
			if(rigaR == riga)
				return false;
			if(colR == colonna)
				return false;
			if(rigaR-colR == riga-colonna) 
				return false;
			if(rigaR+colR == riga+colonna) 
				return false;
		}
		return compatibile;
	}
}
