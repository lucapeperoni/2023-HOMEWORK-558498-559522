package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {
	public void esegui(Partita partita);
	//Perché è necessario avere setParametro()? Il parametro viene passato nel costruttore del comando.
	//Possibili futuri utilizzi dove i comandi vengono istanziati una sola volta?
	public void setParametro(String param);
	public String getNome();
	public String getParametro();
}
