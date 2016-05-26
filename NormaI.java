public class NormaI{
	public static double ni(double[][] A){
		double temp = 0; 
		double rezultati = 0;
		for(int i =0; i< A.length; i++){
			for(int j =0; j<A[0].length; j++){
				temp += Math.abs(A[i][j]);
			}
			if(temp > rezultati){
				rezultati  = temp;
			}
			
			temp = 0;
		
		}
		
		
		return rezultati;
	}
	
	public static void main(String[] args){
		double[][] A = {{2,1,3},
						{3,4,5},
						{-6,7,1}};
		
		double r = ni(A);
		System.out.println(r);
	
	}


}
