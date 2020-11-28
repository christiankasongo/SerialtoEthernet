package Main;
import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
 
public class DisplayCell extends ListCell<Display>
{
    @Override
    public void updateItem(Display item, boolean empty)
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
            setGraphic(null);
        }
    }
 
}
