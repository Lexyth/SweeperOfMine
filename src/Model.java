import java.time.Instant;
import java.util.function.Consumer;

public class Model {
	
	private Consumer<String> commentListener;
	private int[] fields = new int[100];
	
	Model() {
		
	}
	
	public void setCommentListener(Consumer<String> listener) {
		
		commentListener = listener;
	}
	
	public void reset() {
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i] = Math.random() < 0.1 ? -1 : 0;
		}
		
		fields[(int)Math.random()*fields.length] = -1;
		
		for (int i = 0; i < fields.length; i++) {
			
			if (fields[i] == -1) break;
			
			int sum = 0;
			
			for (int j = -1; j <= 1; j++) {
				
				for (int k = -1; k <= 1; k++) {
					
					//TODO replace 10 with difficulty once implemented
					int idx = i+(j*10)+k;
					
					if (idx >= 0 && idx < fields.length && !(idx%10==9 && k==-1) && !(idx%10==0 && k==1)) sum += fields[i+(j*10)+k];
				}
			}
			
			sum -= fields[i];
			
			fields[i] = sum;
		}
		
		commentListener.accept("Reset successful!" + Instant.now().toString());
	}

}
