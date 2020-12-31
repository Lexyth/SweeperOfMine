import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FieldButton extends JButton {
	
	private boolean flagged = false;
	private int value;
	
	FieldButton (int i) {
		
		super(" ");
		
		setBackground(Color.BLUE);
		
		setUncoverListener(this::flagOrUncover);
		
		value = i;
	}
	
	public void setUncoverListener(Runnable listener) {
		
		for (ActionListener a : this.getActionListeners()) {
			
			removeActionListener(a);
		}
		
		addActionListener(event -> listener.run());
	}
	
	public void reveal() {
		
		if (value == -1) {
			
			setText("B"); System.out.println("Boom!");
		
		} else setText(Integer.toString(value));
		
		for (ActionListener a : this.getActionListeners()) {
			
			removeActionListener(a);
		}
	}
	
	public void toggleFlag() {
		
		flagged = !flagged;
		
		if (flagged) {
			setBackground(Color.RED);
		} else {
			setBackground(Color.BLUE);
		}
	}
	
	public void flagOrUncover() {
		
		if (flagged) toggleFlag();
		else reveal();
	}

}
