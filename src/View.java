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
		panel.add(labelComment);
		add(panel);
	}
	
	public void setResetListener(Runnable listener) {
		
		//add actionlistener to resetbutton with .run()
	}
	
	public void changeComment(String message) {
		
		
	}
}
