package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Controller {
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLoginLabel;

    @FXML private TextField amountTextField;
    @FXML private Label errorAmountLabel;

    private Integer amountTendered;
    @FXML private Label changeLabel1;
    @FXML private Label changeLabel2;
    @FXML private Label changeLabel3;

    @FXML void login (ActionEvent event)throws IOException{
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if((username.equals("user")) && (password.equals("password"))){
            Parent amountPaid = FXMLLoader.load(getClass().getResource("GetAmount.fxml"));
            Stage amountPaidStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            amountPaidStage.setTitle("Cash Dispense");
            amountPaidStage.setScene(new Scene(amountPaid));
        }
        else {
            errorLoginLabel.setText("Username or Password is invalid.");
            usernameTextField.setText("");
            passwordField.setText("");
            usernameTextField.requestFocus();
        }
    }

    @FXML void getAmount (ActionEvent event) throws IOException {

        amountTendered = Integer.parseInt(amountTextField.getText());
        if (amountTendered % 5 == 0) {
            Parent giveChange = FXMLLoader.load(getClass().getResource("GiveChange.fxml"));
            Stage changeAmountStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            changeAmountStage.setTitle("Cash Dispense");
            changeAmountStage.setScene(new Scene(giveChange));

            List<Integer> denominations = Arrays.asList(10_000, 5_000, 2_000, 1_000, 500, 200, 100, 50, 20, 10, 5);
            List<Integer> change = denominations
                    .stream()
                    .filter(i -> i < amountTendered)
                    .collect(Collectors.toList());
            System.out.println(change.get(0));
            //changeLabel1.setText(String.valueOf(change.get(0)));

        } else {
            errorAmountLabel.setText("Rand value is invalid");
            amountTextField.setText("");
            amountTextField.requestFocus();
        }
    }

    @FXML void giveChange(ActionEvent event) throws IOException {

        Parent reset = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setTitle("Cash Dispense");
        loginStage.setScene(new Scene(reset));
        loginStage.show();
    }
}
