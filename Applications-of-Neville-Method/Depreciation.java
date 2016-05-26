public class Depreciation{
	
	public static Funksionet fn;
	public static NevilleN nv;
	
	public static void main(String[] dpcArg){
		/*What will the car be worth in 10 years?*/
		double[] vitet = {5.0,7.0,15.0,20.0};
		double[] vlera = new double[vitet.length];
		double vlperParashikim = 10.0;
		
		for(int i = 0; i<vitet.length; i++){
			fn = new Funksionet();
			vlera[i] = fn.deprecation(vitet[i]);
		} 
		
		nv = new NevilleN();
		int mbetjet = (int)nv.neville(vitet, vlera,vlperParashikim );
		System.out.println("Vlera e Makines pas "+vlperParashikim+ " vitesh do te jete " 
							+mbetjet + "$");
	}
}
