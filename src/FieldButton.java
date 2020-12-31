import javax.swing.JButton;

public class FieldButton extends JButton {
	
	FieldButton () {
		
		
	}
	
	public void setUncoverListener(Runnable listener) {
		
		addActionListener(event -> listener.run());
	}
	
	public void uncover(int value) {
		
		if (value == -1) System.out.println("Boom!");//bomb();
		else setText(Integer.toString(value));
	}

}
