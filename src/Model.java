import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Consumer;

public class Model {

	private ArrayList<Field> fields;
	private int size = 10;
	private int fieldCount = size * size;
	private int bombCount = 10;

	private int revealedCount = 0;
	// private int flaggedCount = 0;

	private boolean lost = false;

	private Runnable resetCaller;
	private Consumer<String> commentCaller;
	private Consumer<String> difficultyCaller;

	Model() {

		createFields();
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

	private void createFields() {

		fields = new ArrayList<Field>();

		for (int i = 0; i < fieldCount; i++) {

			fields.add(new Field(i < bombCount ? -1 : 0));
		}
	}

	public void resetFields(int clickIdx) {

		Collections.shuffle(fields);

		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {

				int idx = clickIdx + i + (size * j);

				if (fields.get(idx).isBomb()) {

					fields.get(idx).setValue(0);
					int k = new Random().nextInt(size * size);
					while (fields.get(k).isBomb() || ((k > i - 2 && k < i + 2) && (k > j - 2 && k < j + 2)))
						k++;
					fields.get(k).setValue(-1);
				}
			}
		}

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

	public void reset() {

		revealedCount = 0;
		// flaggedCount = 0;
		lost = false;
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).isFlagged())
				fields.get(i).toggleFlag();
			if (fields.get(i).isRevealed())
				fields.get(i).toggleRevealed();
		}
		resetCaller.run();
	}

	public void reveal(int idx) {

		if (fields.get(idx).isFlagged() || fields.get(idx).isRevealed() || lost)
			return;

		if (revealedCount == 0)
			resetFields(idx);

		revealedCount++;
		fields.get(idx).toggleRevealed();

		if (fields.get(idx).getValue() == 0)
			fill(idx);

		if (fields.get(idx).isBomb()) {

			lose();
			return;
		}

		if ((fieldCount - bombCount) == revealedCount)
			win();
	}

	private void fill(int clickIdx) {

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {

				int idx = clickIdx + i + (size * j);
				if (idx >= 0 && idx < fields.size() && !(idx % size == size - 1 && j == -1)
						&& !(idx % size == 0 && j == 1))
					if (!fields.get(idx).isRevealed())
						reveal(idx);
			}
		}
	}
	
	public void revealSurroundings(int idx) {
		
		
	}

	public void flag(int idx) {

		if (lost)
			return;

//		if (!fields.get(idx).isFlagged())
//			flaggedCount++;
//		else
//			flaggedCount--;

		fields.get(idx).toggleFlag();

		if (allBombsFlagged())
			win();

	}

	private boolean allBombsFlagged() {

		for (int i = 0; i < fields.size(); i++)
			if (fields.get(i).isBomb() && !fields.get(i).isFlagged()
					|| !fields.get(i).isBomb() && fields.get(i).isFlagged())
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
