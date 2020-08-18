package main;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CommandCellFactory implements Callback<ListView<CommandComboItem>, ListCell<CommandComboItem>>
{
    @Override
    public ListCell<CommandComboItem> call(ListView<CommandComboItem> listview)
    {
        return new CommandCell();
    }
}