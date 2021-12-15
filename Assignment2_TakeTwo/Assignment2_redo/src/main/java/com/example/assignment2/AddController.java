
package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class AddController {

    @FXML
    private TextField citytext;

    @FXML
    private TextField countrytext;

    @FXML
    private TextField dobtext;

    @FXML
    private TextField emailtext;

    @FXML
    private TextField fntext;

    @FXML
    private TextField hptext;

    @FXML
    private TextField lntext;

    @FXML
    private TextField mobtext;

    @FXML
    private TextField notestext;

    @FXML
    private TextField pctext;

    @FXML
    private TextField provincetext;

    @FXML
    private TextField si1text;

    @FXML
    private TextField si2text;

    @FXML
    private TextField wptext;

    @FXML
    private TextField yobtext;

    @FXML
    private Button viewList;

    @FXML
    private Button mainMenu;

    private boolean isInt(TextField f)
    {
        try
        {
            Integer.parseInt(f.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    //Action event to add contacts
    @FXML
    void addButton()
    {
        String notestext1,fntext1, lntext1, hptext1, wptext1, si1text1, si2text1, citytext1, pctext1, provincetext1, countrytext1, emailtext1;
        int dobtext1, mobtext1, yobtext1;
        boolean db=isInt(dobtext);
        boolean mb=isInt(mobtext);
        boolean yb=isInt(yobtext);
        if(db && mb && yb)
        {
            if(!fntext.getText().isBlank() && !lntext.getText().isBlank() && !(hptext.getText().isBlank() && wptext.getText().isBlank())
                    && !si1text.getText().isEmpty()  && !citytext.getText().isBlank()
                    && !pctext.getText().isBlank() && !countrytext.getText().isBlank() )
            {
                fntext1 = fntext.getText();
                lntext1 = lntext.getText();
                hptext1 = hptext.getText();
                wptext1 = wptext.getText();
                si1text1 = si1text.getText();
                si2text1 = si2text.getText();
                citytext1 = citytext.getText();
                pctext1 = pctext.getText();
                provincetext1 = provincetext.getText();
                countrytext1 = countrytext.getText();
                emailtext1 = emailtext.getText();
                dobtext1 = Integer.parseInt(dobtext.getText());
                mobtext1 = Integer.parseInt((mobtext.getText()));
                yobtext1 = Integer.parseInt((yobtext.getText()));
                notestext1 = notestext.getText();

                if(Main.cm.addContact(fntext1, lntext1, hptext1, wptext1, si1text1, si2text1, citytext1, pctext1, provincetext1, countrytext1, emailtext1, dobtext1, mobtext1, yobtext1, notestext1))
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful");
                    alert.setContentText("Contact has been added!");
                    alert.show();

                    fntext.clear();
                    lntext.clear();
                    hptext.clear();
                    wptext.clear();
                    si1text.clear();
                    si2text.clear();
                    citytext.clear();
                    pctext.clear();
                    provincetext.clear();
                    countrytext.clear();
                    emailtext.clear();
                    dobtext.clear();
                    mobtext.clear();
                    yobtext.clear();
                    notestext.clear();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("UnSuccessful");
                    alert.setContentText("Contact has not been added!");
                    alert.show();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Please Check Your Input");
                alert.show();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Please enter valid input");
            alert.show();
        }
    }

    //Action event to clear all text fields
    @FXML
    void clearbutton() {
        fntext.clear();
        lntext.clear();
        hptext.clear();
        wptext.clear();
        si1text.clear();
        si2text.clear();
        citytext.clear();
        pctext.clear();
        provincetext.clear();
        countrytext.clear();
        emailtext.clear();
        dobtext.clear();
        mobtext.clear();
        yobtext.clear();
        notestext.clear();
    }

    //Method to switch windows to view menu
    public void viewList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewContact.fxml"));
        Parent root = loader.load();

        viewController viewController = loader.getController();
        viewController.getData(Main.cm.displayContacts());

        Stage window = (Stage) viewList.getScene().getWindow();
        window.setScene(new Scene(root, 889, 634));
    }

    //Method for going back to menu menu
    public void mainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        Parent root = loader.load();

        Stage window = (Stage) mainMenu.getScene().getWindow();
        window.setScene(new Scene(root, 889, 634));
    }

}
