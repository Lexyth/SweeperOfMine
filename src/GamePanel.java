import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private FieldButton[] fields = new FieldButton[100];

	GamePanel() {

		setLayout(new GridLayout(10, 10));

	}

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

	public void setBoomListener(Consumer<Integer> listener) {

		for (int i = 0; i < fields.length; i++) {

			fields[i].setBoomListener(listener);
			fields[i].setBoomEndListener(this::haltButtonAction);
		}
	}

	public void setRevealListener(Consumer<Integer> listener) {

		for (int i = 0; i < fields.length; i++) {

			fields[i].setRevealListener(listener);
		}
	}

	public void setRevealSurroundingsListener() {

		for (int i = 0; i < fields.length; i++) {

			fields[i].setRevealSurroundingsListener(this::revealSurroundings);
		}
	}

	public void revealSurroundings(int i) {

		for (int j = -1; j <= 1; j++) {

			for (int k = -1; k <= 1; k++) {

				int idx = i + (j * 10) + k;

				if (idx >= 0 && idx < fields.length && !(idx % 10 == 9 && k == -1) && !(idx % 10 == 0 && k == 1))
					if (!fields[idx].revealed)
						fields[idx].reveal();
			}
		}
	}

	public void dontBoom(int idx) {

		fields[idx].dontBoom();
	}

	public void haltButtonAction() {

		for (int i = 0; i < fields.length; i++) {

			for (ActionListener a : fields[i].getActionListeners()) {

				fields[i].removeActionListener(a);
			}
		}
	}

	public void fill(int i) {

		for (int j = -1; j <= 1; j++) {

			for (int k = -1; k <= 1; k++) {

				// TODO replace 10 with difficulty once implemented
				int idx = i + (j * 10) + k;

				if (idx >= 0 && idx < fields.length && !(idx % 10 == 9 && k == -1) && !(idx % 10 == 0 && k == 1))
					if (!fields[idx].revealed)
						fields[idx].reveal();
			}
		}
	}

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

	public void reveal(int idx) {
		// TODO Auto-generated method stub
		fields[idx].reveal();
	}
}
