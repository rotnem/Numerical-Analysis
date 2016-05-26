/*
 * @autor: Mentor Bibaj
 * @tema: Metoda GaussSeidel 
 * @data: 04.13.2016
 * */
import java.text.*;
public class GaussSeidel {
	
	public static double distancaEuklidiane(double[] v1,double[] v2, char tipi){
		double distanca = 0; 
		double temp = 0;
		
		for(int i = 0; i < v1.length ; i++){
			switch(tipi){
				case '2':
					//System.out.println("v1" + v2[i]);
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
	
	public static double[] GaussSeideli(double[][] A, double[] x0, double[] b, int N, double TOL) {
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
				for (int j = i+1; j < n; j++) {
					if (i != j) {
						sum += A[i][j] * x0[j];
					}
				}
				for (int j = 0; j < i-1; j++) {
					if (i != j) {
						sum1 += A[i][j] * x[j];
					}
				}
				x[i] = ((b[i] - (sum+sum1)) / A[i][i]);				
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
		double[][] A = {{ 3,-1,1 }, 
						{ 3, 6,2 }, 
						{ 3,3,7 }}; 
		double[] x0 = {0,0,0};// 
		double[] b = { 1,0,4 };//
		int N = 100; 
		double TOL = Math.pow(10,-6); 
		
		double[] zgjidhja = GaussSeideli(A,x0,b,N,TOL);
		System.out.println("\nZgjidhja e Perafruar e Sistemit me Gauss-Seidel eshte:");
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
