package com.example.simplyrugbysoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 *
 * Main class, the class that is first run.
 * @author Bartlomiej Klich
 * @version
 *
 */
public class Main extends Application {

    /**
     *
     * This method is for starting the stage, it creates a new FXMLloader and gets the main menu fxml.
     *
     */

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 480);
        stage.setTitle("Simply Rugby Software");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * This method is for launching, uses the launch method
     *
     */
    public static void main(String[] args) {
        launch();
    }
}