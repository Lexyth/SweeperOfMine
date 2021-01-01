import java.awt.Color;
import java.awt.GridLayout;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private FieldButton[] fields = new FieldButton[100];
//	private Model model;
	
	GamePanel () {
		
		setLayout(new GridLayout(10, 10));
		
	}
	
//	public void setModel(Model m) {
//		
//		model = m;
//	}
	
	public void reset(int[] values) {
		
		removeAll();
		
		setBackground(Color.BLUE);
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i] = new FieldButton(i, values[i]);
			add(fields[i]);
		}
	}
	
	public void toggleFlagMode() {
				
		for (int i = 0; i < fields.length; i++) {
			
			fields[i].toggleFlagMode();
		}
	}
	
	public void setCheckUncoveredWinListener(Runnable listener) {
		
		for (int i = 0; i < fields.length; i++) {
		
			fields[i].setCheckUncoveredWinListener(listener);
		}
	}
	
	public void setBoomListener(Runnable listener) {
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i].setBoomListener(listener);
		}
	}
	
	public void fill(int i) {
		
		for (int j = -1; j <= 1; j++) {
			
			for (int k = -1; k <= 1; k++) {
				
				//TODO replace 10 with difficulty once implemented
				int idx = i+(j*10)+k;
				
				if (/*Math.abs(j+k) == 1 &&*/ idx >= 0 && idx < fields.length && !(idx%10==9 && k==-1) && !(idx%10==0 && k==1))
					if (!fields[idx].revealed) //getFieldValue(idx)==0 && !fields[idx].revealed)
						fields[idx].reveal();
			}
		}
	}
	
//	private int getFieldValue(int idx) {
//				
//		return model.getFields()[idx];
//	}
	
	public void setChangeFlaggedCountListener(Consumer<Integer> listener) {
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i].setChangeFlaggedCountListener(listener);
		}
	}
	
	public void setFillListener() {
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i].setFillListener(this::fill);
		}
	}
}
