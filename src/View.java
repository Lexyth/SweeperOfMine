import java.awt.GridLayout;
import java.util.function.Consumer;

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
		panelComment.setLayout(new GridLayout());
		labelComment.setHorizontalAlignment(JLabel.CENTER);
		labelComment.setVerticalAlignment(JLabel.CENTER);
		panelComment.add(labelComment);
		panel.add(panelComment);
		add(panel);
		
		optionPanel.setFlagListener(this::toggleFlagMode);
		
	}
	
	public void setResetListener(Runnable listener) {
		
		optionPanel.setResetListener(listener);
	}
	
	public void setDifficultyListener(Runnable listener) {
		
		optionPanel.setDifficultyListener(listener);
	}
	
	public void setCheckUncoveredWinListener(Runnable listener) {
		
		gamePanel.setCheckUncoveredWinListener(listener);
	}
	
	public void setChangeFlaggedCountListener(Consumer<Integer> listener) {
		
		gamePanel.setChangeFlaggedCountListener(listener);
	}
	
	public void setBoomListener(Consumer<Integer> listener) {
		
		gamePanel.setBoomListener(listener);
	}
	
	public void setRevealListener(Consumer<Integer> listener) {
		
		gamePanel.setRevealListener(listener);
	}
	
	public void dontBoom(int idx) {
		// TODO Auto-generated method stub
		gamePanel.dontBoom(idx);
	}
	
	private void toggleFlagMode() {
		
		gamePanel.toggleFlagMode();
	}
	
	public void changeComment(String message) {
		
		labelComment.setText(message);
	}
	
	public void changeDifficultyLabel(String difficulty) {
		
		optionPanel.changeDifficultyLabel(difficulty);
	}
	
	public void reset(int[] values) {
		
		gamePanel.reset(values);
		gamePanel.setFillListener();
		gamePanel.setRevealSurroundingsListener();

	}
	
	public void reveal(int idx) {
		
		gamePanel.reveal(idx);
	}


}
