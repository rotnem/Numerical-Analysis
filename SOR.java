/*
 * @autor: Mentor Bibaj
 * @tema: Metoda SOR 
 * @data: 04.02.2016
 * */
import java.text.*;
public class SOR {
	
	public static double distancaEuklidiane(double[] v1,double[] v2, char tipi){
		double distanca = 0; 
		double temp = 0;
		
		for(int i = 0; i < v1.length ; i++){
			switch(tipi){
				case '2':
					temp += Math.pow(v1[i] - v2[i],2); 
				break;
				
				case 'i':
					if(Math.abs(v1[i] - v2[i]) > temp){
						temp = Math.abs(v1[i] - v2[i]);
					}
				break;
			}
		}
		
		switch(tipi){
			case '2':
				distanca = Math.sqrt(temp);
			break;
			case 'i':
				distanca = temp;
			break;
		}
		return distanca;		
	}
	
	public static double[] SORi(double[][] A, double[] x0, double[] b, double w, int N, double TOL) {
		int n  = A.length;
		int iter = 0;
		double[] x = new double[n];
		double sum;
		double sum1;
		
		loop:
		for(int k = 1; k<N; k++) {
			System.out.println(" ");
			for (int i = 0; i < n; i++) {
				sum = 0;
				sum1 = 0;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sum += A[i][j] * x0[j];
					}
				}
				for (int j = 0; j < i-1; j++) {
					if (i != j) {
						sum1 += A[i][j] * x[j];
					}
				}
				
				x[i] = (1 - w) * x0[i] + (w * (b[i] - (sum+sum1)) / A[i][i]);				
				System.out.print(" x"+(i+1) + "(" + k + ") = " + x[i] + "	\n"); 
				
				if((distancaEuklidiane(x, x0,'2') < TOL) && i == (n-1)){ //2 norma '2'; i norma 'infinit'
					iter = k;
					break loop;
				}
				x0[i] = x[i];
			}	
			//for(int i = 0; i < n; i++)
				
		}
		return x;
	}

	public static void main(String[] args) {
		double[][] A = { { 4, 3, 0 }, 
						 { 3, 4, -1 }, 
						 { 0, -1, 4 } 
						 
						 }; 
		double[] x0 = { 1,1,1}; 
		double w = 1.25; 
		double[] b = { 24,30,-24 };
		int N = 100; 
		double TOL = Math.pow(10,-3); 
		
		double[] zgjidhja = SORi(A,x0,b,w,N,TOL);
		System.out.println("\nZgjidhja e Perafruar e Sistemit me SOR eshte:");
		System.out.print(" x = ( "); 
		
		DecimalFormat df = new DecimalFormat("0.00000");
		for(int i = 0; i < A.length; i++){
				if(i != A.length-1)
					System.out.print(df.format(zgjidhja[i])+", ");
				else
					System.out.print(df.format(zgjidhja[i])+" ");
		}		
		System.out.print(")^t");

	}
}
