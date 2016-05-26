import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphingBacteria extends JPanel {
    private static double[] data;//= {35,43,52,73,84,91,95,98};
    private static double[] res;//= {127,388,1351,24833,114104,301124,524287,794672};
    private static double vleraNeville;
    private static double parashikimiX;
    final int PAD = 20;
    final int PD = 30;
	private static mkv m = new mkv();
    protected void paintComponent(Graphics g) {
		vleraNeville = m.eq(res,getHeight()-PD,vleraNeville);
		parashikimiX = m.eq(data,getWidth()-PD,parashikimiX);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.green);
        g2.drawString("Rritja e Bakterieve(ne y)", 30,30);               
        int w = getWidth();
        int h = getHeight();
        g2.drawString("Minutat(ne x)",w-100,h-30);
        // Draw ordinate.
        g2.setPaint(Color.black);
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        
        // Mark data points.
        double[] x = new double[data.length];
        double[] y = new double[data.length];
        for(int i = 0; i < data.length; i++) {
            x[i] = m.eq(data,w-PD,data[i]);
            //System.out.println(x[i] + " xi "  + data[i]);
        }
        int c = 0;
        for(int i = data.length-1; i>=0;i--){
			y[c] = m.eq(res,h-PD,res[i]); 
			// Vlera e maksimumit e zbritur me PD per ta gjet nje 
			//lartesi me te mire brenda kornizave
			//System.out.println(y[c] + " resi "  + res[i]);
			c= c+ 1;
		}
		c = 0;
		
		for(int i = 0; i<data.length;i++){
			/*if(x[i] != parashikimiX){*/
				g2.setPaint(Color.red);
				g2.fill(new Ellipse2D.Double(x[i]-2, y[i]-2, 4, 4));
				g2.drawString((int)res[i]+"b; ",(int)(x[i]-19), (int)(y[i]-2));
			/*}else{
				g2.setPaint(Color.blue);
				g2.fill(new Ellipse2D.Double(x[i]-2, y[i]-2, 8, 8));
				g2.drawString((int)res[i]+"b; ",(int)(x[i]-19), (int)(y[i]-2));
				System.out.println("Hello");
			}*/
		}
    }

    public void main(double[] minutat,double[] bakterie, double vleraNeville, double parashikimiX) {
		data = minutat;
		res = bakterie;
		
		JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphingBacteria());
        f.setSize(400,400);
        f.setTitle("Bakteriet");
        f.setLocation(200,200);
        f.setVisible(true);
        

		this.vleraNeville = vleraNeville;
		this.parashikimiX = parashikimiX;
	}
}
