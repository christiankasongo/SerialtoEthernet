package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;


public class IOMenuBar extends MenuBar {

	private IOTextPane iop; //holds a reference to the root pane
	private ComboBox<String> cbo;
	public IOMenuBar(IOTextPane iop) { 
		
		this.iop = iop; //initialises root pane

		//temp vars for menus and menu items within this MenuBar
		Menu menu;
		MenuItem menuItem;
		cbo = new ComboBox<String>();

		//file menu
		menu = new Menu("_ComPort");

		//menuItem = new MenuItem("_Load");
		//menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		//menuItem.setOnAction(new LoadHandler()); //attach event handler
		//menu.getItems().add(menuItem);

		//menuItem = new MenuItem("_Save");
		//menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		//menuItem.setOnAction(new SaveHandler()); //attach event handler
		//menu.getItems().add(menuItem);

		//menu.getItems().add(new SeparatorMenuItem());

		
		menuItem = new MenuItem("E_xit");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+Q"));
		menuItem.setOnAction(e -> System.exit(0)); //exits the application
		menu.getItems().add(menuItem);

		this.getMenus().add(menu);


		//help menu
		menu = new Menu("_Help");

		menuItem = new MenuItem("_About");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+B"));
		menuItem.setOnAction(new AboutHandler()); //attach event handler
		menu.getItems().add(menuItem);

		this.getMenus().add(menu); 
	}

	//saves the content of the input area into a file
	private class SaveHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				try {
					Files.write(Paths.get(file.getPath()), iop.getInputAreaText().getBytes());
				} catch (IOException e1) {
					System.out.println("Error saving.");
				}            	
			}
		}
	}
	
	//loads the content of the input area from a file
	private class LoadHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				try {
					byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
					iop.setInputAreaText(new String(bytes));
				} catch (IOException e1) {
					System.out.println("Error loading.");
				}            	
			}
		}
	}

	//uses alerts to output a dialog
	private class AboutHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Serial Communication via Internet (IP/TCP)");
			alert.showAndWait();
		}
	}

}
