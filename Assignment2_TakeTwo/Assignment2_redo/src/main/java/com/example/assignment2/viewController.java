

package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class viewController {

    @FXML
    private Button mainMenu;

    @FXML
    private TextField cityText;

    @FXML
    private TextField delFirstName;

    @FXML
    private TextField delLastName;

    @FXML
    private TextField edFirstName;

    @FXML
    private TextField edLastName;

    @FXML
    private  Button editbtn;

    @FXML
    private TextField searchFirstName;

    @FXML
    private TextField searchLastName;

    @FXML
    private TextArea textbox;

    @FXML
    private TextArea textbox1;

    @FXML
    private TextArea textbox11;

    //Grabs the creation of the contacts from AddController and display contacts in a box
    public void getData(String text){
        textbox.setText(text);
    }
    public void getData2(String text){
        textbox1.setText(text);
    }

    //Search contacts by name which will display all information of said contact
    @FXML
    void searchByName()
    {
        if(!searchFirstName.getText().isBlank() && !searchLastName.getText().isBlank())
        {
            String fname = searchFirstName.getText();
            String lname = searchLastName.getText();
            if(Main.cm.contactExists(fname,lname))
            {
                Contact c=Main.cm.getContactByFullName(fname,lname);
                textbox1.setText(c.toString());
            }
            else{
                textbox1.setText("No Contact Exists");
             }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Please enter names");
            alert.show();
        }
    }

    //Deletes contact in list
    @FXML
    void deletebtn()
    {
        String fname = delFirstName.getText();
        String lname = delLastName.getText();
        if (fname != null || lname != null)
            {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            boolean s=Main.cm.deleteContact(fname,lname);
            if(s)
            {
                getData(Main.cm.displayContacts());
                getData2(Main.cm.displayContacts());
                alert.setTitle("Successful");
                alert.setContentText("Contact deleted successfully");
            }
            else
            {
                alert.setTitle("Unsuccessful");
                alert.setContentText("Contact Not Deleted");
            }
            alert.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Please enter valid names");
            alert.show();
        }

    }

    //Method for searching contact by city
    public void searchCity()
    {
        String city = cityText.getText();
        if(city!=null)
        {
            if(Main.cm.findcity(city))
            {
                String c = Main.cm.contactsWithCity(city);
                textbox11.setText(c);
            }
            else
            {
                textbox11.setText("No Contact to display");
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Please enter city name");
            alert.show();
        }
    }

    //Method for when user clicks button, will save data and update list
    public void editbtn() throws IOException {
        if(!searchFirstName.getText().isBlank() && !searchLastName.getText().isBlank())
        {
            String fname = edFirstName.getText();
            String lname = edLastName.getText();
            if(Main.cm.contactExists(fname,lname))
            {
                Contact c = Main.cm.getContactByFullName(fname, lname);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("editContact.fxml"));
                Parent root = loader.load();
                EditController editController = loader.getController();
                editController.getData3(c.getFirstName(), c.getLastName(), c.getHomePhone(), c.getWorkPhone(),
                                        c.getHomeAddress().streetInfo1, c.getHomeAddress().streetInfo2, c.getHomeAddress().city,
                                        c.getHomeAddress().postalCode, c.getHomeAddress().province, c.getHomeAddress().country,
                                        c.getEmail(), c.getBirthday().getDay(), c.getBirthday().getMonth(), c.getBirthday().getYear(), c.getNotes());
                Stage window = (Stage) editbtn.getScene().getWindow();
                window.setScene(new Scene(root, 889, 634));
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Please enter correct name");
                alert.show();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Please enter names");
            alert.show();
        }
    }

    //Switches Scene to Main Menu
    public void mainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage window = (Stage) mainMenu.getScene().getWindow();
        window.setScene(new Scene(root, 889, 634));
    }


}


