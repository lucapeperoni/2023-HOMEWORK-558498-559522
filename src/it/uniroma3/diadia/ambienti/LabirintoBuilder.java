package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto maze = null;
	private Stanza stanzaIniziale = null;
	private Stanza stanzaVincente = null;
	private Stanza ultimaStanzaAggiunta = null;
	Map<String,Stanza> listaStanze = null;
	
	public LabirintoBuilder() {
		maze = new Labirinto();
		listaStanze = new HashMap<String,Stanza>();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		stanzaIniziale = new Stanza(nomeStanza);
		ultimaStanzaAggiunta = stanzaIniziale;
		listaStanze.put(nomeStanza, stanzaIniziale);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		stanzaVincente = new Stanza(nomeStanza);
		ultimaStanzaAggiunta = stanzaVincente;
		listaStanze.put(nomeStanza, stanzaVincente);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza nuovaStanza = new Stanza(nomeStanza);
		listaStanze.put(nomeStanza, nuovaStanza);
		ultimaStanzaAggiunta = nuovaStanza;
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza,int sogliaMagica) {
		Stanza nuovaStanzaMagica = new StanzaMagica(nomeStanza,sogliaMagica);
		listaStanze.put(nomeStanza, nuovaStanzaMagica);
		ultimaStanzaAggiunta = nuovaStanzaMagica;
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzioneBloccata, String nomeAttrezzoSbloccante) {
		Stanza nuovaStanzaBloccata = new StanzaBloccata(nomeStanza, direzioneBloccata, nomeAttrezzoSbloccante);
		listaStanze.put(nomeStanza, nuovaStanzaBloccata);
		ultimaStanzaAggiunta = nuovaStanzaBloccata;
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza,String nomeAttrezzoIlluminante) {
		Stanza nuovaStanzaBuia = new StanzaBuia(nomeStanza,nomeAttrezzoIlluminante);
		listaStanze.put(nomeStanza,nuovaStanzaBuia);
		ultimaStanzaAggiunta = nuovaStanzaBuia;
		return this;
	}
	
	/*
	 * Metodo che imposta l'adiacenza tra una stanza di partenza (origine) e una stanza di adiacenza (stanza adiacente).
	 * Il metodo deve essere invocato dopo che entrambe le stanze sono state create e sono presenti
	 * nella mappa "listaStanze" del labirintoBuilder.
	 * @param nome della stanza di partenza
	 * @param nome della stanza adiacente a quella di partenza
	 * @param direzione verso la stanza adiacente
	 */
	
	public LabirintoBuilder addAdiacenza(String nomeStanzaOrigine, String nomeStanzaAdiacente, String direzioneVersoAdiacente) {
		Stanza origine = listaStanze.get(nomeStanzaOrigine);
		Stanza adiacente = listaStanze.get(nomeStanzaAdiacente);
		if(origine!=null && adiacente!=null) {
			origine.impostaStanzaAdiacente(direzioneVersoAdiacente, adiacente);
			return this;
		}else
			return null;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo,int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo,peso);
		ultimaStanzaAggiunta.addAttrezzo(attrezzo);
		return this;
	}
	
	public Map<String,Stanza> getListaStanze() {
		return listaStanze;
	}
	
	public Labirinto getLabirinto() {
		if(ultimaStanzaAggiunta == null)
			return null;
		this.maze.setStanzaIniziale(stanzaIniziale);
		this.maze.setStanzaVincente(stanzaVincente);
		return maze;
	}
}
