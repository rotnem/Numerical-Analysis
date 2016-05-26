public class Money{
	public static Funksionet fn;
	public static NevilleN nv;
	
	public static void main(String[] monArgs){
		double[] vitet = {2.0,4.0,5.0,7.0,9.0,11.0};
		double[] fitimi = new double[vitet.length];
		double vlperParashikim = 10.0;
		
		for(int i = 0; i<vitet.length; i++){
			fn = new Funksionet();
			fitimi[i] = fn.money(vitet[i]);
		} 
		
		nv = new NevilleN();
		int investimet = (int)(nv.neville(vitet, fitimi,vlperParashikim ));
		System.out.println("Investimet pas "+vlperParashikim+ " vitesh do te jene " 
							+investimet + "$");
	}
}
