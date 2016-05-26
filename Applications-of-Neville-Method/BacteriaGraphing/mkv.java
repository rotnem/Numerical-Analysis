/*
 * Mars 2016 (c) Mentor Bibaj 
 * Email: mentorbibaj@hotmail.com 
 * Per Lenden: ANALIZA E TE DHENAVE
*/
public class mkv{ //Metoda e katroreve me te vegjel
	
	public double eq(double[] x0,int maxWH, double x){//Metoda e Katroreve me te Vegjel//vw0
		//maxWH = maksimumi Width(gjersis) dhe Height(lartesis)
		double[] xi = new double[2];
		double[] yi = new double[2];
		xi[0] = x0[0];
		xi[1] = x0[x0.length-1];
			
		yi[0] = 30;
		yi[1] = maxWH;
			
		double sumxi = xi[0] + xi[1]; 
		double sumyi = yi[0] + yi[1]; 
			
		double xv = sumxi/xi.length;
		double yv = sumyi/yi.length;
		
		double atemp=0;
		double btemp=0;
		for(int i = 0; i < xi.length; i++){
				atemp += (xi[i] - xv)*(yi[i]-yv);
				btemp += Math.pow((xi[i]-xv),2);
		}
		double b1 = atemp/btemp;
		double b0 = yv - b1*xv;
			
		double r = b0 + b1*x;
		return r;
	}
}
