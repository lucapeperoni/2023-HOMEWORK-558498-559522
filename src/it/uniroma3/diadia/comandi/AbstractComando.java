package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.*;

public abstract class AbstractComando{
	
	private String parametro;
	private IO io;

	public AbstractComando() {}


	abstract public void esegui(Partita partita);
		


	public void setParametro(String parametro) {
		this.parametro = parametro;
	}


	public String getParametro() {
		return this.parametro;
	}

	public void setIo(IO io) {
		this.io = io;
	}


	public IO getIo() {
		return this.io;
	}


	public String getNome() {
		return getClass().getSimpleName();
	}

}
