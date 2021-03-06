package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ViewPane extends SplitPane  {
	
	private ListView<String> sendlistview;
	private ListView <String> receivelistview;
	
	public ViewPane() {
		//this.setPadding(new Insets(10,10,10,10));
		this.setOrientation(Orientation.HORIZONTAL);
		
		sendlistview = new ListView<String>();
		Label lbl = new Label("Send");
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().addAll(lbl, sendlistview);
		
		receivelistview = new ListView<String>();
		Label lbl2 = new Label("Receive");
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.TOP_CENTER);
		vb2.getChildren().addAll(lbl2, receivelistview);
		
		this.getItems().addAll(vb, vb2);
	}
	
	public void addS(String sent){
		sendlistview.getItems().add(sent);
	}
	
	public void addR(String rec) {
		receivelistview.getItems().add(rec);
	}
	
	public void clear() {
		sendlistview.getItems().clear();
		receivelistview.getItems().clear();
	}
	

}
