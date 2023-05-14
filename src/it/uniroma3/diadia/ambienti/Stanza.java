package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 *
 * @author docente di POO
 * @see Attrezzo
 * @version base
*/

public class Stanza {

	static final public int NUMERO_MASSIMO_DIREZIONI = 4;
	static final public int NUMERO_MASSIMO_ATTREZZI = 10;


	private List<Attrezzo> attrezzi; // in un futuro si potrà cambiare la scelta del non avere 2 attrezzi uguali
	private Map<String,Stanza> mapStanzeAdiacenti;
	private String nome;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
	
    public Stanza(String nome) {
        this.nome = nome;
        this.mapStanzeAdiacenti = new HashMap<>();
//        this.direzioni = new ArrayList<String>();
//        this.stanzeAdiacenti = new ArrayList<Stanza>();
        this.attrezzi = new ArrayList<Attrezzo> ();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	if(this.mapStanzeAdiacenti.keySet().size()<NUMERO_MASSIMO_DIREZIONI)
    		this.mapStanzeAdiacenti.put(direzione, stanza);
    } 
    
    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
    
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = this.mapStanzeAdiacenti.get(direzione);
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
	
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    
    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    
    public Map<String, Stanza> getMapStanzeAdiacenti(){
    	return mapStanzeAdiacenti;
    }
    
    public int getNumeroAttrezzi() {
    	return attrezzi.size();
    }

    /**
     * Mette un attrezzo nella stanza. Per ipotesi, non si possono avere 2 attrezzi uguali nella stanza
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false altrimenti.
     */

    public boolean addAttrezzo(Attrezzo attrezzo) { // non ammette duplicati
        if (this.attrezzi.size()<NUMERO_MASSIMO_ATTREZZI && !this.attrezzi.contains(attrezzo)) {
        	return this.attrezzi.add(attrezzo);
        }else{
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("Ti trovi qui: \n");
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.getDirezioni())
    		if (direzione!=null)
    			risultato.append(direzione+" ");
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null)
    		risultato.append(attrezzo.toString()+" ");
    	}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/

	public boolean hasAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoDaCercare = new Attrezzo(nomeAttrezzo,0);
		return attrezzi.contains(attrezzoDaCercare);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoDaCercare = new Attrezzo(nomeAttrezzo,0);
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		int index = attrezzi.indexOf(attrezzoDaCercare);
		if(index == -1)
			return null;
		attrezzoCercato=attrezzi.get(index);
		return attrezzoCercato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	
	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoDaCercare = new Attrezzo(nomeAttrezzo,0);
		return attrezzi.remove(attrezzoDaCercare);
	}

	public List<String> getDirezioni() {
		List <String> listaDirezioni = new ArrayList<>(mapStanzeAdiacenti.keySet());
		return listaDirezioni;
    }

	public String stampaDirezioni() {
		StringBuilder direzioni = new StringBuilder();
		for (String direzione : this.getDirezioni()) {
    		if (direzione!=null)
    			direzioni.append(" " + direzione);
		}
		return direzioni.toString();
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome());
	}
}
