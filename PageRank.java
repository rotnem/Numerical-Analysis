/*
 * @autor: Mentor Bibaj
 * @tema: PageRank Algorithm - The Mathematics of Google
 * @komente: Bazuar ne shembullin e cekur ne dokumentin e derguar
 * */
import javax.swing.*;
public class PageRank{
	
	public static double[] produkti(double [][] A, double[] v){
		double[] res = new double[v.length]; 
		double temp;
		
		for(int i = 0; i <A[0].length;i++){
			temp = 0;
			for(int j = 0; j<A.length; j++){
				temp += A[i][j]*v[j];
			}
			res[i] = temp;
			
		}
		return res;
	} 
	
	
	public static void main(String[] args){
		double[][] A = {{0,0,1.0,1.0/2.0},
						{1.0/3.0,0,0,0},
						{1.0/3.0,1.0/2.0,0,1.0/2.0},
						{1.0/3.0,1.0/2.0,0,0}};
		
		double[] v = {1.0/4.0, 1.0/4.0, 1.0/4.0, 1.0/4.0};
		
		double[] produktiAv;
		
		double[] vi = produkti(A,v);
		int prodhimet = new Integer(JOptionPane.showInputDialog(
						"Shenoni nr e Faqeve per llogaritje:")).intValue();
		try{
			for(int i = 0; i<prodhimet; i++){
					vi = produkti(A, vi);
			}
			
			produktiAv = vi;
			System.out.println("PageRank Vector:");
			for(int i =0; i< produktiAv.length; i++)
				System.out.println(produktiAv[i]+" ");
				
		}catch(Exception e){
				System.out.println("Ka ndodhur nje Gabim, shikoni nese keni"+
							" te shenuar ne rregull Matricen A dhe Vektorin v");
		}
  	}
}
