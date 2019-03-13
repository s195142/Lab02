/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import it.polito.tdp.alien.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    	model.resetDizionario();
    	txtWord.clear();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String[] split = txtWord.getText().toLowerCase().split(" ");
    	
		if(split.length==2) {	
			
	    	if(!split[0].matches("[a-zA-Z]*") || !split[1].matches("[a-zA-Z]*")) {
	    		txtResult.setText("Stringa non valida\n");
	    	}else {
    		model.addWord(split[0], split[1]);
    		txtResult.setText("Parola aggiunta al dizionario\n");
    		txtWord.clear();
    		}
    	}
		else {
			if(!split[0].matches("[a-zA-Z]*")) {
	    		txtResult.setText("Stringa non valida\n");
	    	}else
	    		txtResult.setText(model.translateWord(txtWord.getText()));
			}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

        model = new AlienDictionary();
    }
}
