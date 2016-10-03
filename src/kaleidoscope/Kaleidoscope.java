package kaleidoscope;
import java.awt.*;
import javax.swing.*;

import kaleidoscope.MultiReflect.*;

import java.awt.event.*;
import java.applet.Applet;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class Kaleidoscope extends JPanel implements ActionListener{
	private static final ActionEvent ActionEvent = null;
	protected Container mainMap;
	protected Polygon poly;
	protected static Graphics2D g;
	protected JPanel p,p1;
	private JPanel panel;
    
    int x;
    int y;
    String s;
    protected JButton reflectx;
    protected JButton reflecty;
    protected JButton reflectd;
    protected JButton reflectsd;
   
	
	public Kaleidoscope() {		
		
	}

	
	public void paintComponent(){
		reflectx=new JButton("reflectX"); reflectx.addActionListener(this);
		reflecty=new JButton("reflectY"); reflecty.addActionListener(this);
		reflectd=new JButton("reflectD"); reflectd.addActionListener(this);
		reflectsd=new JButton("reflectSD"); reflectsd.addActionListener(this);
		
		mainMap = new JFrame("Kaleidoscope");
		mainMap.setLayout(new BorderLayout());
		mainMap.setSize(500,400);
		mainMap.setVisible(true);
		
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(2,2));
//        p1.setLayout(new BorderLayout());
		p1.add(reflectx);
		p1.add(reflecty);
		p1.add(reflectd);
		p1.add(reflectsd);
		
		
//        mainMap.setResizable(false);
        
//        ((JFrame) mainMap).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainMap.add(p1,BorderLayout.SOUTH);
		    
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics gg) {
            	g=(Graphics2D) gg;
                super.paintComponent(g);
                g.setColor(Color.BLUE);                
                g.drawString("ABC", 100, 100);
                
                               
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
        mainMap.add(p);
    
//        mainMap.pack();
//        mainMap.setVisible(true);		
	}
	
	
	
	public static void main(String[] args) {
		Kaleidoscope kk=new Kaleidoscope();
		kk.paintComponent();
		
		
		
//	SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Kaleidoscope();
//            }
//        });
//
		
	}

    
	public void rep(){
		MultiReflect a=new MultiReflect(Reflect.A);
		MultiReflect b=new MultiReflect(Reflect.B);
		MultiReflect c=new MultiReflect(Reflect.C);
		
		reflectx.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent e) {
				a.reflectX(g); b.reflectX(g); c.reflectX(g);
				repaint();				
			}});
		
		reflecty.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				a.reflectY(g); b.reflectY(g); c.reflectY(g);
				repaint();				
			}});
		
		reflectd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				a.reflectD(g); b.reflectD(g); c.reflectD(g);
				repaint();				
			}});
		
		reflectsd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				a.reflectSD(g); b.reflectSD(g); c.reflectSD(g);
				repaint();				
			}});
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MultiReflect a=new MultiReflect(Reflect.A);
		MultiReflect b=new MultiReflect(Reflect.B);
		MultiReflect c=new MultiReflect(Reflect.C);
		if(e.getSource()==reflectx){
			
            JPanel p2=new JPanel(){
            	@Override
                protected void paintComponent(Graphics gg) {
                	g=(Graphics2D) gg;
                    super.paintComponent(g);
                    g.setColor(Color.BLUE);
                    g.drawString("ABC", 100, 100);
                    a.reflectX(g); b.reflectX(g); c.reflectX(g);                              
                }
            	@Override
                public Dimension getPreferredSize() {
                    return new Dimension(500, 500);
                }
            	
            	
            };
            
			mainMap.add(p2);			
			mainMap.revalidate();
			p.repaint();
			System.out.println("reflectx has done");
						
		}
		if(e.getSource()==reflecty){
			
			JPanel p3=new JPanel(){
				@Override
                protected void paintComponent(Graphics gg) {
                	g=(Graphics2D) gg;
                    super.paintComponent(g);
                    g.setColor(Color.BLUE); 
                    g.drawString("ABC", 100, 100);
                    a.reflectY(g); b.reflectY(g); c.reflectY(g);                                                    
                }
            	@Override
                public Dimension getPreferredSize() {
                    return new Dimension(500, 500);
                }
				
			};
			
//			p.setVisible(false);
			mainMap.add(p3);
			
			mainMap.revalidate();
			p.repaint();
			System.out.println("reflecty has done");
			
				
		}
		if(e.getSource()==reflectd){
			JPanel p4=new JPanel(){
				@Override
                protected void paintComponent(Graphics gg) {
                	g=(Graphics2D) gg;
                    super.paintComponent(g);
                    g.setColor(Color.BLUE); 
                    g.drawString("ABC", 100, 100);
                    a.reflectD(g); b.reflectD(g); c.reflectD(g);                                                    
                }
            	@Override
                public Dimension getPreferredSize() {
                    return new Dimension(500, 500);
                }
				
			};
			
//			p.setVisible(false);
			mainMap.add(p4);			
			mainMap.revalidate();
			p.repaint();
			System.out.println("reflecty has done");
		    	
		}
		if(e.getSource()==reflectsd){
			a.reflectSD(g); b.reflectSD(g); c.reflectSD(g);
			System.out.println("reflectsd has done");
			repaint();	
			}
		
	}
	
		
		
	

}
