public class Adverstiements{
	
	public static Funksionet fn;
	public static NevilleN nv;
	
	public static void main(String[] adsArgs){
		/*Sa klikime(pelqime) do te arrijme pas investimeve me 25$ ne nje 
		 * rrjet ne internetduke u bazuar ne te dhenat paraprake dhe funksionit 
		 * qe kemi gjetur me ato te dhena*/
		double[] investimet = {10.0,20.0,30.0,40.0,50.0};
		double[] klikimet = new double[investimet.length];
		double vlperParashikim = 25.0;
		
		for(int i = 0; i<investimet.length; i++){
			fn = new Funksionet();
			klikimet[i] = fn.deprecation(investimet[i]);
		} 
		
		nv = new NevilleN();
		int klikime = (int)nv.neville(investimet, klikimet,vlperParashikim );
		System.out.println("Vlera e klikimeve(pelqimeve) pas investimeve me "+vlperParashikim
							+ "$ supozohet te jete " +klikime+" klikime(pelqime)");
	}
}
