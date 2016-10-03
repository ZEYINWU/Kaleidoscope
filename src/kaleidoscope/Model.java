package kaleidoscope;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is the Model class for a bouncing ball. It is an Observable,
 * which means that it can notifyObservers that something in the
 * model has changed, and they should take appropriate actions.
 * 
 * @author David Matuszek
 * @author <Your name goes here>
 * @author <Your name goes here>
 */
public class Model extends Observable {
    public final int BALL_SIZE = 10;
    private int xPosition,x1Position,x2Position,x3Position,x4Position ;
    private int yPosition,y1Position,y2Position,y3Position,y4Position ;
    private int xLimit,x1Limit,x2Limit,x3Limit,x4Limit, yLimit,y1Limit,y2Limit,y3Limit,y4Limit;
    private int xDelta ;
    private int yDelta ;
    private Timer timer;

    
    public Model(){
    	int max=6; int min=-6;
    	Random rx=new Random();Random ry=new Random();
    	 
    	
    	xPosition=rx.nextInt(400); yPosition=ry.nextInt(400);
    	x1Position=xPosition; y1Position=400-yPosition;
    	x2Position=400-xPosition; y2Position=yPosition;
    	x3Position=400-yPosition; y3Position=400-xPosition;
    	x4Position=yPosition; y4Position=xPosition;
    	
    	
    }
    /**
     * Sets the "walls" that the ball should bounce off from.
     * 
     * @param xLimit The position (in pixels) of the wall on the right.
     * @param yLimit The position (in pixels) of the floor.
     */
    public void setLimits(int xLimit, int yLimit) {
        this.xLimit = xLimit - BALL_SIZE; 
        this.yLimit = yLimit - BALL_SIZE;
        xPosition = Math.min(xPosition, xLimit);
        yPosition = Math.min(yPosition, yLimit);
        
        x1Position = Math.min(x1Position, xLimit);
        y1Position = Math.min(y1Position, yLimit);
        
        x2Position = Math.min(x2Position, xLimit);
        y2Position = Math.min(y2Position, yLimit);
        
        x3Position = Math.min(x3Position, xLimit);
        y3Position = Math.min(y3Position, yLimit);
        
        x4Position = Math.min(x4Position, xLimit);
        y4Position = Math.min(y4Position, yLimit);
        
    
    }

    /**
     * @return The balls X position.
     */
    public int getX() {
        return xPosition;
    }
    public int getX1(){
    	return x1Position;
    }
    public int getX2(){
    	return x2Position;
    }
    public int getX3(){
    	return x3Position;
    }
    public int getX4(){
    	return x4Position;
    }
    /**
     * @return The balls Y position.
     */
    public int getY() {
        return yPosition;
    }
    public int getY1(){
    	return y1Position;
    }
    public int getY2(){
    	return y2Position;
    }
    public int getY3(){
    	return y3Position;
    }
    public int getY4(){
    	return y4Position;
    }
    /**
     * Tells the ball to start moving. This is done by starting a Timer
     * that periodically executes a TimerTask. The TimerTask then tells
     * the ball to make one "step."
     */
    public void start(int t) {
        timer = new Timer(true);
        timer.schedule(new Strobe(), 0, t); // 25 times a second        
    }
    
    /**
     * Tells the ball to stop where it is.
     */
    public void pause() {
        timer.cancel();
    }
    
    /**
     * Tells the ball to advance one step in the direction that it is moving.
     * If it hits a wall, its direction of movement changes.
     */
    public void makeOneStep() {
    	int max=6; int min=-6;
    	Random rx=new Random();Random ry=new Random();
    	Random dx=new Random();Random dy=new Random();
    	xDelta=dx.nextInt(max-min+1)+min;
    	yDelta=dy.nextInt(max-min+1)+min;
    	
        // Do the work
        xPosition += xDelta;
        if (xPosition < 0 || xPosition >= xLimit ||x1Position >= xLimit||x2Position >= xLimit||x3Position >= xLimit||x4Position >= xLimit) {
            xDelta = -xDelta;
            xPosition += xDelta;
        }
        yPosition += yDelta;
        if (yPosition < 0 || yPosition >= yLimit|| y1Position >= yLimit|| y2Position >= yLimit|| y3Position >= yLimit|| y4Position >= yLimit) {
            yDelta = -yDelta;
            yPosition += yDelta;
        }
        // Notify observers
        x1Position=xPosition; y1Position=400-yPosition;
    	x2Position=400-xPosition; y2Position=yPosition;
    	x3Position=400-yPosition; y3Position=400-xPosition;
    	x4Position=yPosition; y4Position=xPosition;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Tells the model to advance one "step."
     */
    private class Strobe extends TimerTask {
        @Override
        public void run() {
            makeOneStep();
        }
    }
}