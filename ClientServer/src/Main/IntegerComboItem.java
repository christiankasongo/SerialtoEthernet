package Main;

public class IntegerComboItem {

	String name;
	Integer value;
	
	public IntegerComboItem (String name, Integer value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString () {
		return name;
	}
}


