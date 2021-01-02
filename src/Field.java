
public class Field {
	
	private int value = 0;
	
	Field (int value_) {
		
		setValue(value_);
	}
	
	public void setValue (int value_) {
		
		value = value_;
	}
	
	public int getValue () {
		
		return value;
	}
	
	public boolean isBomb () {
		
		return value == -1;
	}
}
