package tado;

public class TrikampisVaizd  extends TrikampisMusu {
	
	public double x1, x2, x3, y12, y3;
	public double av, bv, cv;
	
	public TrikampisVaizd () {
		
	}
	
	public TrikampisVaizd (double k1, double k2, double k3, int k1nr, int k2nr, int k3nr) {
		
		super (k1, k2, k3, k1nr, k2nr, k3nr);
	}
	
	public void taskuKoordinates ( double x1, double y12 ) {
		
		this.x1 = x1;
		
		this.y12 = y12;
	
		double dalis1 = - ( ( b * b - a * a - c * c )  / ( 2 * a ) );

		double d = Math.sqrt ( - ( dalis1 * dalis1 - c * c ) );
		
		double a_c = Math.sqrt ( c *c - d * d );
		
		x2 = x1 + a;
		
		y3 = y12 - d;
		
		x3 = x2 - a_c;
	}
	
	public void KoeficientasPerskaiciavimui (double max) {
		
		double koef_perskaiciavimui = 100 / max;
		
			av = a * koef_perskaiciavimui;
			bv = b * koef_perskaiciavimui;
			cv = c * koef_perskaiciavimui; 
	}
}