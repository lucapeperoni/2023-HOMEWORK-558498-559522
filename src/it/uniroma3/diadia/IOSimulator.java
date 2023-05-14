package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IOSimulator implements IO {
	
	private String comandoNullo = "";
	
	private List<String> inputList;
	private Iterator<String> itInput;
	
	private List<String> outputList;
	
	// Il costruttore crea l'array degli input ricevendoli come parametro
	
	public IOSimulator() {
		this.inputList = new ArrayList<String>();
		this.inputList.add(this.comandoNullo);
		this.itInput = this.inputList.iterator();
		this.outputList = new ArrayList<String>();
	}
	
	public IOSimulator(List<String> listaInput) {
		this.inputList=listaInput;
		this.itInput = inputList.iterator();
		this.outputList = new ArrayList<String>();
	}
	
	public void setListaInput(List<String> listaInput) {
		this.inputList = listaInput;
		this.itInput = inputList.iterator();
	}
	
	public List<String> getInputList(){
		return inputList;
	}
	
	public List<String> getOutputList(){
		return outputList;
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		this.outputList.add(msg);
	}
	
	@Override
	public String leggiRiga() {
		String res = "fine";
		if(itInput.hasNext()) 
			res=itInput.next();
		return res;
	}

}
