import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private FieldButton[] fields = new FieldButton[100];
	
	GamePanel () {
		setLayout(new GridLayout(10, 10));
	}
	
	public void reset(int[] values) {
		
		removeAll();
		
		setBackground(Color.BLUE);
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i] = new FieldButton(values[i]);
			add(fields[i]);
		}		
	}
	
	public void toggleFlagMode() {
				
		for (int i = 0; i < fields.length; i++) {
			
			fields[i].toggleFlagMode();
		}
	}
}
