package kaleidoscope;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class MultiReflect {
	public enum Reflect {
		A,B,C;
	}
	Reflect name;
	
	public MultiReflect(Reflect name){
		this.name=name;
	}
		 
	    	   
		public void reflectX(Graphics2D g){
			switch(name){
			case A:
				AffineTransform at0 = new AffineTransform();
			    at0.setToRotation(Math.PI);
			    g.setTransform(at0);
				g.drawString("A", -108, -290);				
				break;
			case B:
				AffineTransform at1 = new AffineTransform();
			    at1.setToRotation(0);
			    g.setTransform(at1);
				g.drawString("B", 108, 300);
				break;
			case C:
				AffineTransform at2 = new AffineTransform();
			    at2.setToRotation(0);
			    g.setTransform(at2);
				g.drawString("C", 116,300);
				break;
			default:
				break;	
			}	
		}
		
		public void reflectY(Graphics2D g){
			switch(name){
			case A:
				AffineTransform at0 = new AffineTransform();
			    at0.setToRotation(0);
			    g.setTransform(at0);
				g.drawString("A", 400, 100);				
				break;
			case B:
				AffineTransform at1 = new AffineTransform();
			    at1.setToRotation(Math.PI);
			    g.setTransform(at1);
				g.drawString("B", -399, -90);
				break;
			case C:
				AffineTransform at2 = new AffineTransform();
			    at2.setToRotation(Math.PI);
			    g.setTransform(at2);
				g.drawString("C", -392,-90);
				break;
			default:
				break;
			}
		}
		
		public void reflectD(Graphics2D g){
			switch(name){
			case A:
				AffineTransform at0 = new AffineTransform();
			    at0.setToRotation(3*Math.PI/2);
			    g.setTransform(at0);
				g.drawString("A", -300, 100);				
				break;
			case B:
				AffineTransform at1 = new AffineTransform();
			    at1.setToRotation(Math.PI/2 );
			    g.setTransform(at1);
				g.drawString("B", -100, -110);
				break;
			case C:
				AffineTransform at2 = new AffineTransform();
			    at2.setToRotation(Math.PI/2);
			    g.setTransform(at2);
				g.drawString("C", -100,-120);
				break;
			default:
				break;			
			}
		
	    }
		
		public void reflectSD(Graphics2D g){
			switch(name){
			case A:
				AffineTransform at0 = new AffineTransform();
			    at0.setToRotation(Math.PI/2);
			    g.setTransform(at0);
				g.drawString("A", -300, 100);				
				break;
			case B:
				AffineTransform at1 = new AffineTransform();
			    at1.setToRotation(Math.PI/2 );
			    g.setTransform(at1);
				g.drawString("B", -100, -110);
				break;
			case C:
				AffineTransform at2 = new AffineTransform();
			    at2.setToRotation(Math.PI/2);
			    g.setTransform(at2);
				g.drawString("C", -100,-120);
				break;
			default:
				break;			
			}
		
	}
 }
	

