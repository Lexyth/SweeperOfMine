import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {
	
	JButton buttonReset = new JButton("Reset");
	//TODO add difficulty button
	
	OptionPanel () {
		
		add(buttonReset);
		setBackground(Color.CYAN);
	}
	
	public void setResetListener (Runnable listener) {
		
		buttonReset.addActionListener(event -> listener.run());
	}

}
