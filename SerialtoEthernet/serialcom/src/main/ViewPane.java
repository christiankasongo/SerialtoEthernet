package main;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;



public class ViewPane extends SplitPane  {
	
	private ListView<String> sendlistview;
	private ListView <String> receivelistview;
	
	public ViewPane() {
		//this.setPadding(new Insets(10,10,10,10));
		this.setOrientation(Orientation.HORIZONTAL);
		
		sendlistview = new ListView<String>();
		Label lbl = new Label("Sent");
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().addAll(lbl, sendlistview);
		
		receivelistview = new ListView<String>();
		Label lbl2 = new Label("Received");
		
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
