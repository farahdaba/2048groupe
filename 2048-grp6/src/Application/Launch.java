/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Launch extends Application {
     
  public void start(Stage stage) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

Scene scene = new Scene(root);
stage.setScene(scene);
stage.show();

}
public static void main(String[] args) {
launch(args);
}
}