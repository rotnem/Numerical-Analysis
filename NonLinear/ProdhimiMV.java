/*
 * @autor: Mentor Bibaj
 * @tema: Metoda e Newtonit per Sistemet Jo Lineare
 * @data: 04.26.2016
 * @tipi: Klase Ndihmese e NonLinear.java per Prodhimin e Matrices Me Vektor
 * */
public class ProdhimiMV{
	public double[] Rezultati(double[][] A, double[] v){
		double[] r = new double[v.length];
		
		for(int i = 0; i < v.length; i++){
			double temp = 0.0;
			for(int j = 0; j< v.length; j++){
				temp += A[i][j]*v[j];
			}
			r[i] = temp;
		}
		
		return r;
		
	}
}
