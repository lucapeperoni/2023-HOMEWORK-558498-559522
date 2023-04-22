package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};
	static final private String[] elencoDirezioni = {"nord", "sud", "ovest", "est"};
	static final private String[] prendiAttrezzo = {"prendi <nomeAttrezzo>"};
	static final private String[] posaAttrezzo = {"posa <nomeAttrezzo>"};
	private IO io; 
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	
	@Override
	public void esegui(Partita partita) {
		this.io = partita.getIo();
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
		for(int i=0; i< elencoDirezioni.length; i++) 
			io.mostraMessaggio(elencoDirezioni[i]+" ");
		io.mostraMessaggio("");		
		for(int i=0; i< prendiAttrezzo.length; i++) 
			io.mostraMessaggio(prendiAttrezzo[i]+" ");
		io.mostraMessaggio("");
		for(int i=0; i< posaAttrezzo.length; i++) 
			io.mostraMessaggio(posaAttrezzo[i]+" ");
		io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public void getParametro() {

	}

	@Override
	public void getNome() {
	}
}
