package tado;


import java.io.IOException;
import java.util.Scanner;

	public class AtkarposMusuIsIrasymo extends AtkarposTest {
		
		public AtkarposMusuIsIrasymo() {
			
			super();
		//	atkarpos = atiduokSarasa();
		}
		public Double[] atiduotiSarasa() throws IOException {
			System.out.println("pradedam ivedima is klaviaturos: ");
			Scanner scan = new Scanner(System.in);
			atkarpos = new Double[ 20 ];		
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

