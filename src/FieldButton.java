import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;

public class FieldButton extends JButton {
	
	private boolean flagMode = false;
	private boolean flag = false;
	private int value;
	private Runnable checkUncoveredWinListener;
	private Consumer<Integer> changeFlaggedCountListener;
	private Consumer<Integer> fillListener;
	int idx;
	boolean revealed = false;
	
	FieldButton (int idx_, int i) {
		
		super(" ");
		
		this.setFocusPainted(false);
		
		setBackground(Color.BLUE);
		
		setUncoverListener(this::flagOrReveal);
		
		idx = idx_;
		
		value = i;
	}
	
	public void setUncoverListener(Runnable listener) {
		
		for (ActionListener a : this.getActionListeners()) {
			
			removeActionListener(a);
		}
		
		addActionListener(event -> listener.run());
	}
	
	public void setCheckUncoveredWinListener(Runnable listener) {
		
		checkUncoveredWinListener = listener;
	}
	
	public void setChangeFlaggedCountListener(Consumer<Integer> listener) {
		
		changeFlaggedCountListener = listener;
	}
	
	public void setFillListener(Consumer<Integer> listener) {
		
		fillListener = listener;
	}
	
	public void reveal() {
		
		if (value == -1) {
			
			setText("B"); System.out.println("Boom!");
			setBackground(Color.DARK_GRAY);
			revealed = true;
		
		} else {
			
			setText(Integer.toString(value));
			setBackground(Color.WHITE);
			checkUncoveredWinListener.run();
			revealed = true;
			if (value == 0) fillListener.accept(idx);
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
		
		changeFlaggedCountListener.accept(idx+(flag?0:5000));
	}
	
	public int getValue() {
		
		return value;
	}

}
