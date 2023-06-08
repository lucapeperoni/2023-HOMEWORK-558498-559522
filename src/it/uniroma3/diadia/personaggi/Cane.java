package it.uniroma3.diadia.personaggi;

import java.util.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class Cane extends AbstractPersonaggio {

	private static final String PREFERITO = "croccantini";
	private static final String REGALO = "osso";
	private static final String msg = "Attento!! Il cane ti ha appena morso! Ora hai una vita in meno";

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu()-1;
		partita.getGiocatore().setCfu(cfu);
		return msg;
	}


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo!=null) {
			if(attrezzo.getNome().equals(PREFERITO) && !partita.CaneHaDonato()) {
				Attrezzo nuovo = new Attrezzo(REGALO, 2);
				partita.getStanzaCorrente().addAttrezzo(nuovo);
				partita.SetCaneHaDonato();
			}

			else {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				this.agisci(partita);
			}
		}
		return null;
	}

}
