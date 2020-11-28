package Main;

import javafx.util.StringConverter;

public class DisplayConverter extends StringConverter <Display>{
	@Override
	public String toString(Display display)
	{
		//return display == null? null: display.getitm() + ;
		if (display == null) {
			return null;
		}
		else {
			return display.getitm();
		}
	}
	
	@Override
	public Display fromString(String string)
	{
		Display display = null;
		if(string == null)
		{
			return display;
		}
		else 
			display = new Display (string, false, false);
		{
		 	
		}
		return display;
	}

}
