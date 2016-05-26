/*
 * @autor: Mentor Bibaj
 * @tema: Metoda e Newtonit per Sistemet Jo Lineare
 * @data: 04.26.2016
 * @udhezim: Ju duhet te shenoni Ekuacionin ne metoden f, si dhe
 * 			 derivatin e ketij ekuacioni ne metoden deriv duke u bazuar
 *  		 qe x0[0](eshte e panjohura e pare),
 * 				x0[1](eshte e panjohura e dyte) e keshtu me radhe
 * */
public class NonLinear{
	
	public static Inversi n;
	public static ProdhimiMV m;
	
	public static double[] NewtonNonLinear(double[] x0, int N,double TOL){
		double[] x = new double[x0.length];
		
		for(int k = 1; k<=N; k++){
			
			double[] yi = y(x0);
			for(int i = 0; i < x0.length; i++){	
				x[i] = x0[i] + yi[i];  
			}
			
			if(norma('2',yi)<TOL){
				System.out.println("\nProcedura perfundoi pas " + k + " iteracioneve.");
				break;
			}
			
			//ruajtja e vlerave te tanishme ne x0
			for( int j = 0 ;j < x0.length; j++){
				System.out.print("x["+j+"]= " + x[j] + "; ");
				x0[j] = x[j];
			}
			System.out.println();
			
			
		}
		
		return x; 
	}
	
	public static double norma(char tipi, double[] v1){
		double distanca = 0; 
		double temp = 0;
		
		for(int i = 0; i < v1.length ; i++ ){
			switch(tipi){
				case '2':
					temp += Math.pow(v1[i],2); 
				break;
				
				case 'i':
					if(Math.abs(v1[i]) > temp){
						temp = Math.abs(v1[i]);
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
	
	
	public static double[] y(double[] x0){
		//Gjetja e vleres se prodhimit te matrices Jacobiane me funksionet
		//sipas x0
		
		double[] yi = new double[x0.length];
		double[][] jacobi = fInv(x0);
		double[] funksionet = f(x0);
		m = new ProdhimiMV();
		double[] prodhimet = m.Rezultati(jacobi,funksionet);
		
		for(int i = 0; i < x0.length; i++) 
			yi[i] = -prodhimet[i];
			
		return yi;
	}
	
	public static double[] f(double[] x0){
		double[] x = new double[x0.length];
	
		for(int i = 0; i < x0.length; i++)
			x[i] = x0[i];
			
		//parakusht per plotesimin e elementeve eshte qe gjatesia e d-se te jete sa x0	
		double[][] d = /*
			{{x[0]*x[0],x[1],0,-37},
			{x[0],-x[1]*x[1],0,-5},
			{x[0],x[1],x[2],-3}};*/
			{{4*x[0]*x[0], - x[1]*x[1]*x[1],28},
			{3*x[0]*x[0]*x[0],4*x[1]*x[1],-145}};
			
		for(int i = 0; i < d.length; i++){
			double temp = 0.0;
			for(int j = 0; j <d[0].length; j++){
				temp += d[i][j];
			}
			x[i] = temp; 
		}
		return x;
	}
	
	public static double[][]  deriv(double[] x0){
		//derivatet sipas x0,x1,x2
		/*double[][] d = {{-2*x0[0],1,0},
						{1,-2*x0[1],0},
						{1,1,1}};
			*/
			
		double[][] d = {{8*x0[0], -3*x0[1]*x0[1]},
						{9*x0[0]*x0[0],8*x0[1]}};				
		return d;
	}
	
	public static double[][] fInv(double[] x0){
		n = new Inversi();
		double[][] inversi = n.startInv(deriv(x0));
		
		return inversi;
	}
	
	public static void main(String[] args){
		double[] x0 = {1,1};//{0,0,0};
		int N = 100;
		double TOL = Math.pow(10,-3);
		
		double[] x = NewtonNonLinear(x0,N,TOL);
		System.out.println("Zgjidhjet e perafruara jane: ");
		System.out.print("x = ( ");
		for(int i =0; i<x0.length;i++)
			System.out.print(x[i]+" ");
		System.out.print(")^t");
		
	}
}
