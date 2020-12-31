import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JPanel {
	
	GamePanel gamePanel = new GamePanel();
	OptionPanel optionPanel = new OptionPanel();
	JLabel labelComment = new JLabel("Welcome to Sweeper Of Mine");

	View() {
		
		setLayout(new GridLayout(2, 1));
		
		add(gamePanel);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(optionPanel);
		JPanel panelComment = new JPanel();
		panelComment.add(labelComment);
		panel.add(panelComment);
		add(panel);
	}
	
	public void setResetListener(Runnable listener) {
		
		optionPanel.setResetListener(listener);
	}
	
	public void changeComment(String message) {
		
		labelComment.setText(message);
	}
	
	public void reset(int[] values) {
		
		gamePanel.reset(values);
	}
}
