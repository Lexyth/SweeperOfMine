import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {

	private JButton buttonReset = new JButton("Reset");
	private JButton buttonFlag = new JButton("FlagMode");
	// TODO add difficulty button

	private JButton buttonDifficulty = new JButton("Difficulty (resets) :");
	private JLabel labelDifficulty = new JLabel("10");

	OptionPanel() {

		buttonReset.setFocusPainted(false);
		buttonFlag.setFocusPainted(false);
		buttonDifficulty.setFocusPainted(false);
		
		buttonFlag.setBackground(Color.GREEN);

		setLayout(new GridLayout());

		JPanel resetPanel = new JPanel();
		JPanel flagPanel = new JPanel();
		JPanel diffPanel = new JPanel();

		buttonReset.setHorizontalAlignment(JButton.CENTER);
		buttonReset.setVerticalAlignment(JButton.CENTER);
		buttonFlag.setHorizontalAlignment(JButton.CENTER);
		buttonFlag.setVerticalAlignment(JButton.CENTER);

		resetPanel.add(buttonReset);
		flagPanel.add(buttonFlag);
		diffPanel.add(buttonDifficulty);
		diffPanel.add(labelDifficulty);

		add(resetPanel);
		add(flagPanel);
		add(diffPanel);

		setBackground(Color.CYAN);

		buttonFlag.addActionListener(
				event -> buttonFlag.setBackground(buttonFlag.getBackground() == Color.RED ? Color.GREEN : Color.RED));

		buttonReset.addActionListener(event -> buttonFlag.setBackground(Color.GREEN));
	}
	
	public void changeDifficultyLabel(String difficulty) {
		
		labelDifficulty.setText(difficulty);
	}

	public void setResetListener(Runnable listener) {

		buttonReset.addActionListener(event -> listener.run());
	}

	public void setFlagListener(Runnable listener) {

		buttonFlag.addActionListener(event -> listener.run());
	}
	
	public void setDifficultyListener(Runnable listener) {
		
		buttonDifficulty.addActionListener(event -> listener.run());
	}
}
