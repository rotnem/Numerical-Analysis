/*Referencat: 
 * http://www.regentsprep.org/regents/math/algtrig/atp8b/examplesexponentialfunction.htm*/
public class Funksionet{
	public double population(double x){
		/* The population of the popular town of 
		 * Smithville in 2003 was estimated to be 
		 * 35,000 people with an annual rate of increase 
		 * (growth) of about 2.4%.*/
		 
		 /*r is the population;  
		  * x is the number of years since 2003 
		  * Equation to model future growth:*/
		double r = 35000*Math.pow(1.024,x); 
		return r;
	}
	
	public double money(double x){
		/*Marisa invests $300 at a bank that offers 5% compounded 
		 * annually.*/
		
		/* r is the money;  
		 * x is the number of years since the initial investment 
		*Equation to model the growth of the investment:*/
		double r = 300*Math.pow(1.05,x);
		return r; 
	}
	
	public double deprecation(double x){
		/*Matt bought a new car at a cost of $25,000.  
		 * The car depreciates approximately 15% of its value each year.*/
		 
		/*Equation to model the decay value of this car:*/
		
		double r = 25000*Math.pow(0.85,x);
		return r;
	}
	
	public double halflife(double x){
		/*Radium-226, a common isotope of radium, has a half-life 
		 * of 1620 years.  Professor Korbel has a 120 gram sample 
		 * of radium-226 in his laboratory. */
		 
		 /*Constant of proportionality for radium-226:
		  * Formula: y= y0*e^(k*t); ku y = 60; y0 = 120 dhe t = 1620
		  * Gjejm k= -0.000427868629975*/
		 
		 /*How many grams of the 120 gram sample will remain after x
		  * (fillo nga vitet 100-shembulli real nga referenca) years?*/
		  
		  /*Ne do te provojme per vite te ndryshme(x te ndryshem)*/
		  
		  double r = 120*Math.pow(Math.E,(-0.000427868629975*x));
		return r;
	}
	
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
	
	public double adverstiements(double x){
		/*Do te provojme nje ekuacione 
		 * qe ka parashikuar investimet e nje kompanie dhe 
		 * perfitimet ne klikime(pelqime)*/
		double r = 1194.797371424364+2.1540207880818274*x;
		return r;
	}
}
