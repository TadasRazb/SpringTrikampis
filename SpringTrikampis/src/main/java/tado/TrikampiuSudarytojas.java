package tado;

import java.io.IOException;
import java.util.ArrayList;

public class TrikampiuSudarytojas { 
	
	public AtkarposTest atkarposx;
	public Double[] atkarpos;
	public Double[] atkarpos_pradines;
	public ArrayList<TrikampisVaizd> trikampiai;
	public ArrayList<TrikampisVaizd> trikampiaix;
	public ArrayList<TrikampisVaizd> trikampiaiy;
	public ArrayList<TrikampisVaizd> trikampiaiz;
	public ArrayList<TrikampisVaizd> trikampiaiw;
	public ArrayList<TrikampisVaizd> trikampiai_naujas_sarasas;
	
	public TrikampiuSudarytojas () {
		
	}
	
	public TrikampiuSudarytojas( AtkarposTest atkarposx) {
		
		this.atkarposx = atkarposx;
	}
	
	public void atlikti () throws IOException {
		
		//atkarposx.atiduoti
		atkarpos = atkarposx.atiduotiSarasa();
		int n = atkarposx.n;
		atkarpos_pradines = new Double[n];
		
		for (int i = 0; i < n; i++) {
			
			atkarpos_pradines[i] = atkarpos[i];
		}
		
		atkarpuSpausdinimas (atkarpos, n);
		
		trikampiai = galimiTrikampiai(atkarpos, n);

		int eilNr = 0;
		trikampiaix = new ArrayList<TrikampisVaizd>();
		System.out.println("Galimi trikampiai: " + "\n");
		for (TrikampisVaizd trikampis:trikampiai){
				trikampiaix.add(trikampis);
				System.out.println(eilNr + " " + trikampis.toString());
			eilNr++;
		}
		trikampiaiy = new ArrayList<TrikampisVaizd>();
		System.out.print("Galimi status trikampiai: " + "\n");
		for (TrikampisVaizd trikampis:trikampiai){
			if (trikampis.arStatusis()){
				trikampiaiy.add(trikampis);
				System.out.println(trikampis.toString());
			}
		}
		trikampiaiz = new ArrayList<TrikampisVaizd>();
		System.out.print("Galimi lygiasoniai trikampiai: " + "\n");
		for (TrikampisVaizd trikampis:trikampiai){
			if (trikampis.arLygiasonis()){
				trikampiaiz.add(trikampis);
				System.out.println(trikampis.toString());
			}
		}
		trikampiaiw = new ArrayList<TrikampisVaizd>();
		System.out.print("Galimi lygiakrasciai trikampiai: " + "\n");
		for (TrikampisVaizd trikampis:trikampiai){
			if (trikampis.arLygiakrastis()){
				trikampiaiw.add(trikampis);
				System.out.println(trikampis.toString());
			}
		}
		
		trikampiai_naujas_sarasas = new ArrayList<TrikampisVaizd>(); 
		
		Koordinate[] koord = {
				new Koordinate( 110, 110), new Koordinate ( 210, 110 ), new Koordinate ( 310, 110 ), new Koordinate ( 410, 110 ) 
				, new Koordinate( 110, 210), new Koordinate ( 210, 210 ), new Koordinate ( 310, 210 ), new Koordinate ( 410, 210 )
				, new Koordinate( 110, 310), new Koordinate ( 210, 310 ), new Koordinate ( 310, 310 ), new Koordinate ( 410, 310 )
				, new Koordinate( 110, 410), new Koordinate ( 210, 410 ), new Koordinate ( 310, 410 ), new Koordinate ( 410, 410 )
		};
		
		int i = 0;
		
		while (trikampiai.size()>0) {
			
			int max_index = maxPlotoTrikampioNr(trikampiai);
			System.out.println("didziausias trikampis : " + trikampiai.get(max_index).S);
			System.out.println("jo numeris : " + max_index);
			trikampiai.get(max_index).taskuKoordinates(koord[i].x, koord[i].y);
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
			i++;
		}	
		
		atkarpuSpausdinimas (atkarpos, n);
		
		eilNr = 0;
		
		System.out.println("sudaryti trikampiai: " + "\n");
		for (TrikampisVaizd trikampis:trikampiai_naujas_sarasas){
				System.out.println(eilNr + " " + trikampis.toString());
			eilNr++;
		}
		
	}
	public static int maxPlotoTrikampioNr(ArrayList<TrikampisVaizd> trikampiai) {

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
	private static ArrayList<TrikampisVaizd> galimiTrikampiai(Double[] atkarpos, int n) {

		ArrayList<TrikampisVaizd> trikampiai= new ArrayList<TrikampisVaizd>();

		for (int i = 0; i < n - 2; i++ ) {

			for (int  j = i +1; j < n-1; j++ ) {

				for (int t = j + 1; t < n; t++ ) {

						if (Trikampis.arTrikampis ( atkarpos [ i ], atkarpos [ j ], atkarpos [ t ] )) {
							trikampiai.add(new TrikampisVaizd( atkarpos [ i ], atkarpos [ j ], atkarpos [ t ],i,j,t));

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
