
public class Population{
	
	public static Funksionet fn;
	public static NevilleN nv;
	
	public static void main(String[] popArgs){
		double[] vitet = {1.0,2.0,3.0,4.0,7.0,8.0,9.0};
		double[] popullata = new double[vitet.length];
		double vlperParashikim = 5.0;
		
		for(int i = 0; i<vitet.length; i++){
			fn = new Funksionet();
			popullata[i] = fn.population(vitet[i]);
			System.out.println(popullata[i]);
		} 
		
		nv = new NevilleN();
		int nrBanoreve = (int)(nv.neville(vitet, popullata,vlperParashikim ));
		System.out.println("Numri i Banoreve pas "+vlperParashikim + " vitesh eshte " 
							+nrBanoreve);
	}
}
