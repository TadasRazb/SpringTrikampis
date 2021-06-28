package tado;

public class Trikampis{

	public double a;
	public double b;
	public double c;
 	public double p;
 	public double S;

	public Trikampis(){}

	public Trikampis(double k1, double k2, double k3){
		a = k1;
		b = k2;
		c = k3;
		p = (a + b + c)/2; //p = pusperimetris
		S = Math.sqrt(p*(p - a)*(p - b)*(p - c));
	}

	public boolean arTrikampis() {
		return (((a + b) > c) && ((b + c) > a) && ((c + a) > b));
	}

	public static boolean arTrikampis(double a, double b, double c) {
		return (((a + b) > c) && ((b + c) > a) && ((c + a) > b));
	}
	public boolean arLygiasonis() {
		return ((a == b ) || (a == c) || (b == c));
	}

	public static boolean arLygiasonis(double a, double b, double c) {
		return ((a == b ) || (a == c) || (b == c));
	}
	public  boolean arStatusis() {
		return (((a*a)+(b*b)==(c*c)) || ((a*a)+(c*c)==(b*b)) || ((c*c)+(b*b)==(a*a)));
	}
	public static boolean arStatusis(double a, double b, double c) {
		return (((a*a)+(b*b)==(c*c)) || ((a*a)+(c*c)==(b*b)) || ((c*c)+(b*b)==(a*a)));
	}
	public boolean arLygiakrastis() {
		return ((a == b) && (a == c) && (b == c));
	}
	public static boolean arLygiakrastis(double a, double b, double c) {
		return ((a == b) && (a == c) && (b == c));
	}
	public double plotas () {
		return S;
	}
	public double max() {
		double maxx = 0;

		if  ( (a > b) && (a > c) ) {
			maxx = a;
		}
		if ((b > a) && (b > c)) {
			maxx = b;
		}
		if ((c > a) && (c > b)) {
			maxx = c;
		}
		return maxx;
	}
	
}
