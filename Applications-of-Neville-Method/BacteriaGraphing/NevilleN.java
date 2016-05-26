/*@autor: Mentor Bibaj*/
public class NevilleN{
	public static double neville(double[] x, double[] y, double p){
			
			int n = x.length;			
			double[][] M = new double[n][n];
			
			for(int i = 0; i < n; i++){
				M[i][0] = y[i];	
			}
			
			for(int i = 1; i < n; i++){
				for(int j = 1; j<= i; j++){
					double ma1 = M[i][j-1];
					double ma2 = M[i-1][j-1];
					double a1 = (p-x[i-j])*ma1;
					double a2 = (p-x[i])*ma2;
					double a = (a1 - a2);
					double b = (x[i]-x[i-j]);
					M[i][j] = a/b;
				}
			}
			return M[n-1][n-1];
			
	}

}
