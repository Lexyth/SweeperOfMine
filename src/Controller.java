
public class Controller {

	View view;
	Model model;

	Controller() {

		System.out.println("Construct Controller");
	}

	public void setViewModel(View view_, Model model_) {
		view = view_;
		model = model_;

		// Callers

		// View Callers

		view.setResetCaller(this::handleReset);
		view.setCallers(this::handleFieldClicks);

		// Model Callers

		model.setDisplayCaller(this::handleDisplay);
		model.setCommentCaller(this::handleComment);
	}

	private void handleReset() {

		model.reset();
		view.reset();
	}

	private void handleFieldClicks(int idx, String type) {

		if (type.equals("LMB"))
			model.reveal(idx);
		else if (type.equals("RMB"))
			model.flag(idx);
		else if (type.equals("Double-Click"))
			model.revealSurroundings(idx); // no if needed, but just in case...
	}

	private void handleRepaint() {

	}

	private void handleDisplay(int idx, String type) {

		if (type.equals("true") || type.equals("false"))
			view.setFlag(idx, type.equals("true"));
		else if (type.equals("-1"))
			view.setReveal(idx, "B");
		else
			view.setReveal(idx, type);
		
		//System.out.println("Display");
	}

	private void handleComment(String text) {

		view.setComment(text);
	}

//	public void setViewModel(View view_, Model model_) {
//		
//		this.view = view_;
//		this.model = model_;
//		
//		view.setResetListener(this::handleReset);
//		view.setDifficultyListener(this::handleDifficulty);
//		
//		model.setCommentCaller(this::handleComment);
//		model.setDifficultyCaller(this::handleDifficultyLabel);
//		model.setResetCaller(this::handleReset);
//		
//		handleComment("Welcome to Sweeper Of Mine!");
//	}
//	
//	private void handleReset() {
//		
//		view.reset(model.reset());
//		view.setCheckUncoveredWinListener(this::handleCheckUncoveredWin);
//		view.setChangeFlaggedCountListener(this::handleChangeFlaggedCount);
//		view.setBoomListener(this::handleBoom);
//		view.setRevealListener(this::handleReveal);
//	}
//	
//	private void handleReveal(int idx) {
//		
//		//model.reveal(idx);
//		view.reveal(idx);
//	}
//	
//	private void handleDifficulty() {
//		
//		model.setBombCount(model.getBombCount()<40? model.getBombCount()+10 : 10);
//		handleReset();
//		
//	}
//	
//	private void handleDifficultyLabel(String difficulty) {
//		
//		view.changeDifficultyLabel(difficulty);
//	}
//	
//	private void handleComment(String message) {
//		
//		view.changeComment(message);
//	}
//	
//	private void handleCheckUncoveredWin() {
//		
//		model.checkUncoveredWin();
//	}
//	
//	private void handleChangeFlaggedCount(int idx) {
//		
//		model.changeFlaggedCount(idx);
//	}
//	
//	private void handleBoom(int idx) {
//
//		model.boom(idx);
//	}
}
