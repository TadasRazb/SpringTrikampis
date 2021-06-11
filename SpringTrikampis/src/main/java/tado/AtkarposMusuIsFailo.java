package tado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AtkarposMusuIsFailo extends AtkarposTest {
	
	public Double[] atkarpos;
	public String failo_vardas;
	public int n;
	
	public AtkarposMusuIsFailo() {
		
		super();
		atkarpos = new Double[20];
	}
	
	public AtkarposMusuIsFailo (String failo_vardas) {
		
		this.failo_vardas = failo_vardas;
	}
	
public Double[] atiduotiSarasa() throws IOException{
		
		File atkarpu_failas = new File("/Users/tadas/Desktop/mvnhello/SpringTrikampis/src/main/java/tado/atkarpos.csv");
        BufferedReader krastines = new BufferedReader( new FileReader(atkarpu_failas) );
        String krastine;  
        Double[] atkarpos = new Double[ 20 ];		
        int n = 0;
        
		while ((krastine = krastines.readLine())!=null) {
			System.out.print("Iveskite krastine: ");	
			atkarpos[ n ] = Double.parseDouble(krastine);
			n++;
		
		}   
		krastines.close();
		
		this.n = n;
		Double[] atkarposx = new Double [n];
		int i = 0;
		
		for (Double atkarpa:atkarpos) {
			atkarposx[i] = atkarpa;
			i++;
		}
		return atkarposx;
	}
}