public class Neville{
    public static void main(String[] args)
    {
    	double[] x ={2.0,2.2,2.3}; //{2,6,8,8,12,16,20,20,22,26};//{1,2,3};
    	double[] y = {0.6931,0.7885,0.8329};//{58,105,88,118,117,137,157,169,149,202};//{1,4,9};
     System.out.println(neville (x.length,x,y, 2.1));
}

public static double neville ( int n, double[] x, double[] y, double t ){
	 int i, j;
	 double[] f=new double[n] ; 
	 double total;
	 for ( j = 1; j < n; j++ )
		 for ( i = n-1; i >= j; i-- ) {
			 y[i] = ((t-x[i-j])*y[i] - (t-x[i])*y[i-1] ) / ( x[i] - x[i-j] );
			 System.out.println(y[i]);
		 }
		
	 total = y[n-1];  
	 return ( total );
	}
}
