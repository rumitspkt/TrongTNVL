import javax.swing.JFrame;
import javax.swing.Timer;
public class FrameElectron extends JFrame {
	private static final long serialVersionUID = 1L;
	Timer timer;
	public FrameElectron(int soLuongE, double tiLeECong, double doCong, double maxSpeed)
    {
        bai2 b2=new bai2(soLuongE, tiLeECong, doCong, maxSpeed);
        this.setSize(800,600); 
        setResizable(false);        
        setVisible(true);
        setLocation(300,50);     
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                //timer.stop();    
            	System.out.println("Debugggg");
            }
        });
        //timer.stop();*/
        add(b2);
        
    }       
}
