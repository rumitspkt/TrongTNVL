import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;

public class listOval extends JPanel{
	private static final long serialVersionUID = 1L;
	public static double tiLeECong;
	public static double doCong;
	public static double maxSpeed;
	//Color color = Color.green;
	Random rand=new Random();
     LinkedList<oval>o=new LinkedList<>();
     oval ov;
    public void paint(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<o.size();i++)
        {
            ov=o.get(i);
            ov.paint(g2);
        }
    }
    public void addoval(oval block)
    {
        o.add(block);
    }
    public void removeoval(oval block)
    {
        o.remove(block);
    }
    
    public void move()
    {
    	
    	double bkNgoai;
    	double bkTrong;
    	int length = o.size();
    	//System.out.println(length);
        for(int i=0;i< (int)(length * this.tiLeECong);i++)
        {
        	ov=o.get(i);       
            bkNgoai = (Math.pow(ov.x - 375, 2) + Math.pow(ov.y - 275, 2)) - (215 * 215);
            if(bkNgoai > 0) {
            	o.remove(ov);
            	o.addFirst(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225));
            	ov = o.get(0);
            }           
            bkTrong = (Math.pow(ov.x - 375, 2) + Math.pow(ov.y - 275, 2)) - (80 * 80);
            if(bkTrong > 0) {
            	ov.isFirstTime = false;
            }
           
            if(bkTrong <= 0 && !ov.isFirstTime) {
            	o.remove(ov);
            	o.addFirst(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225));
            	
            }
            ov.move(doCong);        	           
        }
        for(int i = (int)(length * this.tiLeECong); i < length; i++) {
        	ov = o.get(i);
        	//System.out.print(ov.dx2); debug
        	//System.out.println(ov.dy2);
        	bkNgoai = (Math.pow(ov.x - 375, 2) + Math.pow(ov.y - 275, 2)) - (215 * 215);
            if(bkNgoai > 0) {
            	o.remove(ov);
            	o.addLast(new oval(rand.nextInt(100) + 325,rand.nextInt(100) + 225));
            	ov = o.get(length - 1);
            	//color = Color.red;
            }
            ov.move2();
        }
    }
}
