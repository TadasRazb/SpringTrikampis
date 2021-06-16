package tado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTrikampisApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(SpringTrikampisApplication.class, args);
		/*
		System.out.print("Iveskite krastine: ");
		Scanner scan = new Scanner(System.in);
		Double[] atkarpos = new Double[ 20 ];
		Double nuskaityta_atkarpa = scan.nextDouble();
		
		int n = 0;
		while ( nuskaityta_atkarpa != 0 ) {
			System.out.print("Iveskite krastine: ");
			atkarpos[ n ] = nuskaityta_atkarpa;
			n++;
			nuskaityta_atkarpa = scan.nextDouble();
		}
		*/
		AtkarposMusuIsFailo atkarposx = new AtkarposMusuIsFailo();
		
		TrikampiuSudarytojas trikampiu_sudarytojas = new TrikampiuSudarytojas(atkarposx);
		trikampiu_sudarytojas.atlikti();
	}
}