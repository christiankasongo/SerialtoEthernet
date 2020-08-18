package main;
import javafx.util.StringConverter;

public class Commandconverter extends StringConverter<CommandComboItem>{
	@Override
	public String toString(CommandComboItem command) {
		
		if(command == null) {
			return null;
		}
		else {
			return command.getitm();
		}
		
	}
	
	@Override
	public CommandComboItem fromString(String str) {
		CommandComboItem command = null;
		
		if(str == null)
		{
			return command;
		}
		else {
			command = new CommandComboItem(str, false, false);
		}	
		return command;
	}

}
