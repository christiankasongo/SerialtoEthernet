package main;
import javafx.scene.control.ListCell;

public class CommandCell extends ListCell<CommandComboItem>
{
    @Override
    public void updateItem(CommandComboItem item, boolean empty)
    {
        super.updateItem(item, empty);
 
        if (empty)
        {
            setText(null);
            setGraphic(null);
        }
        else
        {
        	String displayText = item.getitm();
        	
        	if (item.Getcr()) {
        		displayText = displayText + "[CR]";
        	}
        	if (item.Getlf()){
        		displayText = displayText + "[LF]";
        	}
            setText(displayText);
        }
    }
 
}