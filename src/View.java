import java.awt.GridLayout;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JPanel {
	
	GamePanel gamePanel = new GamePanel();
	OptionPanel optionPanel = new OptionPanel();
	JLabel labelComment = new JLabel("Welcome to Sweeper Of Mine");
//	Model model;

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
		
		optionPanel.setFlagListener(this::toggleFlagMode);
		
	}
	
//	public void setModel(Model m) {
//		
//		model = m;
//		gamePanel.setModel(model);
//		gamePanel.setFillListener();
//	}
	
	public void setResetListener(Runnable listener) {
		
		optionPanel.setResetListener(listener);
	}
	
	public void setCheckUncoveredWinListener(Runnable listener) {
		
		gamePanel.setCheckUncoveredWinListener(listener);
	}
	
	public void setChangeFlaggedCountListener(Consumer<Integer> listener) {
		
		gamePanel.setChangeFlaggedCountListener(listener);
	}
	
	public void setBoomListener(Runnable listener) {
		
		gamePanel.setBoomListener(listener);
	}
	
	private void toggleFlagMode() {
		
		gamePanel.toggleFlagMode();
	}
	
	public void changeComment(String message) {
		
		labelComment.setText(message);
	}
	
	public void reset(int[] values) {
		
		gamePanel.reset(values);
		gamePanel.setFillListener();

	}
}
