package tado;

import java.util.ArrayList;

public class TrikampisMusuIsFailo extends TrikampisMusuTest {
	
	public String failo_vardas;
	
	public TrikampisMusuIsFailo() {
		
		super();
	}
	
	public TrikampisMusuIsFailo (String failo_vardas) {
		
		this.failo_vardas = failo_vardas;
	}
	
	public ArrayList<Trikampis> atiduotiSarasa() {
		
		return failo_vardas;
	}
}
