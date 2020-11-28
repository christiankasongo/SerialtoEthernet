package Main;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


 
public class Practice extends Application {
	// we create a class to hold a single string.
	// change combobox to be of that type instead of string.
	
	private ComboBox <Display> cbo;
	private CheckBox cr;
	private CheckBox lf;
	
	
	private void ButtonClick(ActionEvent event) {
		SendEx();
	}
	
	private void SendEx() {
	        String cmd;
	        //String cmdlist;
	        //String resList = "";
	      
			cmd = cbo.getEditor().getText(); // cbo.getValue().getitm(); //mystringfunctions.LastCommand(newValue);
			// no double
		
			
			// changing combobox type is not gonna be happy on this line because it wants you to add the class rather than string,.
			// cbo.getItems.add(new OurClass(cmd));
			if (!cbo.getItems().contains(new Display (cmd, cr.isSelected(), lf.isSelected()))) {
				//System.out.println("Before Add");
				cbo.getItems().add(new Display (cmd, cr.isSelected(), lf.isSelected()));
				//System.out.println("After Add");
			}
				
		
			
		}
				 
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        
        root.setSpacing(10);
        root.setPadding(new Insets(15,20, 10,10));
          
        Button btn = new Button("Send");
        btn.setPrefSize(50, 30);
		btn.setOnAction(this::ButtonClick);
        
        cbo = new ComboBox<Display>();
        cbo.setConverter(new DisplayConverter());
        cbo.setCellFactory(new DisplayCellFactory());
        cbo.setButtonCell(new DisplayCell());
        
        cbo.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
        {
            public void changed(ObservableValue<? extends Number> ov,
                    final Number oldvalue, final Number newvalue)
            {
            	System.out.println(oldvalue.toString() + ", " + newvalue.toString());
            	indexChanged(newvalue);
            }
        });
        
        cbo.setPrefWidth(200);
        cbo.setEditable(true);
          
        cr = new CheckBox("CR");
        lf = new CheckBox("LF");
      
      	
        root.getChildren().addAll(cbo, cr, lf, btn);
 
        Scene scene = new Scene(root, 550, 250);
        primaryStage.setTitle("Practice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
  
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void indexChanged(Number newValue) {
    	System.out.println("Index Changed");
    	// gets a Display from combo at index newValue
    	Display d = cbo.getItems().get(newValue.intValue());
    	
    	// shows alert with Display.getItm and .IsSet
    	//ShowAlert (null, d.getitm() + d.Getcr());
    	cr.setSelected(d.Getcr());
    	lf.setSelected(d.Getlf());
    	
    }
    
    public void ShowAlert(String title, String message) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
    }
}