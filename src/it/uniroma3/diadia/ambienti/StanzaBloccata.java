package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.attrezzoSbloccante))
			return this;		
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.attrezzoSbloccante)) {
			String messaggio = "La stanza Ã¨ bloccata.\nDirezione bloccata: " + this.direzioneBloccata
					+ ".\nServe un attrezzo particolare " + "per sbloccarla.\nAttrezzo per sbloccare la stanza: "
					+ this.attrezzoSbloccante;
			return messaggio;
		}
		return this.toString();
	}

}
