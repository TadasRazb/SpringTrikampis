package tado;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.FileReader;
import java.io.File;


public class AtkarposMusuIsFailo extends AtkarposTest {
	
	File atkarpu_failas = new File("atkarpos.csv");
	
	public String failo_vardas;
	
	public AtkarposMusuIsFailo() {
		
		super();
		atkarpos = new Double[20];
	}
	
	public AtkarposMusuIsFailo (String failo_vardas) {
		
		this.failo_vardas = failo_vardas;
	}
	
public Double[] atiduotiSarasa() throws IOException{
		
	//BufferedReader reader = new BufferedReader ( new InputStreamReader (System.in ) ); 		
	//String vardas_failo = reader.readLine();
	atkarpos = new Double[ 20 ];
	//if ( vardas_failo.length() == 0 ) {
	
		String vardas_failo = "atkarpos.csv";
	//}
	
	BufferedReader br = new BufferedReader( new FileReader( vardas_failo ) );
	String atkarpu_skaiciai = br.readLine();
	String[] atkarpu_skaiciaix = atkarpu_skaiciai.split ( "," ); 
	
	int n = 0;
	
	Double atkarpu_skaiciaiy = 0.0;
	
	while ( n < atkarpu_skaiciaix.length ) {
		
		Double atkarpu_skaiciaiz = Double.parseDouble ( atkarpu_skaiciaix [ n ] );
		atkarpos[ n ] = atkarpu_skaiciaiz;
		n++;
	}
	this.n = n;
	return atkarpos;
	/*
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
		*/
	}
}