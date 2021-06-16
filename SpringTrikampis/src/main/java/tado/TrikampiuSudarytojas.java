package tado;

import java.io.IOException;
import java.util.ArrayList;

public class TrikampiuSudarytojas { 
	
	public AtkarposTest atkarposx;
	public Double[] atkarpos;
	
	public TrikampiuSudarytojas () {
		
	}
	
	public TrikampiuSudarytojas( AtkarposTest atkarposx) {
		
		this.atkarposx = atkarposx;
	}
	
	public void atlikti () throws IOException {
		
		//atkarposx.atiduoti
		atkarpos = atkarposx.atiduotiSarasa();
		int n = atkarposx.n;
		
		atkarpuSpausdinimas (atkarpos, n);
		
		ArrayList<TrikampisMusu> trikampiai= galimiTrikampiai(atkarpos, n);

		int eilNr = 0;

		System.out.println("Galimi trikampiai: " + "\n");
		for (TrikampisMusu trikampis:trikampiai){
				System.out.println(eilNr + " " + trikampis.toString());
			eilNr++;
		}
		System.out.print("Galimi status trikampiai: " + "\n");
		for (TrikampisMusu trikampis:trikampiai){
			if (trikampis.arStatusis()){
				System.out.println(trikampis.toString());
			}
		}
		System.out.print("Galimi lygiasoniai trikampiai: " + "\n");
		for (TrikampisMusu trikampis:trikampiai){
			if (trikampis.arLygiasonis()){
				System.out.println(trikampis.toString());
			}
		}
		System.out.print("Galimi lygiakrasciai trikampiai: " + "\n");
		for (TrikampisMusu trikampis:trikampiai){
			if (trikampis.arLygiakrastis()){
				System.out.println(trikampis.toString());
			}
		}
		
		ArrayList<TrikampisMusu> trikampiai_naujas_sarasas = new ArrayList<TrikampisMusu>(); 
		
		while (trikampiai.size()>0) {
			
			int max_index = maxPlotoTrikampioNr(trikampiai);
			System.out.println("didziausias trikampis : " + trikampiai.get(max_index).S);
			System.out.println("jo numeris : " + max_index);
			trikampiai_naujas_sarasas.add(trikampiai.get(max_index));
			
			int pirmas_trinamas = trikampiai.get(max_index).ai;
			int antras_trinamas = trikampiai.get(max_index).bi;
			int trecias_trinamas = trikampiai.get(max_index).ci;
			
			int tarpinis;
			
			if ((antras_trinamas > pirmas_trinamas) && (antras_trinamas > trecias_trinamas) ) {
				
				tarpinis = pirmas_trinamas;
				
				pirmas_trinamas = antras_trinamas;
				
				antras_trinamas = tarpinis;
				
			} else {
				
				if ((trecias_trinamas > pirmas_trinamas) && (trecias_trinamas > antras_trinamas) ) {
					
					tarpinis = pirmas_trinamas;
					
					pirmas_trinamas = trecias_trinamas;
					
					trecias_trinamas = tarpinis;
				}
			}
			
			if (trecias_trinamas > antras_trinamas) {
				
				tarpinis = antras_trinamas;
				
				antras_trinamas = trecias_trinamas;
				
				trecias_trinamas = tarpinis;
			}
			
			n = pakeistiElementus ( atkarpos, n, pirmas_trinamas); //trina pirma panaudota trikampio krastine
			n = pakeistiElementus ( atkarpos, n, antras_trinamas); //trina antrra panaudota trikampio krastine
			n = pakeistiElementus ( atkarpos, n, trecias_trinamas); //trina trecia panaudota trikampio krastine
			
			trikampiai = galimiTrikampiai(atkarpos, n);
		}	
		atkarpuSpausdinimas (atkarpos, n);
		
		eilNr = 0;
		
		System.out.println("sudaryti trikampiai: " + "\n");
		for (TrikampisMusu trikampis:trikampiai_naujas_sarasas){
				System.out.println(eilNr + " " + trikampis.toString());
			eilNr++;
		}
		
	}
	public static int maxPlotoTrikampioNr(ArrayList<TrikampisMusu> trikampiai) {

		int max_ploto_trikampio_nr = 0;

		int i = 0;
		double max = trikampiai.get(0).S; 

		System.out.print("Didziausi trikampiai: " + "\n");
		for (i = 0; i < trikampiai.size(); i++ ) {
			if ( trikampiai.get(i).S > max) {
				max_ploto_trikampio_nr = i;
				max = trikampiai.get(i).S; 
			}
		}
		return max_ploto_trikampio_nr;
	}
//metodas, kuris sudaro trikampiu array lista
	private static ArrayList<TrikampisMusu> galimiTrikampiai(Double[] atkarpos, int n) {

		ArrayList<TrikampisMusu> trikampiai= new ArrayList<TrikampisMusu>();

		for (int i = 0; i < n - 2; i++ ) {

			for (int  j = i +1; j < n-1; j++ ) {

				for (int t = j + 1; t < n; t++ ) {

						if (Trikampis.arTrikampis ( atkarpos [ i ], atkarpos [ j ], atkarpos [ t ] )) {
							trikampiai.add(new TrikampisMusu( atkarpos [ i ], atkarpos [ j ], atkarpos [ t ],i,j,t));

					}
				}
			}
		}
		return trikampiai;
	}
	
	public static void atkarpuSpausdinimas (Double atkarpos[], int n) {
		System.out.println("ivestos atkarpos : ");
		int atkarposNr = 0;
		while (atkarposNr < n) {
			System.out.println(atkarposNr + " " + atkarpos[atkarposNr]);
			atkarposNr++;
		}
	}
	
	public static int pakeistiElementus (Double atkarpos[], int n, int ismetamo_nr ) {
		for ( int i = ismetamo_nr; i < n; i++) {
			atkarpos[i] = atkarpos[i+1];
		}
		n--;
		return n;
	}
}
