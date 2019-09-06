// Main class

import javax.swing.JFrame;

public class Program {
     public static void main(String[] args) {
    	 
        Gui go = new Gui();
        
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(300,300);
        go.setVisible(true);
        
    	 
     }     
}

// Gui class

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
	
	// I am gonna have two things on a window
	private JPanel mousepanel; // where u can perform mouse events such as drag, click etc.
	private JLabel statusbar; //  a place where the info will be showing such as when u click the mouse, 
                            // the statusbar will show "u click the mouse".
	
	//constructor
    public Gui() {
    	super("title"); // sets the title on our window
    	
    	mousepanel = new JPanel();
    	mousepanel.setBackground(Color.WHITE); // sets the background color
    	add(mousepanel, BorderLayout.CENTER); // adds it to the window
    	
    	statusbar = new JLabel("default");
    	add(statusbar, BorderLayout.SOUTH);
    	
    	// in order for us to handle mouse events we need to create the handler class
    	// however we r creating an object first and will create the class later
    	
    	Handlerclass handler = new Handlerclass();
    	
    	// add two types of mouselisteners
    	mousepanel.addMouseListener(handler); //for mouse but not motion
    	mousepanel.addMouseMotionListener(handler); //for motion events
    	
    }
	// finally our handler class
    private class Handlerclass implements MouseListener, MouseMotionListener{
    
    	// mouse listener methods
    	
    	public void mouseClicked(MouseEvent event) {
    		// whenever the mouse is states the position where it clicked with x and y in the statusbar
    		statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));    		
    	}
    	
    	public void mousePressed(MouseEvent event) {
    		statusbar.setText("You pressed down the mouse");
    	}
    	public void mouseReleased(MouseEvent event) { 
    		statusbar.setText("You release the button");
    	}
    	//when the mouse entered the area(our window) this happens
    	public void mouseEntered(MouseEvent event){
    		statusbar.setText("u entered the area");
    		mousepanel.setBackground(Color.RED);
    	    
    	}
    	// when mouse exists the window this happens
    	public void mouseExited(MouseEvent event) {
    		statusbar.setText("the mouse has left the window");
    		mousepanel.setBackground(Color.WHITE);
    	}
    	
    	// these are mouse Motion listeners
    	public void mouseDragged(MouseEvent event) {
    		statusbar.setText("u r dragging the mouse!!");
    	}
    	public void mouseMoved(MouseEvent event) {
    		statusbar.setText("u moved the mouse");
    	}
    	}
	
}
