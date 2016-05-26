public class HalfLife{
	
	public static Funksionet fn;
	public static NevilleN nv;
	
	public static void main(String[] hlArgs){
		double[] vitet = {30.0,40.0,50.0,70.0,8.0,110.0};
		double[] grams = new double[vitet.length];
		double vlperParashikim = 100.0;
		
		for(int i = 0; i<vitet.length; i++){
			fn = new Funksionet();
			grams[i] = fn.halflife(vitet[i]);
		} 
		
		/*How many grams of the 120 gram sample will remain after x(ex:100) years?*/
		nv = new NevilleN();
		double mbetjet = nv.neville(vitet, grams,vlperParashikim );
		System.out.println("Mbetjet ne gram pas "+vlperParashikim+ " vitesh do te jete '" 
							+mbetjet + " gr'");
	
	}
}
