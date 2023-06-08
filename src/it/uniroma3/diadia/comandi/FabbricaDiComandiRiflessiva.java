package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione){
		
		Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		StringBuilder costruttoreDiStringhe = new StringBuilder ("it.uniroma3.diadia.comandi.Comando");
		if(nomeComando == null) {
			costruttoreDiStringhe.append("NonValido");
		}
		else {
			costruttoreDiStringhe.append(Character.toUpperCase(nomeComando.charAt(0)));
			costruttoreDiStringhe.append(nomeComando.substring(1));
		}
		
		try {
			Class<?> classeComando = Class.forName(costruttoreDiStringhe.toString());
			comando = (Comando) classeComando.newInstance();
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			comando = new ComandoNonValido();
		}
		comando.setParametro(parametro);
		scannerDiParole.close();
		return comando;
	}
}
