package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
	@FXML
	private TextField txtNum1;

	@FXML
	private TextField txtNum2;

	@FXML
	private Label labelResult;

	@FXML
	private Button btSoma;

	@FXML
	public void onBtSomaAction() {
	
		try {
			Locale.setDefault(Locale.US);
			double num1 = Double.parseDouble(txtNum1.getText());
			double num2 = Double.parseDouble(txtNum2.getText());
			
			double soma = num1 + num2;
			
			labelResult.setText(String.format("%.2f", soma));
		 }catch(NumberFormatException e) {
			Alerts.showAlert("Error", "parse error", e.getMessage(), AlertType.ERROR);
		 }
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNum1);
		Constraints.setTextFieldDouble(txtNum2);//só aceita numeros
		Constraints.setTextFieldMaxLength(txtNum1, 12);
		Constraints.setTextFieldMaxLength(txtNum2, 12);//limita os campos a 12 digitos
	}
	
	

}
