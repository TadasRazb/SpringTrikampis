package tado;

public class TrikampisMusu extends Trikampis {

	public int ai;
	public int bi;
	public int ci;

	public TrikampisMusu () {
		
	}
	public TrikampisMusu(double k1, double k2, double k3, int k1nr, int k2nr, int k3nr){

		super(k1,k2,k3);
		ai = k1nr;
		bi = k2nr;
		ci = k3nr;
	}

	public String toString(){
		return "trikampis : " + ai + "," + a + " " + bi + "," + b + " " + ci + "," + c + ", S= " + S;
	}
}
 