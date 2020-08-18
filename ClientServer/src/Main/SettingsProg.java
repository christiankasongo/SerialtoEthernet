package Main;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SettingsProg extends Application {
	
	private Parent rootWithMenu;
	private BorderPane child;
	private HBox hb;
	private PortSettingsPane psp;
	private PortSettings ps;
	private MenuBar mnu;
	private Button Save;
	
	public SettingsProg() {
		
		
	}
	
	private HBox SavePane() {
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(8,10,10,10));
					
		Save = new Button("Save");
		Save.setOnAction(this::ButtonClick);
		
		hb.getChildren().addAll(Save);
		
		return hb;
				
	}
	
	private void ButtonClick(ActionEvent event) {
		Save();
	}
	private MenuBar FormMenu() {
        mnu = new MenuBar();
		
		Menu tl;
		MenuItem itm;
		
		
		tl = new Menu("Options");
		itm = new MenuItem("_Refresh");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+R"));
		itm.setOnAction(e -> psp.refreshPorts()); //new RefreshHandler());
		tl.getItems().add(itm);
		mnu.getMenus().add(tl);
		
		itm = new MenuItem("_About");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+B"));
		itm.setOnAction(new AboutHandler()); // attached event handler
		tl.getItems().add(itm);
		
		
		itm = new MenuItem("_Exit");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+Q"));
		itm.setOnAction(e -> System.exit(0));
		tl.getItems().add(itm);
		
		return mnu;
	}
	
	private VBox SerialPane() {
		VBox vb = new VBox();
		
		psp = new PortSettingsPane();
		
		vb.getChildren().addAll(psp, SavePane());
		
		return vb;
	}
	

	private void InitForm() {
		
		child = new BorderPane( hb,SerialPane(), null, null , null);
		child.setPadding(new Insets(10,10,10,10));
		
		
		rootWithMenu = new BorderPane(child, FormMenu(), null, null, null);	
	}
	
	public void start(Stage primaryStage) throws Exception {
		InitForm();
		primaryStage.setTitle("Serial Settings");
		Scene scene = new Scene(rootWithMenu);
		scene.getStylesheets().add(this.getClass().getResource("styling.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
		
		ps =  new PortSettings(System.getProperty("user.dir") + "/settings.txt");
		
		if (ps.Read()) {
			psp.setPort(ps.getPortName());
			psp.setBaud(ps.getBaud());
			psp.setParity(ps.getParity());
			psp.setStopBits(ps.getStopBits());
			psp.setFlowControl(ps.getFlowControl());
			psp.setDataBits(ps.getDataBits());
		}
		
	}
	
	//try and catch, if the file does not save
	
	private void Save() {
		ps.setPortname(psp.getPort());
		ps.setBaud(psp.getBaud());
		ps.setParity(psp.getParity());
		ps.setDataBits(psp.getDataBits());
		ps.setStopBits(psp.getStopBits());
		ps.setFlowControl(psp.getFlowControl());
		
		if (ps.Save()){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("file saved successfully");
			alert.setHeaderText(null);
			alert.setContentText("Saved");
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Unable to save");
			alert.setHeaderText(null);
			alert.setContentText("File unable to save please check again");
			alert.showAndWait();
		}
		
		}
		
		
	
	
	public static void main(String[] args) {

		launch(args);
	
		}

	
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
