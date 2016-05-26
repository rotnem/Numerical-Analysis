//Autor Mentor Bibaj - Mars 2016
class MatricaInverse{		
	
	static double d(double[][] A){
		double Determinanta;
		double rez = 0;
		double rezD = 0;
		int n = A.length;
		int m = A[0].length;
		double[][] Aprim = new double[n][m-1];
		double[][] Asec = new double[n][2*m-1];
		
		//Shton m-1 kolonat
		for(int i = 0; i<n; i++){
				for(int j=0; j<m-1; j++){
					Aprim[i][j] = A[i][j];
				}
		}
		
		//bashkangjet m-1 kolonat ne nje matric te re
		int countCol = 0;
		for(int i = 0; i < n; i++){
				for(int j = 0; j<Asec[0].length; j++){
						if(j<m){ 
							Asec[i][j] = A[i][j];	
						}else{
							Asec[i][j] = Aprim[i][countCol];
							countCol = countCol + 1;
						}
				}
				countCol = 0;
		}
		
		double sum = 1;
		int countC = 0;
		for(int i = 0; i< Asec.length; i++){
			for(int j=0; j < Asec.length; j++){
				sum *= Asec[j][countC];
				System.out.print(j+""+countC+"="+Asec[j][countC]+" ");
				countC = countC+1;
			}
			rez += sum;
			sum = 1;
			countC = i+1;
			System.out.print(rez);
			System.out.println();
		}
		System.out.println();
		double sumD = 1;
		double dif = 1;
		int countD = Asec.length-1;
		int firstCol = Asec.length-1;
		for(int i = 0; i< Asec.length; i++){
			for(int j=0; j < Asec.length; j++){
				dif *= Asec[j][countD];
				System.out.print(j+""+countD+"=" + Asec[j][countD]+" " );
				countD = countD-1;
			}
			rezD += dif;
			dif = 1;
			countD = firstCol+1;
			firstCol = countD;
			System.out.print(rezD);
			System.out.println();
		}
		System.out.println("rez="+rez);
		System.out.println("rezD="+rezD);
		Determinanta = rez - rezD;
		System.out.println(Determinanta);
		return Determinanta;
	}
	
	static double[][] inversi(double[][] A, double D){
		
		return A;
	}
	
    public static void main(String[] args){
		double[][] Ainv;
		double[][] A = {{2,1,0,1},
			            {1,0,1,2},
			            {2,1,1,1},
			            {1,1,0,2},};/*{{3,2,1,4},//3,2,1
			            {0,5,4,4},//0,5,4
			            {1,2,1,3},//1,2,1
			            {1,1,1,1}//1,1,1
			            };*/
		double D = d(A);
		
		/*
		if(A.length != A[0].length && D == 0){
			System.out.println("Nuk ka zgjedhje");
			System.exit(0);
		}else{
			Ainv = inversi(A, D);
			for(int i = 0; i< Ainv.length; i++){
					for(int j = 0; j< Ainv[0].length; j++){
							System.out.print(Ainv[i][j]+" ");
					}
					System.out.println();
			}
			
		}
		*/
	}
}
