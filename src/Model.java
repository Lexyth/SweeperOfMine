import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class Model {

	private ArrayList<Field> fields;
	private int size = 10;
	private int fieldCount = size * size;
	private int bombCount = 10;

	private int revealedCount = 0;
	private int flaggedCount = 0;

	private boolean lost = false;

	private Runnable resetCaller;
	private Consumer<String> commentCaller;
	private Consumer<String> difficultyCaller;

	Model() {

	}

	public void setSize(int size_) {

		size = size_ < 4 ? 4 : size;
		fieldCount = size * size;
		setBombCount(bombCount);
	}

	public void setBombCount(int amount) {

		bombCount = amount < fieldCount - 10 ? amount : fieldCount - 10;
		reset();
	}

	public int getBombCount() {

		return bombCount;
	}

	public void reset() {

		fields = new ArrayList<Field>();

		for (int i = 0; i < fieldCount; i++) {

			fields.add(new Field(i < bombCount ? -1 : 0));
		}

		Collections.shuffle(fields);

		calculateFieldValues();

	}

	private void calculateFieldValues() {

		for (int i = 0; i < fields.size(); i++) {

			if (!fields.get(i).isBomb()) {

				fields.get(i).setValue(0);

				for (int j = -1; j <= 1; j++) {

					for (int k = -1; k <= 1; k++) {

						int idx = i + (j * size) + k;

						if (idx >= 0 && idx < fields.size() && !(idx % 10 == 9 && k == -1) && !(idx % 10 == 0 && k == 1)
								&& fields.get(idx).isBomb()) {

							fields.get(i).setValue(fields.get(i).getValue() + 1);
						}
					}
				}
			}
		}
	}

	public void reveal(int idx) {

		if (fields.get(idx).isFlagged())
			return;

		if (lost)
			return;

		if (fields.get(idx).isBomb()) {

			lose();
			return;
		}

		revealedCount++;
		fields.get(idx).reveal();

		if ((fieldCount - bombCount) == revealedCount)
			win();
	}

	public void flag(int idx) {

		if (lost)
			return;

		if (!fields.get(idx).isFlagged())
			flaggedCount++;
		else
			flaggedCount--;

		fields.get(idx).toggleFlag();

		if (allBombsFlagged())
			win();

	}

	private boolean allBombsFlagged() {

		for (int i = 0; i < fields.size(); i++)
			if (fields.get(i).isBomb() && !fields.get(i).isFlagged())
				return false;

		return true;
	}

	private void win() {

		commentCaller.accept("Win");
	}

	private void lose() {

		lost = true;
		commentCaller.accept("Lose");
	}

	// set Callers

	public void setCommentCaller(Consumer<String> caller) {

		commentCaller = caller;
	}

	public void setDifficultyCaller(Consumer<String> caller) {

		difficultyCaller = caller;
	}

	public void setResetCaller(Runnable caller) {

		resetCaller = caller;
	}
}
