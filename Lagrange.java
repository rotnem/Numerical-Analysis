/*
 * @autor: Mentor Bibaj
 * @tema: Second Lagrange Interpolating Polynomial  
 * @data: 
 * */
public class Lagrange{
	public static double f(double x){
		return 1/x;
	}
	
	public static double mLagrange(double x, double[] xi){
		int n = xi.length;
		double[] L = new double[n];
		double P = 0; 
		
		for(int k = 0;k < n;k++){
			L[k] = 1;
			for(int i = 0; i < n;i++){
				if(k!=i){
					L[k] *=(x-xi[i])/(xi[k]-xi[i]); 
				}
			}
		
		}
		
		for(int i = 0; i < n;i++){
			P += L[i]*f(xi[i]);
		}
		
		return P;
	}

	public static void main(String[] args){
		double x = 1.5; //Vlera qe deshirojme ta gjejme  
		double[] xi = {2.0,2.75,4.0}; 
		double[] s = new double[1];
		
		double res = mLagrange(x,xi);
		System.out.println("Rezultati per Vlerat e dhena: " + res);
	}
}
