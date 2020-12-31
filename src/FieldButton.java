import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FieldButton extends JButton {
	
	private boolean flagMode = false;
	private boolean flag = false;
	private int value;
	private Runnable checkWin;
	
	FieldButton (int i) {
		
		super(" ");
		
		this.setFocusPainted(false);
		
		setBackground(Color.BLUE);
		
		setUncoverListener(this::flagOrReveal);
		
		value = i;
	}
	
	public void setUncoverListener(Runnable listener) {
		
		for (ActionListener a : this.getActionListeners()) {
			
			removeActionListener(a);
		}
		
		addActionListener(event -> listener.run());
	}
	
	public void setCheckWinListener(Runnable listener) {
		
		checkWin = listener;
	}
	
	public void reveal() {
		
		if (value == -1) {
			
			setText("B"); System.out.println("Boom!");
		
		} else {
			
			setText(Integer.toString(value));
			checkWin.run();
		}
		
		for (ActionListener a : this.getActionListeners()) {
			
			removeActionListener(a);
		}
		
	}
	
	public void toggleFlagMode() {
		
		flagMode = !flagMode;

	}
	
	public void flagOrReveal() {
		
		if (flagMode) toggleFlag();
		else if (!flag) reveal();
	}
	
	private void toggleFlag() {
		
		flag = !flag;
		if (flag) {
			setBackground(Color.RED);
		} else {
			setBackground(Color.BLUE);
		}
	}

}
