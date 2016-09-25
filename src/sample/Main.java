package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
 * An application that calculates cash to dispense to clients.
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("GetAmount.fxml"));
        primaryStage.setTitle("Cash Dispense");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /*
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}
