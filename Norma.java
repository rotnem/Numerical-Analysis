import javax.swing.*;
public class Norma{
	public static double[][] A;
	public static double[][] B;
	public static double[] v1;
	public static double[] v2;
	
	public static void mbushV1(int r){
		for(int i = 0 ; i < r ; i++)
			v1[i] = new Double(JOptionPane.showInputDialog("Sheno Elementin ["+(i+1)+"] te vekt. v1")).doubleValue();
			
	}
	
	public static void mbushV2(int r){
		for(int i = 0 ; i < r ; i++)
			v2[i] = new Double(JOptionPane.showInputDialog("Sheno Elementin ["+(i+1)+"] te vekt. v2")).doubleValue();
	}
	
	public static void mbushA(int r){
		for(int i = 0; i< r;i++){
				for(int j = 0 ; j < r ; j++)
					A[i][j] = new Double(JOptionPane.showInputDialog("Sheno Elementin ["+(i+1)+"]["+(j+1)+"] te Matr. A")).doubleValue();
			
		}
	}
	
	public static void mbushB(int r){
		for(int i = 0; i< r;i++){
				for(int j = 0 ; j < r ; j++)
					B[i][j] = new Double(JOptionPane.showInputDialog("Sheno Elementin ["+(i+1)+"]["+(j+1)+"] te Matr. B")).doubleValue();
			
		}
	}
	
	public static double[] mzVektoret(char tipi){
		double[] v3 = new double[v1.length];
		for(int i = 0; i < v1.length; i++){
			switch(tipi){
				case '-':
					v3[i] = v1[i] - v2[i];
					break;
				case '+':
					v3[i] = v1[i] + v2[i];
					break;
			}	 
		}
		return v3;
	}
	
	public static double distancaEuklidiane(char tipi){
		double distanca = 0; 
		double temp = 0;
		
		for(int i = 0; i < v1.length ; i++ ){
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
	
	public static double normat(char tipi){
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
	
	public static double normaFrobenius(){
			double temp = 0;
			for(int i = 0; i< A.length; i++){
					for(int j = 0; j < A.length; j++){
						temp =temp + A[i][j]*A[i][j];
					}
			}
			return Math.sqrt(temp);
	}
	
	public static void shfaqVektoret(){
		System.out.print("Vektori v1: [" );
		for(int i = 0; i < v1.length; i++){
				System.out.print(" "+ v1[i]);
		}
		System.out.println("]");
		
		System.out.print("Vektori v2: [" );
		for(int i = 0; i < v2.length; i++){
				System.out.print(" "+ v2[i]);
		}
		System.out.println("]");
		System.out.println("---------------------");
	}
	
	public static void shfaqMatricat(){
		System.out.println("Matrica A:\n");
		for(int i = 0; i< A.length; i++){
			System.out.print("|");
			for(int j = 0; j < A[0].length; j++){
				System.out.print(A[i][j]);
				if(j != A[0].length -1){
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
		
		System.out.println();
		
		
		System.out.println("Matrica B:\n");
		for(int i = 0; i< B.length; i++){
			System.out.print("|");
			for(int j = 0; j < B[0].length; j++){
				System.out.print(B[i][j]);
				if(j != B[0].length -1){
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
		
		System.out.println();
		System.out.println("---------------------");
		
		
	}
	
	
	public static void main(String[] args){
		//String tipi = JOptionPane.showInputDialog("Sheno tipin M ose V");
		//if(tipi.equals("M")){
		int rendi = new Integer(JOptionPane.showInputDialog("Sheno rendin e Matrices(Sheno 0 nese nuk ka)")).intValue();
		int rendiv = new Integer(JOptionPane.showInputDialog("Sheno rendin e Vektorit(Sheno 0 nese nuk ka)")).intValue();
		double[] shumavC = new double[rendiv]; // Shuma e vektoreve
		double[] zbritjavC = new double[rendiv]; //Zbritja e vektoreve
		
		A = new double[rendi][rendi];
		B = new double[rendi][rendi];
			
		mbushA(rendi);
		mbushB(rendi);
		
		//}else{
		v1 = new double[rendiv];
		v2 = new double[rendiv];
			
		mbushV1(rendiv);
		mbushV2(rendiv);		
		//}
		
		shfaqVektoret();
		shfaqMatricat();
		
		shumavC = mzVektoret('+');
		System.out.print("Shuma e Vektoreve v1 dhe v2 eshte: [");
		for(int i = 0; i < rendiv; i++){
			System.out.print(" " + shumavC[i]);
		}
		System.out.println("]");
	
		zbritjavC = mzVektoret('-');
		System.out.print("Zbritja e Vektoreve v1 dhe v2 eshte: [");
		for(int i = 0; i < rendiv; i++){
			System.out.print(" " + zbritjavC[i]);
		}
		System.out.println("]");
		
		System.out.println("l2 norma e v1 eshte: ["+ normat('2') + "]\nlinfinit norma e v1 eshte: ["+normat('i')+"]");
		System.out.println("Distanca Euklidiane l2 norma eshte: [" +distancaEuklidiane('2') + "]");
		System.out.println("Distanca Euklidiane linfit norma eshte: [" + distancaEuklidiane('i') + "]");
		System.out.println("Norma Frobenius per matr. A eshte: " +normaFrobenius());
	}

}
