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
	
		double dalis1 = - ( ( bv * bv - av * av - cv * cv )  / ( 2 * av ) );

		double d = Math.sqrt ( - ( dalis1 * dalis1 - cv * cv ) );
		
		double a_c = Math.sqrt ( cv * cv - d * d );
		
		x2 = x1 + av;
		
		y3 = y12 - d;
		
		x3 = x2 - a_c;
	}
	
	public void normintiKrastines (double koef_perskaiciavimui) {
		
			av = a * koef_perskaiciavimui;
			bv = b * koef_perskaiciavimui;
			cv = c * koef_perskaiciavimui; 
	}
	
	public String toString() {
		
		String str = super.toString();
		str += "\n + av, bv, cv: " + av + ", " + bv + ", " + cv + "\n";
		str += "x1, y12, x2, x3, y3: " + x1 + ", " + y12 + ", " + x2 + ", " + x3 + ", " + y3 + "\n";
		return str;
	}
}