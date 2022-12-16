/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Application;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLController implements Initializable {

@FXML
   public Button B_recommencer;
   
   @FXML
   private Button B_sauvegarder;
           
   @FXML
   private Button B_quitter;
   
   @FXML
   public Label label = new Label("2");

   @FXML
   private GridPane G_1;
           
   @FXML
   private GridPane G_2;
   
   @FXML
   private GridPane G_3;
   
   @FXML
   private Text T_titre;
   
   @FXML
   private Text T_instruction;
   
   @FXML
private Label score; 
   
   


 



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
 
 
    }

    
  /*  @FXML
   private void handleButtonAction(MouseEvent event ) {
   System.out.println("Clic de souris");
   try {
   score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
    G_1.add(label, 0, 0);
    } catch (NumberFormatException nfe) { … }
}
*/

    

    

