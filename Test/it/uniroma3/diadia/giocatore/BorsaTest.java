package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;

public class BorsaTest {
	
	private static final String ATTREZZO = "attrezzoDiTest";
	private static final String ATTREZZO2 = "attrezzoDiTest2";
	private static final int MAXPESO = 10;
	private static final int PESO = 1;
	
	private Borsa borsa;
	
	

	@Before
	public void setUp(){
		this.borsa = new Borsa();
		
	}
	
	@Test
	public void testAddAttrezzoBorsa() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,PESO);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,this.borsa.getAttrezzo(ATTREZZO));		
		
	}
	
	
	@Test
	/*mi aspetto che l'attrezzo non venga aggiunto alla borsa perchè troppo pesante*/
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,MAXPESO+1);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}
	
	
	@Test
	public void testGetAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,PESO);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,this.borsa.getAttrezzo(ATTREZZO));
	}
	
	
	@Test
	public void testGetAttrezzoNonPresente() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	

	@Test
	public void testHasAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,PESO);
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	
	@Test
	public void testHasAttrezzoNonPresente() {
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	
	@Test
	public void testRemoveAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,PESO);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,borsa.removeAttrezzo(ATTREZZO));
	}
	
	
	@Test
	public void testRemoveAttrezzoNonEsistente() {
		assertNull(borsa.removeAttrezzo(ATTREZZO));
	}
	
	
	@Test
	public void testPesoTotaleBorsa() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,PESO);
		Attrezzo attrezzo2 = new Attrezzo(ATTREZZO2,PESO+1);
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo2);
		assertEquals(attrezzo.getPeso()+attrezzo2.getPeso(),this.borsa.getPeso());
	}
	
	@Test
	public void testOrdinamentoPerPeso() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO,PESO);
		Attrezzo attrezzo2 = new Attrezzo(ATTREZZO2,PESO+1);
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo2);
		assertEquals("[attrezzoDiTest, attrezzoDiTest2]",this.borsa.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	public void testOrdinamentoPerNome() {
		Attrezzo attrezzo = new Attrezzo("1_primoAttrezzo",PESO);
		Attrezzo attrezzo2 = new Attrezzo("3_terzoAttrezzo",PESO);
		Attrezzo attrezzo3 = new Attrezzo("2_secondoAttrezzo",PESO);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals("[1_primoAttrezzo, 2_secondoAttrezzo, 3_terzoAttrezzo]",this.borsa.getContenutoOrdinatoPerNome().toString());
	}
	
	@Test
	public void testOrdinamentoPerPesoTraAttrezziConStessoPeso() {
		Attrezzo attrezzo = new Attrezzo("1_primoAttrezzo",PESO);
		Attrezzo attrezzo2 = new Attrezzo("3_terzoAttrezzo",PESO);
		Attrezzo attrezzo3 = new Attrezzo("2_secondoAttrezzo",PESO);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals("[1_primoAttrezzo, 2_secondoAttrezzo, 3_terzoAttrezzo]",this.borsa.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	public void testRaggruppmentoPerPesoTraAttrezziConStessoPeso() {
		Attrezzo attrezzo = new Attrezzo("1_primoAttrezzo",PESO);
		Attrezzo attrezzo2 = new Attrezzo("3_terzoAttrezzo",PESO);
		Attrezzo attrezzo3 = new Attrezzo("2_secondoAttrezzo",PESO);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals("{1=[1_primoAttrezzo, 2_secondoAttrezzo, 3_terzoAttrezzo]}",this.borsa.getContenutoRagguppatoPerPeso().toString());
	
	}
	
	@Test
	public void testRaggruppmentoPerPesoTraCoppieDiAttrezzi() {
		Attrezzo attrezzo = new Attrezzo("1_primoAttrezzo",PESO);
		Attrezzo attrezzo2 = new Attrezzo("3_terzoAttrezzo",PESO+1);
		Attrezzo attrezzo3 = new Attrezzo("2_secondoAttrezzo",PESO);
		Attrezzo attrezzo4 = new Attrezzo("4_quartoAttrezzo",PESO+1);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo4);
		assertEquals("{1=[1_primoAttrezzo, 2_secondoAttrezzo], 2=[3_terzoAttrezzo, 4_quartoAttrezzo]}",this.borsa.getContenutoRagguppatoPerPeso().toString());
	
	}

	
}
	
