import java.awt.Color;

import javax.swing.JButton;

public class FieldButton extends JButton {
	
	private boolean flagged = false;
	
	FieldButton () {
		
		setBackground(Color.BLUE);
		
		setUncoverListener(this::toggleFlag);
	}
	
	public void setUncoverListener(Runnable listener) {
		
		addActionListener(event -> listener.run());
	}
	
	public void uncover(int value) {
		
		if (value == -1) System.out.println("Boom!");//bomb();
		else setText(Integer.toString(value));
	}
	
	public void toggleFlag() {
		
		flagged = !flagged;
		
		if (flagged) setBackground(Color.RED);
		else setBackground(Color.BLUE);
	}

}
