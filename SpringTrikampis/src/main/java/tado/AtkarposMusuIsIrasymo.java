package tado;


import java.util.ArrayList;
import java.util.Scanner;

	public class AtkarposMusuIsIrasymo extends AtkarposMusuIsIvedimo {
		
		public AtkarposMusuIsIrasymo() {
			
			super();
			atkarpos = atiduokSarasa();
		}
		public Double[] atiduokSarasa(){
			Scanner scan = new Scanner(System.in);
			Double[] atkarpos = new Double[ 20 ];		
			Double nuskaityta_atkarpa = scan.nextDouble();
					
			int n = 0;
			
			while ( nuskaityta_atkarpa != 0) {
				System.out.print("Iveskite krastine: ");	
				atkarpos[ n ] = nuskaityta_atkarpa;
				n++;
				nuskaityta_atkarpa = scan.nextDouble();
			}
			scan.close();
			this.n = n;
			return atkarpos;
		}	
	}

