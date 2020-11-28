package Main;

public class StringComboItem {
	
	String display;
	String value;
	
	public StringComboItem(String display, String value) {
		this.display = display;
		this.value = value;
		
	}
	
	@Override
	public String toString () {
		return display;
	}
	
	
}
