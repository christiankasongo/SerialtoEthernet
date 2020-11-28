package Main;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class DisplayCellFactory implements Callback<ListView<Display>, ListCell<Display>>
{
    @Override
    public ListCell<Display> call(ListView<Display> listview)
    {
        return new DisplayCell();
    }
}