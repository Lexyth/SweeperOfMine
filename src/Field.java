
public class Field {

	private int value = 0;
	private boolean revealed = false;
	private boolean flagged = false;

	Field(int value_) {

		setValue(value_);
	}

	public void setValue(int value_) {

		value = value_;
	}

	public void toggleRevealed() {

		revealed = !revealed;
	}

	public void toggleFlag() {

		flagged = !flagged;
	}

	public int getValue() {

		return value;
	}

	public boolean isRevealed() {

		return revealed;
	}

	public boolean isFlagged() {

		return flagged;
	}

	public boolean isBomb() {

		return value == -1;
	}
}
