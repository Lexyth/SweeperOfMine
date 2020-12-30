import java.util.function.Consumer;

public class Model {
	
	private Consumer<String> commentListener;
	
	Model() {
		
		
	}
	
	public void setCommentListener(Consumer<String> listener) {
		
		commentListener = listener;
	}
	
	public void reset() {
		
		//reset
		
		commentListener.accept("Reset successful!");
	}

}
