package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.ConfigurazioniIniziali;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;



public class Borsa {
	
	static final public int DEFAULT_PESO_MAX_BORSA = ConfigurazioniIniziali.getPesoMax();
	private Map <String,Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.attrezzi.size()==10)
			return false;
		attrezzi.put(attrezzo.getNome(),attrezzo);
		return true;
	}
	
	
	public int getPesoMax() {
		return pesoMax;
	}
	

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		int peso = 0;
		Collection <Attrezzo> attrezzi = this.attrezzi.values();
		Iterator <Attrezzo> iteratore = attrezzi.iterator();
		while(iteratore.hasNext())
			peso += iteratore.next().getPeso();

		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/*funzione che rimuove un attrezzo dalla borsa del giocatore e restituisce l'attrezzo tolto*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String getDescrizione() {
		return this.toString();
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoRagguppatoPerPeso()+" ");
		}

		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> a = new LinkedList<>();
		ComparatorePerPeso cmp = new ComparatorePerPeso();
		a.addAll(this.attrezzi.values());
		Collections.sort(a,cmp);
		return a;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatorePerNome cmp = new ComparatorePerNome();
		SortedSet<Attrezzo> a = new TreeSet<Attrezzo>(cmp);
		a.addAll(this.attrezzi.values());
		return a;
	}
	
	public Map<Integer,List<Attrezzo>> getContenutoRagguppatoPerPeso(){
		ComparatorePerPeso cmp = new ComparatorePerPeso();
		Map<Integer, List<Attrezzo>> map = new HashMap<Integer,List<Attrezzo>>();
		for(Attrezzo attrezzo : this.attrezzi.values()) {
			List<Attrezzo> temp = map.get(attrezzo.getPeso());
		if(temp == null) {
			temp = new ArrayList<Attrezzo>();
		}
		
		temp.add(attrezzo);
		map.put(attrezzo.getPeso(), temp);
		Collections.sort(temp,cmp);
		
		}
		
		return map;
	}
	
	
}

