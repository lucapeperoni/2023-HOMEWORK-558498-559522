package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	Labirinto builder;
	public static Map<String, Direzione> possibili = Labirinto.getPossibiliDirezioni();;
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
	//public Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
	public Labirinto()  {
//		this.possibili = Labirinto.getPossibiliDirezioni();
		//CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		//c.carica();
		//this.stanzaIniziale = c.getStanzaIniziale();
		//this.stanzaVincente = c.getStanzaVincente();
		
	}
	
	
	public Labirinto creaStanze() { //throws FileNotFoundException, FormatoFileNonValidoException {
		this.builder = newBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("atrio", "croccantini", 1)
				.addAttrezzo("atrio","lanterna",3)
				.addMago("Merlino", "penna",1)
				.addStanzaVincente("biblioteca")
				.addStanzaBloccata("laboratorio campus", "chiave", possibili.get("est"))
				.addAttrezzo("laboratorio campus","chiave", 1)
				.addAttrezzo("laboratorio campus","roccia", 5)
				.addCane("Cerbero")
				.addStanzaBuia("aula N11","lanterna")
				.addStrega("Sabrina")
				.addStanzaMagica("aula N10")
				.addAttrezzo("aula N10","spada", 5)
				.addAttrezzo("aula N10","bastone", 3)
				.addAttrezzo("aula N10","piuma", 1)
				.addAdiacenza("atrio", "biblioteca", possibili.get("nord"))
				.addAdiacenza("atrio", "laboratorio campus", possibili.get("ovest"))
				.addAdiacenza("atrio", "aula N11", possibili.get("est"))
				.addAdiacenza("atrio", "aula N10", possibili.get("sud"))
				.addAdiacenza("aula N11", "laboratorio campus",possibili.get("est"))
				.addAdiacenza("aula N11", "aula N10", possibili.get("sud"))
				.addAdiacenza("aula N10", "laboratorio campus", possibili.get("sud"))
				.getLabirinto();
//		
//		
//		setStanzaIniziale(new Stanza("atrio"));
//		setStanzaVincente(new Stanza("biblioteca"));
//		
		return this.builder;
	}
	
	public static Map<String, Direzione> getPossibiliDirezioni(){
		Map<String, Direzione> possibiliDirezioni = new HashMap<>();
		possibiliDirezioni.put("nord", Direzione.NORD);
		possibiliDirezioni.put("est",Direzione.EST);
		possibiliDirezioni.put("sud",Direzione.SUD);
		possibiliDirezioni.put("ovest",Direzione.OVEST);
		
		return possibiliDirezioni;
	}
	
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza inizio) {
		this.stanzaIniziale = inizio;
	}
	
	public void setStanzaVincente(Stanza vincente) {
		this.stanzaVincente = vincente;
	}
	
	public Labirinto getLabirinto() {
		return this.builder;
	}
	
	public static class LabirintoBuilder {

		private Labirinto labirinto;
		List<String> nomiAttrezzi;
		private Map<String, Stanza> stanze;
		private Stanza ultimaStanzaAggiunta;
		private static final String PRESENTAZIONE_MAGO = " Sono un mago molto potente! Accetto i regali ma ancora di più mi piace farli, interagisci con me e scoprirai che intendo";
		private static final String PRESENTAZIONE_STREGA = " Sono una strega molto permalosa sarà meglio che mi saluti prima di interagire o te ne pentirai";
		private static final String PRESENTAZIONE_CANE = " Scappate tutti non c'è cane più feroce di me!!! Wooof woooof grrrrr grrrr";


		public LabirintoBuilder() { 
			this.labirinto = new Labirinto();
			this.stanze = new HashMap<>();
			this.nomiAttrezzi = new ArrayList<>();
		}

		public LabirintoBuilder addStanzaIniziale(String nome) {
			Stanza stanzaIniziale = new Stanza (nome);
			this.labirinto.setStanzaIniziale(stanzaIniziale);
			this.stanze.put(nome, stanzaIniziale);
			this.ultimaStanzaAggiunta=stanzaIniziale;
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nome) {
			Stanza stanzaVincente = new Stanza (nome);
			this.labirinto.setStanzaVincente(stanzaVincente);
			this.ultimaStanzaAggiunta=stanzaVincente;
			this.stanze.put(nome, stanzaVincente);
			return this;
		}

		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.stanze.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addMago(String nomeMago, String nomeAttrezzo, int peso) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo,peso);
			AbstractPersonaggio mago = new Mago(nomeMago, PRESENTAZIONE_MAGO, attrezzo);
			if(this.ultimaStanzaAggiunta.getPersonaggio()==null) {
				this.ultimaStanzaAggiunta.setPersonaggio(mago);
			}
			return this;
		}

		public LabirintoBuilder addStrega(String nomeStrega) {
			AbstractPersonaggio strega = new Strega(nomeStrega, PRESENTAZIONE_STREGA);
			if(this.ultimaStanzaAggiunta.getPersonaggio()==null) {
				this.ultimaStanzaAggiunta.setPersonaggio(strega);
			}
			return this;
		}

		public LabirintoBuilder addCane(String nomeCane) {
			AbstractPersonaggio cane = new Cane(nomeCane, PRESENTAZIONE_CANE);
			if(this.ultimaStanzaAggiunta.getPersonaggio()==null) {
				this.ultimaStanzaAggiunta.setPersonaggio(cane);
			}
			return this;
		}


		public LabirintoBuilder addAttrezzo(String stanza, String nomeAttrezzo,int peso) {
			String attrezzo = new String(nomeAttrezzo);
			Attrezzo daAggiungere = new Attrezzo(nomeAttrezzo,peso);
			if(!this.nomiAttrezzi.contains(attrezzo)) {
				this.stanze.get(stanza).addAttrezzo(daAggiungere);
				this.nomiAttrezzi.add(attrezzo);
			}

			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzo, Direzione direzione) {
			StanzaBloccata stanza = new StanzaBloccata(nome, attrezzo, direzione);
			this.stanze.put(nome, stanza);
			this.ultimaStanzaAggiunta=stanza;
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzo) {
			StanzaBuia stanza = new StanzaBuia(nome, attrezzo);
			this.stanze.put(nome,stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			StanzaMagica stanza = new StanzaMagica(nome);
			this.stanze.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this;
		}

		public LabirintoBuilder addAdiacenza(String partenza, String arrivo, Direzione direzione) {
			this.stanze.get(partenza).impostaStanzaAdiacente(direzione, this.stanze.get(arrivo));
			//String direzioneOpposta = getDirezioneOpposta(direzione);
			this.stanze.get(arrivo).impostaStanzaAdiacente(direzione.opposta(), this.stanze.get(partenza));
			return this;
		}

		public boolean checkIfExists(String nomeStanza) {
			for(String s: stanze.keySet()) {
				if(s.equals(nomeStanza)) {
					return true;
				}
			}
			return false;
		}

	}

}
