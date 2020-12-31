
public class Controller {
	
	View view;
	Model model;
	
	Controller() {
		
		
	}
	
	public void setViewModel(View view_, Model model_) {
		
		this.view = view_;
		this.model = model_;
		
		view.setResetListener(this::handleReset);
		model.setCommentListener(this::handleComment);
	
		handleReset();
	}
	
	private void handleReset() {
		
		view.reset(model.reset());
		view.setCheckWinListener(this::handleCheckWin);
	}
	
	private void handleComment(String message) {
		
		view.changeComment(message);
	}
	
	private void handleCheckWin() {
		
		model.checkWin();
	}
}
