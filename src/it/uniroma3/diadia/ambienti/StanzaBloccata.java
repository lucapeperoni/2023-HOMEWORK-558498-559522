package it.uniroma3.diadia.ambienti;

import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	
	private String attrezzoMagico;
	private Direzione direzioneBloccata;

	public StanzaBloccata(String nome, String attrezzo, Direzione direzione) {
		super(nome);
		this.attrezzoMagico = attrezzo;
		this.direzioneBloccata = direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
        Stanza prossimaStanza = null;
        Set<Direzione> direzioni = this.getDirezioni();
        Map<Direzione, Stanza> stanze = this.getStanzeAdiacenti();
 
        if(!direzione.equals(direzioneBloccata) || (this.hasAttrezzo(attrezzoMagico))){
        	for(Direzione d : direzioni) {
        		if (d.equals(direzione)) {
        			prossimaStanza = stanze.get(direzione);
        		}
        	}
        }
        else {
        	if(direzione.equals(direzioneBloccata)&&(!this.hasAttrezzo(attrezzoMagico))){
        		prossimaStanza = this;
        	}
        }
        
        return prossimaStanza;
	}
	
	@Override
	 public String getDescrizione() {
       return this.toString();
   }
	
	@Override
	public String toString() {
		Map<String, Attrezzo> attrezzi = this.getAttrezzi();
		StringBuilder risultato = new StringBuilder();
		if(!hasAttrezzo(attrezzoMagico)) {
			risultato.append("Una delle uscite è bloccata, ti serve la chiave!!\n");
			risultato.append(this.getNome());
			risultato.append("\nUscite: ");
			for (Direzione direzione : this.getDirezioni())
				if (direzione!=null)
					risultato.append(" " + direzione.getNome());
			risultato.append("\nAttrezzi nella stanza: ");
			risultato.append(attrezzi.keySet()+" ");
			if(this.getPersonaggio()!=null) {
				risultato.append("\nPersonaggi nella stanza: ");
				risultato.append(this.getPersonaggio().getNome());
			}
		}
		else {
			risultato.append(this.getNome());
			risultato.append("\nUscite: ");
			for (Direzione direzione : this.getDirezioni())
				if (direzione!=null)
					risultato.append(" " + direzione.getNome());
			risultato.append("\nAttrezzi nella stanza: ");
			risultato.append(attrezzi.keySet()+" ");
			if(this.getPersonaggio()!=null) {
				risultato.append("\nPersonaggi nella stanza: ");
				risultato.append(this.getPersonaggio().getNome());
			}
		}
		return risultato.toString();
	}


}

