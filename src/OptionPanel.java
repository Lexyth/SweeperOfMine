import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {
	
	private JButton buttonReset = new JButton("Reset");
	private JButton buttonFlag = new JButton("FlagMode");
	//TODO add difficulty button
	
	OptionPanel () {
		
		buttonReset.setFocusPainted(false);
		buttonFlag.setFocusPainted(false);
		buttonFlag.setBackground(Color.GREEN);
		
		add(buttonReset);
		add(buttonFlag);
		
		setBackground(Color.CYAN);

		buttonFlag.addActionListener( event -> buttonFlag.setBackground(
				buttonFlag.getBackground() == Color.RED ?
						Color.GREEN : Color.RED));
		
		buttonReset.addActionListener( event -> buttonFlag.setBackground(Color.GREEN));
	}
	
	public void setResetListener (Runnable listener) {
		
		buttonReset.addActionListener(event -> listener.run());
	}
	
	public void setFlagListener (Runnable listener) {
		
		buttonFlag.addActionListener(event -> listener.run());
	}

}
