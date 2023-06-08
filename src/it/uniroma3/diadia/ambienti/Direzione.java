package it.uniroma3.diadia.ambienti;



public enum Direzione {

	   NORD("nord") {
		@Override public Direzione opposta() { return SUD; }
	}, EST("est") {
		@Override public Direzione opposta() { return OVEST; }
	}, SUD("sud") {
		@Override public Direzione opposta() { return NORD; }
	}, OVEST("ovest") {
		@Override public Direzione opposta() { return EST; }
	};
	
	

	private String nome;
	
	
	private Direzione(String nome) {
		this.nome = nome;
	}

	


	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return la direzione opposta alla presente
	 */
	public abstract Direzione opposta();


}
