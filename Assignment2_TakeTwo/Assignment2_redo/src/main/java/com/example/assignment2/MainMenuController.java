
package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {

    @FXML
    private Label AddContact;

    @FXML
    private Pane MainMenuLayout;

    @FXML
    private Button viewMenu;

    @FXML
    private Button mmAdd;

    //This switches scene to Add Contacts
    public void addContactScene() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addContact.fxml")));
        Stage window = (Stage) mmAdd.getScene().getWindow();
        window.setScene(new Scene(root, 889, 634));
    }

    //Switches scene to all View Functions
    public void viewMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewContact.fxml"));
        Parent root = loader.load();
        viewController viewController = loader.getController();
        viewController.getData(Main.cm.displayContacts());
        Stage window = (Stage) viewMenu.getScene().getWindow();
        window.setScene(new Scene(root, 889, 634));
    }
}
