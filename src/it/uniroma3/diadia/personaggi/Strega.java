package it.uniroma3.diadia.personaggi;

import java.util.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.*;

public class Strega extends AbstractPersonaggio {
	
	private Map<String, Attrezzo> attrezzi;
	private static final String MESSAGGIO = "Oh no la strega ti ha trasferito in un'altra stanza!!";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		this.attrezzi = new HashMap<>();
	}

	@Override
	public String agisci(Partita partita) {
		Map <Direzione, Stanza> mappa =  partita.getStanzaCorrente().getStanzeAdiacenti();
		Stanza s2 = null;
		
		if(!this.haSalutato()) {
			for(Stanza s : mappa.values()) {
				if(s2==null) {
					s2 = s;
				}
				else {
					if(s.getAttrezzi().size() < s2.getAttrezzi().size()) {
						s2 = s;
					}
				}
			}
		}
		else {
			for(Stanza s : mappa.values()) {
				if(s2==null) {
					s2 = s;
				}
				else {
					if(s.getAttrezzi().size() > s2.getAttrezzi().size()) {
						s2 = s;
					}
				}
			}
		}
		partita.setStanzaCorrente(s2);
			
		return MESSAGGIO;
	}
	
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		IO io = partita.getConsole();
		if(attrezzo!=null) {
			attrezzi.put(attrezzo.getNome(), attrezzo);
			io.mostraMessaggio("hihihihi\n");
			return attrezzo.getNome();
		}
		return null;
	}

}
