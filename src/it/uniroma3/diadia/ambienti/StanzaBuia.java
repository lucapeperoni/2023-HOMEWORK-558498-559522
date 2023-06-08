package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;

public class StanzaBuia extends Stanza{
	
	private String attrezzoMagico;
	

	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoMagico = attrezzo;
	}

	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (!attrezzo.getNome().equals(attrezzoMagico)&&!this.hasAttrezzo(attrezzoMagico)) {
			this.getDescrizione();
			return false;
		}
		else {
			return super.addAttrezzo(attrezzo);
		}
	}
	
	@Override
	 public String getDescrizione() {
        return this.toString();
    }
	
	@Override
	public String toString() {
		Map<String, Attrezzo> attrezzi = this.getAttrezzi();
		StringBuilder risultato = new StringBuilder();
		if(hasAttrezzo("lanterna")) {
			risultato.append("Finalmente puoi vedere dove ti trovi!\n");
			risultato.append(this.getNome());
			risultato.append("\nUscite: ");
			risultato.append(" " +this.getDirezioni());
			risultato.append("\nAttrezzi nella stanza: ");
			risultato.append(attrezzi.keySet()+" ");
			risultato.append("\nPersonaggi nella stanza: ");
			risultato.append(this.getPersonaggio().getNome());
		}
		else {
			risultato.append("Qui c'è un buio pesto!");
		}
		return risultato.toString();
	}
	
}
	
