
package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static ContactManager cm;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainMenu = new FXMLLoader(Main.class.getResource("mainMenu.fxml"));
        Scene scene = new Scene(mainMenu.load(), 889, 634);
        stage.setTitle("Assignment2");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        cm=new ContactManager();
        launch();
    }
}