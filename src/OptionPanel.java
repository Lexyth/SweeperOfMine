import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
		
		setLayout(new GridLayout());
		
		JPanel resetPanel = new JPanel();
		JPanel flagPanel = new JPanel();
		
		buttonReset.setHorizontalAlignment(JButton.CENTER);
		buttonReset.setVerticalAlignment(JButton.CENTER);
		buttonFlag.setHorizontalAlignment(JButton.CENTER);
		buttonFlag.setVerticalAlignment(JButton.CENTER);
		
		resetPanel.add(buttonReset);
		flagPanel.add(buttonFlag);
		
		add(resetPanel);
		add(flagPanel);
		
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
