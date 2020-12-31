import java.time.Instant;
import java.util.function.Consumer;

public class Model {
	
	private Consumer<String> commentListener;
	private int[] fields = new int[100];
	private int bombCount = 0;
	private int uncoveredCount = 0;
	
	Model() {
		
	}
	
	public void setCommentListener(Consumer<String> listener) {
		
		commentListener = listener;
	}
	
	public void checkWin () {
		
		uncoveredCount++;
		if (fields.length - bombCount == uncoveredCount) 
			commentListener.accept("Win! You can either reset or blow up the remaining bombs just for fun xD");
		
		System.out.println(fields.length-bombCount + " : " + uncoveredCount);
	}
	
	public int[] reset() {
		
		uncoveredCount = 0;
		
		int bombs = 0;
		
		for (int i = 0; i < fields.length; i++) {
			
			fields[i] = Math.random() < 0.1 ? -1 : 0;
			bombs += -fields[i];
		}
				
		int rnd = (int)Math.random()*fields.length;
		
		if (fields[rnd]!=-1) {
			
			fields[(int)Math.random()*fields.length] = -1;
			bombs++;
		}
		
		bombCount = bombs;
		
		for (int i = 0; i < fields.length; i++) {
			
			if (!(fields[i] == -1)) {
			
			int sum = 0;
			
			for (int j = -1; j <= 1; j++) {
				
				for (int k = -1; k <= 1; k++) {
					
					//TODO replace 10 with difficulty once implemented
					int idx = i+(j*10)+k;
					
					if (idx >= 0 && idx < fields.length && !(idx%10==9 && k==-1) && !(idx%10==0 && k==1)) sum += fields[i+(j*10)+k] == -1 ? 1 : 0;
				}
			}
			
			sum -= fields[i];
			
			fields[i] = sum;
			}
		}
		
		commentListener.accept("Reset successful!" + Instant.now().toString());
		
		return fields;
	}

}
