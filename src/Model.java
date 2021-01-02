import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class Model {

	private Consumer<String> listenerComment;

	private ArrayList<Field> fields;
	private int size = 10;
	private int fieldCount = size * size;
	private int bombCount = 10;

	// utility
	private int emptyCount = fieldCount - bombCount;

	// rework
	private int uncoveredCount = 0;
	private int bombsFoundCount = 0;
	private int flagsCount = 0;
	private int won = 0;

	Model() {

	}

	public void setSize(int size_) {

		size = size_ < 4 ? 4 : size;
		fieldCount = size * size;
		setBombCount(bombCount);
	}

	public void reveal(int idx) {

		if (fields.get(idx).isBomb())
			if (uncoveredCount == 0)
				moveBomb(idx, true);
	}

	public void moveBomb(int idx, boolean rnd) {

		fields.get(idx).setValue(0);

		if (rnd)
			for (int i = 0; i < fields.size(); i++) {

				if (!fields.get(i).isBomb()) {

					fields.get(i).setValue(-1);
					break;
				}
			}

		calculateFieldValues();
	}

	public void calculateFieldValues() {

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

	public void setBombCount(int amount) {

		bombCount = bombCount < fieldCount ? bombCount : fieldCount - 10;
		emptyCount = fieldCount - bombCount;
	}

	public void setCommentListener(Consumer<String> listener) {

		listenerComment = listener;
	}

	// rework
	public void checkUncoveredWin() {

		uncoveredCount++;
		if (fields.size() - bombCount == uncoveredCount)
			win();

		System.out.println(fields.size() - bombCount + " : " + uncoveredCount);
	}

	// rework
	public boolean changeFlaggedCount(int idx) {

		flagsCount += idx < 5000 ? 1 : -1;

		if (fields.get(idx < 5000 ? idx : idx - 5000).isBomb()) {

			bombsFoundCount += idx < 5000 ? 1 : -1;
		}

		System.out.println(
				"BombCount : " + bombCount + " BombsFoundCount :" + bombsFoundCount + " FlagsCount : " + flagsCount);

		if (bombsFoundCount == bombCount && flagsCount == bombCount) {

			win();
		}

		return false;
	}

	// rework
	public void win() {

		if (won != -1) {
			won = 1;
			listenerComment.accept("Win! You can either reset or blow up the remaining bombs just for fun xD");
		}
	}

	// rework
	public void boom() {

		if (won != 1) {
			won = -1;
			listenerComment.accept("BOOOOOOOOMMMMMM!!!!!");
		}
	}

	public int[] reset() {

		// rework
		uncoveredCount = 0;
		flagsCount = 0;
		bombsFoundCount = 0;
		won = 0;

		fields = new ArrayList<Field>();

		for (int i = 0; i < fieldCount; i++) {

			fields.add(new Field(i < bombCount ? -1 : 0));
		}

		Collections.shuffle(fields);

		calculateFieldValues();

		// to reset the listener... idk why
		listenerComment.accept("");
		listenerComment.accept("Reset successful!");

		// rework
		int[] arr = new int[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			System.out.println(fields.get(i).getValue());
			arr[i] = fields.get(i).getValue();
		}
		return arr;
	}
}
