import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.BiConsumer;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class FieldButton extends JButton {

	private int index;
	// private Consumer<Integer> revealCaller;

	FieldButton(int idx) {

		super(" ");

		this.setFocusPainted(false);

		this.setBackground(Color.BLUE);

		index = idx;
	}

	// reconsider: is this needed...
	public int getIndex() {

		return index;
	}

	public void setReveal(String text) {

		if (text.equals("bomb")) {
			this.setBackground(Color.BLACK);
			this.setText("B");
		} else if (text.equals("reset")) {
			this.setBackground(Color.BLUE);
			this.setText("");
		} else {
			this.setBackground(Color.WHITE);
			this.setText(text);
		}
	}

	public void setFlag(boolean flag) {

		if (flag)
			this.setBackground(Color.RED);
		else
			this.setBackground(Color.BLUE);
	}

	// Callers

	public void setFieldCaller(BiConsumer<Integer, String> caller) {

		addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {

				if (SwingUtilities.isLeftMouseButton(e))
					caller.accept(index, "LMB");

				if (SwingUtilities.isRightMouseButton(e))
					caller.accept(index, "RMB");

			}

			public void mousePressed(MouseEvent e) {

				if (e.getClickCount() == 2 && !e.isConsumed()) {

					caller.accept(index, "Double-Click");
					e.consume();
				}
			}
		});
	}

//	private boolean flagMode = false;
//	private boolean flag = false;
//	private int value;
//	private Runnable checkUncoveredWinListener;
//	private Consumer<Integer> boomListener;
//	private Consumer<Integer> changeFlaggedCountListener;
//	private Consumer<Integer> fillListener;
//	int idx;
//	boolean revealed = false;
//	private Runnable boomEndListener;
//	private Consumer<Integer> revealListener;
//	private Consumer<Integer> revealSurroundingsListener;
//
//	FieldButton(int idx_, int i) {
//
//		super(" ");
//
//		this.setFocusPainted(false);
//
//		setBackground(Color.BLUE);
//
//		setUncoverListener(this::flagOrReveal);
//
//		idx = idx_;
//
//		value = i;
//	}
//
//	public void setUncoverListener(Runnable listener) {
//
//		for (ActionListener a : this.getActionListeners()) {
//
//			removeActionListener(a);
//		}
//
//		addActionListener(event -> listener.run());
//		addMouseListener(new MouseAdapter() {
//
//			public void mouseReleased(MouseEvent e) {
//				if (SwingUtilities.isRightMouseButton(e))
//					toggleFlag();
//			}
//		});
////		addMouseListener(new MouseAdapter() {
////
////			public void mousePressed(MouseEvent e) {
////
////				if (e.getClickCount() == 2 && !e.isConsumed()) {
////
////					revealSurroundingsListener.accept(idx);
////				}
////			}
////		});
//	}
//
//	public void setCheckUncoveredWinListener(Runnable listener) {
//
//		checkUncoveredWinListener = listener;
//	}
//
//	public void setChangeFlaggedCountListener(Consumer<Integer> listener) {
//
//		changeFlaggedCountListener = listener;
//	}
//
//	public void setBoomListener(Consumer<Integer> listener) {
//
//		boomListener = listener;
//	}
//
//	public void setBoomEndListener(Runnable listener) {
//
//		boomEndListener = listener;
//	}
//
//	public void setRevealListener(Consumer<Integer> listener) {
//
//		revealListener = listener;
//	}
//
//	public void setFillListener(Consumer<Integer> listener) {
//
//		fillListener = listener;
//	}
//
//	public void setRevealSurroundingsListener(Consumer<Integer> listener) {
//
//		revealSurroundingsListener = listener;
//	}
//
//	public void reveal() {
//
//		// revealListener.accept(idx);
//		if (!flag)
//			if (value == -1) {
//
//				boomListener.accept(idx);
//				setText("B");
//				boomEndListener.run();
//				setBackground(Color.DARK_GRAY);
//				revealed = true;
//
//			} else {
//
//				setText(Integer.toString(value));
//				setBackground(Color.WHITE);
//				checkUncoveredWinListener.run();
//				revealed = true;
//				if (value == 0)
//					fillListener.accept(idx);
//			}
//
//		for (ActionListener a : this.getActionListeners()) {
//
//			removeActionListener(a);
//		}
//
//	}
//
//	public void dontBoom() {
//
//		setText("?");
//	}
//
//	public void toggleFlagMode() {
//
//		flagMode = !flagMode;
//
//	}
//
//	public void flagOrReveal() {
//
//		if (flagMode)
//			toggleFlag();
//		else if (!flag)
//			reveal();
//	}
//
//	private void toggleFlag() {
//
//		if (revealed)
//			return;
//
//		flag = !flag;
//
//		if (flag) {
//			setBackground(Color.RED);
//		} else {
//			setBackground(Color.BLUE);
//		}
//
//		changeFlaggedCountListener.accept(idx + (flag ? 0 : 5000));
//	}
//
//	public int getValue() {
//
//		return value;
//	}

}
