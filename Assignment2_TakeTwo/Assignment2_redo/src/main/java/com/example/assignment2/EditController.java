
package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.IOException;

public class EditController {

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
    private Button mainMenu;

    @FXML
    private TextField si2text;

    @FXML
    private TextField wptext;

    @FXML
    private TextField yobtext;

    //Makes Contact Class static
    static Contact ce;

    //Method for filling out the text field with desired contact
    public void getData3(String firstName, String lastName, String homePhone, String workPhone,
                        String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country,
                        String email, int day, int month, int year, String notes){

        fntext.setText(firstName);
        lntext.setText(lastName);
        hptext.setText(homePhone);
        wptext.setText(workPhone);
        si1text.setText(streetInfo1);
        si2text.setText(streetInfo2);
        citytext.setText(city);
        pctext.setText(postalCode);
        provincetext.setText(province);
        countrytext.setText(country);
        emailtext.setText(email);
        dobtext.setText(Integer.toString(day));
        mobtext.setText(Integer.toString(month));
        yobtext.setText(Integer.toString(year));
        notestext.setText(notes);

        ce=Main.cm.getContactByFullName(firstName,lastName);

    }
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

    //Action event for when user clicks button
    public void editButton()
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

                String f = ce.getFirstName();
                String l = ce.getLastName();
                boolean d = Main.cm.deleteContact(f, l);
                if (d) {
                    boolean p = Main.cm.editContact(fntext1, lntext1, hptext1, wptext1, si1text1, si2text1, citytext1, pctext1, provincetext1, countrytext1, emailtext1, dobtext1, mobtext1, yobtext1, notestext1);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    if (p) {
                        alert.setTitle("Successful");
                        alert.setContentText("Contact has been updated!");
                    } else {
                        alert.setTitle("UnSuccessful");
                        alert.setContentText("Contact has not been updated!");

                    }
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
            alert.setContentText("Please enter valid");
            alert.show();
        }
    }

    //Switches scene to Main Menu
    public void mainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Stage window = (Stage) mainMenu.getScene().getWindow();
        window.setScene(new Scene(root, 889, 634));
    }
}
