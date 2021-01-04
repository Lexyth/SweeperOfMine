
public class Controller {
	
	View view;
	Model model;
	
	Controller() {
		
		
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
