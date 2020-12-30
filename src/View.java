import java.awt.GridLayout;

import javax.swing.JPanel;

public class View extends JPanel{
	
	//gamePanel
	//optionsPanel

	View() {
		
		setLayout(new GridLayout(2, 1));
		
		//add gui components
	}
	
	public void setResetListener(Runnable listener) {
		
		//add actionlistener to resetbutton with .run()
	}
	
	public void changeComment(String message) {
		
		
	}
}
