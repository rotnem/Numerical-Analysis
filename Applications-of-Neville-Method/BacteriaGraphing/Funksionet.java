/*Referencat: 
 * http://www.regentsprep.org/regents/math/algtrig/atp8b/examplesexponentialfunction.htm*/
public class Funksionet{
	public double bacteriagrowth(double x){
		/*A certain strain of bacteria that is growing on your 
		 * kitchen counter doubles every 5 minutes.  Assuming that you 
		 * start with only one bacterium, how many bacteria could be 
		 * present at the end of 96 minutes?*/
		 
		 /*Formula y= y0*e^(k*t); ku y0 = 1; y = 2; t = 5
		  * Gjejm k = 0.1386294361*/
		  
		 /*Now, form your equation using this k value, 
		  * and solve the problem using the time of 96 minutes.*/
		  
		  /*Ne do te provojme per minuta te ndryshem(x te ndryshem)*/
		  double r = 1*Math.pow(Math.E, 0.1386294361*x);
		  return r;
	}
}
