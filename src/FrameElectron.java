import javax.swing.JFrame;

public class FrameElectron extends JFrame {
	private static final long serialVersionUID = 1L;
	public FrameElectron(int soLuongE, double tiLeECong, double doCong)
    {
        bai2 b2=new bai2(soLuongE, tiLeECong, doCong);
        this.setSize(800,600); 
        setResizable(false);        
        setVisible(true);
        setLocation(300,50);
        add(b2);
        
    }       
}
