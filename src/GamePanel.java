import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private FieldButton[] fields = new FieldButton[100];
	
	GamePanel () {
		
	}
	
	public void reset() {
		
		removeAll();
		
		setBackground(Color.BLUE);
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i] = new FieldButton();
			add(fields[i]);
		}		
	}
}
