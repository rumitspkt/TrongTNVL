
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	private static double V = 0, V1 = 0, V2 = 0, mA = 0, mA1 = 0, mA2, A = 0, A1 = 0, A2;
	private static JLabel label_A, label_mA, label_V;
	// <vat ly>
	private static Timer timer_KimA_=new Timer(5,new ActionListener(){@Override public void actionPerformed(ActionEvent e){label_A.setText("I : "+(Math.round(A1/10*10.0)/10.0)+" A");if(A1<A2){_KimA_HienThi(A1+=0.025);}else if(A1>A2){_KimA_HienThi(A1-=0.025);}if(Math.abs(A1-A2)<0.0001){timer_KimA_.stop();}}});
	private static Timer timer_KimmA_=new Timer(10,new ActionListener(){@Override public void actionPerformed(ActionEvent e){label_mA.setText("I : "+(Math.round(mA1/10*10.0)/10.0)+" mA");if(mA1<mA2){_KimmA_HienThi(mA1+=0.025);

	}else if(mA1>mA2){_KimmA_HienThi(mA1-=0.025);
	// System.out.println("mA1: " + mA1);
	}if(Math.abs(mA1-mA2)<0.00001){timer_KimmA_.stop();}}});
	private static Timer timer_KimV_=new Timer(30,new ActionListener(){@Override public void actionPerformed(ActionEvent e){label_V.setText("U3 : " + (Math.round(V1*10.0)/10.0) + " V");

	if(V1<V2){_KimV_HienThi(V1+=0.025);}else if(V1>V2){_KimV_HienThi(V1-=0.025);}if(Math.abs(V1-V2)<0.000001){timer_KimV_.stop();}}});
	private static double R_cuonDay = 3; // 3 ôm
	private static double U1 = 0, U1_tmp = 0;

	private static double R_loi = 3;
	private static double U2 = 0, U2_tmp = 0;
	private static double U3 = 0, U3_tmp = 0;
	private static double[] arr = { 3.4, 3.35, 3.3, 3.25, 3.25, 3.2, 3.2, 3.2, 3.2, 3.2, 3.2, 3.2, 3.2, 3.2, 3.2, 3.2,
			3.2, 3.2, 3.2, 3.2, 3.2, 3.15, 3.1, 3.1, 3.05, 3, 2.9, 2.8, 2.5, 2.45, 2.4, 2.2, 2.1, 1.8, 1.6, 1.4, 1.1,
			0.5, 0.4, 0.4, 0.4, 0.35, 0.3, 0.3, 0.3, 0.2, 0.1, 0 , 0,  0, 0, 0};

	public static double getSoLieu(double I) {		
		return arr[(int)(I)];
		
	}
	
	//electron bay bay
	private static int soLuongE;
	private static double tiLeECong;
	private static double doCong;
	private static double maxSpeed;
	// </vatly>

	static MachDien mach;
	public static int y_pixel, x_pixel;
	public static int xM, yM;
	public static double anpha = (180 * Math.PI) / 180; // 0 to 180
	public static double BK_KimmA_ = 35.355339;
	public static double BK_KimV_ = 35;
	private static Graphics2D g2d;
	public static double BK_KimA_ = 29.154759;

	public static void _KimmA_HienThi(double mA) {

		double phan = 5 / mA * 10;
		double gocD = 180 / phan;// Goc Degree!!
		double goc = 0;// Goc Radias
		if (gocD > 90)
			goc = (180 - gocD) * Math.PI / 180;
		else
			goc = gocD * Math.PI / 180;

		xM = (int) Math.round((BK_KimmA_ * Math.cos(goc)));
		yM = (int) Math.round((BK_KimmA_ * Math.sin(goc)));

		if (gocD < 90) {
			xM = -1 * xM;
		}
		yM = -1 * yM;
		y_pixel = 150 + yM;
		x_pixel = 771 + xM;

		mach.layThamSo_KimmA_(x_pixel, y_pixel);
		mach.repaint();
	}

	public static void _KimV_HienThi(double V) {

		double phan = 15 / V;
		double gocD = 180 / phan;
		double goc = 0;
		if (gocD > 90)
			goc = (180 - gocD) * Math.PI / 180;
		else
			goc = gocD * Math.PI / 180;

		xM = (int) Math.round((BK_KimV_ * Math.cos(goc)));
		yM = (int) Math.round((BK_KimV_ * Math.sin(goc)));

		if (gocD < 90) {
			xM = -1 * xM;
		}
		yM = -1 * yM;
		y_pixel = 380 + yM;
		x_pixel = 771 + xM;

		mach.layThamSo_KimV_(x_pixel, y_pixel);
		mach.repaint();
	}

	public static void _KimA_HienThi(double A) {

		double phan = 5 / A * 10;
		double gocD = 180 / phan;
		double goc = 0;
		if (gocD > 90)
			goc = (180 - gocD) * Math.PI / 180;
		else
			goc = gocD * Math.PI / 180;

		xM = (int) Math.round((BK_KimA_ * Math.cos(goc)));
		yM = (int) Math.round((BK_KimA_ * Math.sin(goc)));

		if (gocD < 90) {
			xM = -1 * xM;
		}

		yM = -1 * yM;
		y_pixel = 365 + yM;
		x_pixel = 151 + xM;

		mach.layThamSo_KimA_(x_pixel, y_pixel);
		mach.repaint();
	}

	public static void timer_KimA_HienThi() {
		_KimA_HienThi(A1);
		timer_KimA_.start();
	}

	public static void timer_KimmA_HienThi() {
		_KimmA_HienThi(mA1);
		timer_KimmA_.start();
	}

	public static void timer_KimV_HienThi() {
		_KimV_HienThi(V1);
		timer_KimV_.start();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		mach = new MachDien();
		
		// estEvent even = new TestEvent();
		
		frame.setResizable(false);
		frame.setBounds(200, 0, 955, 730);
		frame.setTitle("Thi nghiem 6");
		mach.setLayout(null);
		frame.add(mach);
	

		Knob k1 = new Knob();
		Knob k2 = new Knob();
		Knob k3 = new Knob();

		k1.setBounds(140, 535, 120, 120);
		k2.setBounds(440, 535, 120, 120);
		k3.setBounds(750, 535, 120, 120);

		mach.add(k1);
		mach.add(k2);
		mach.add(k3);
	
		// <vat ly>

		// <Label cho cac nut>
		JLabel label_U1 = new JLabel("U1 : 0.0 V");
		label_A = new JLabel("I : 0.0 A");
		label_U1.setBounds(155, 600, 70, 50);
		label_A.setBounds(130, 380, 70, 50);
		mach.add(label_U1);
		mach.add(label_A);
		k1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Knob t = (Knob) e.getSource();

				U1 = (int) (15 * t.getValue() * 10);
				A2 = U1 / R_cuonDay;

				label_U1.setText("U1 : " + U1/10 + " V");
				if (Math.abs(U1 - U1_tmp) >= 1) {
					U1_tmp = U1;
					timer_KimA_HienThi();
					mA2 = getSoLieu(A2) * 10;
					timer_KimmA_HienThi();
				}
			}
		});

		JLabel label_U2 = new JLabel("U2 : 0.0 V");
		label_mA = new JLabel("I : 0.0 A");
		label_U2.setBounds(455, 600, 70, 50);
		label_mA.setBounds(755, 170, 70, 50);
		mach.add(label_U2);
		mach.add(label_mA);
		k2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Knob t = (Knob) e.getSource();
				U2 = (int) (15 * t.getValue());
				mA2 = U2 / R_loi * 10;
				label_U2.setText("U2 : " + U2 + " V");
				if (Math.abs(U2 - U2_tmp) >= 1) {
					U2_tmp = U2;
					timer_KimmA_HienThi();
				}
			}
		});

		JLabel label_U3 = new JLabel("U3 : 0.0 V");
		label_V = new JLabel("U3 : 0.0 V");
		label_U3.setBounds(765, 600, 70, 50);
		label_V.setBounds(750, 400, 70, 50);
		mach.add(label_U3);
		mach.add(label_V);
		k3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Knob t = (Knob) e.getSource();
				U3 = (int) (15 * t.getValue());
				V2 = U3;
				label_U3.setText("U3 : " + U3 + " V");
				if (Math.abs(U3 - U3_tmp) >= 1) {
					U3_tmp = U3;
					timer_KimV_HienThi();				
				}
				
			}
		});
		
		JButton details = new JButton("Details");
		details.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				soLuongE = (int) (U2*U3);
				if(A2/10 <= 0) {
					tiLeECong = 0;
					maxSpeed = 6;
				}else if(A2/10 <= 4.7){
					tiLeECong = 0.5 + A2/100;
					doCong = 3.5 - A2/30;
					maxSpeed = 5 - A2/10;
				}else {
					tiLeECong = 1;
					doCong = 1.3;
				}			
				new FrameElectron(soLuongE, tiLeECong, doCong, maxSpeed + 1);	
			}
		});
		details.setBounds(425, 100, 80, 50);
		mach.add(details);			
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
