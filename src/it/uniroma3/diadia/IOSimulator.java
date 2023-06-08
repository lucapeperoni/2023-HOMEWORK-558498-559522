package it.uniroma3.diadia;

import java.util.Arrays;
import java.util.*;

public class IOSimulator implements IO {
	
	private List<String> righeDaLeggere;
	private List<String> messaggiProdotti;
	

	
	public IOSimulator(String[] righeDaLeggere) {
		List<String> temp = Arrays.asList(righeDaLeggere);
		this.righeDaLeggere = new ArrayList<>(temp);
		this.messaggiProdotti = new LinkedList<>();
	}
	
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(messaggio);
		
	}

	@Override
	public String leggiRiga() {
		if(!this.righeDaLeggere.isEmpty()) {
			return this.righeDaLeggere.remove(0);
		}
		return null;
	}
	
	
	public String nextMessaggio() {
		if(hasNextMessaggio()) {
			return this.messaggiProdotti.remove(0);
		}
		return null;
	}
	
	
	public boolean hasNextMessaggio() {
		return !this.messaggiProdotti.isEmpty();
	}

}
