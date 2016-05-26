/*Testim te vlerave nga Libri per te vertetuar se Metoda Neville
 * e dizajnuar punon ne rregull*/
public class TestimMetodaNeville{
	public static NevilleN nv;
	public static void main(String[] args){
		double[] x = {2.0,2.2,2.3};
		double[] y = {0.6931,0.7885,0.8329};
		
		double r =  nv.neville(x, y,2.1);
		System.out.println(r);
		
		double gabimiAbs = Math.abs(r-Math.log(2.1));
		System.out.println("Gabimi Absolut gjate parashikimit me vlerat reale nga Funksioni eshte: " + gabimiAbs);
	
	}

}
