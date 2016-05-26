public class BacteriaGrowth{
	
	public static Funksionet fn;
	public static NevilleN nv;
	public static GraphingBacteria gb;
	
	public static void main(String[] bgArgs){
		double[] minutat = {35.0,43.0,52.0,73.0,84.0,91.0,95.0,98.0};
		double[] bakterie = new double[minutat.length];
		double vlperParashikim = 96.0;
		
		for(int i = 0; i<minutat.length; i++){
			fn = new Funksionet();
			bakterie[i] = fn.bacteriagrowth(minutat[i]);
			//System.out.println(bakterie[i]);
		} 
		
		nv = new NevilleN();
		double nrBakterieve = (nv.neville(minutat, bakterie,vlperParashikim));
		System.out.println("Supozojme se nje bakterie ne kuzhine dyfishohet qdo 5 minuta, duke startuar me nje, pas "
							+vlperParashikim+ " minutash numri i baktereve(bazuar ne funksion) do te jete do te jete " 
							+nrBakterieve );
		
		//Pjesa e Vizatimit:
		double[] allMinutat = new double[minutat.length+1];
		double[] allBakterie = new double[minutat.length+1];
 		for(int i = 0; i < allMinutat.length; i++){
			if(i == allMinutat.length-1){
				allMinutat[i] = vlperParashikim;
				allBakterie[i] = nrBakterieve;
			}else{
				allMinutat[i] = minutat[i];
				allBakterie[i] = bakterie[i];
			}
		}	
		allMinutat = sortMe(allMinutat);		
		allBakterie = sortMe(allBakterie);		

		gb = new GraphingBacteria();
		gb.main(allMinutat, allBakterie, nrBakterieve, vlperParashikim);
	}
	
	public static double[] sortMe(double[] m){
		double temp = 0.0;
		
		for (int i = 1; i < m.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(m[j] < m[j-1]){
                    temp = m[j];
                    m[j] = m[j-1];
                    m[j-1] = temp;
                }
            }
        } 
        return m;
	} 
} 
