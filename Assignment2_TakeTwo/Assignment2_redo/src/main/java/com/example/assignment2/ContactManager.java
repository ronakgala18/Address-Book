

package com.example.assignment2;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactManager {

    private int numContacts;
    private int maxContacts;
    private Contact[] contactList;

    public ContactManager(){

        numContacts = 0;
        maxContacts = 1000;
        contactList = new Contact[maxContacts];
    }

    //Method for adding contact to contact list
    public Boolean addContact(String firstName, String lastName, String homePhone, String workPhone,
                              String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country,
                              String email, int day, int month, int year, String notes)
    {
        if (numContacts < maxContacts)
        {
            contactList[numContacts] = new Contact(firstName, lastName, homePhone, workPhone, streetInfo1, streetInfo2, city,postalCode,province, country, email, day, month, year, notes);
            numContacts++;
            return true;
        }
        return false;
    }

    //Method for viewing all contact information
    public String viewAllContacts()
    {
        String s = "Address Book Contacts:";
        for(int x = 0; x < numContacts; x++)
        {
            s += "\n" + contactList[x].toString() + "\n";
        }
        return s;
    }

    //Method for displaying all contacts in the array
    public String displayContacts()
    {
        String s = "";
        for(int x = 0; x < numContacts; x++)
        {
            if(contactList[x] != null){
                s += "\nFirst Name: " + contactList[x].getFirstName() + "\nLast Name: " + contactList[x].getLastName() + "\nPhone Number: " +contactList[x].getHomePhone() + "\n";
            }
        }
        return s;
    }

    //Find index of the contact list
    public boolean contactExists(String fname, String lName)
    {
        for(int x = 0; x < numContacts; x++)
        {
            if (contactList[x].getFirstName().compareTo(fname)==0 && contactList[x].getLastName().compareTo(lName)==0)
            {
                return true;
            }
        }
        return false;
    }
    public boolean findcity(String cityName)
    {
        for(int x = 0; x < numContacts; x++)
        {
            if (contactList[x].getHomeAddress().city.compareTo(cityName)==0)
            {
                return true;
            }
        }
        return false;
    }

    //Method for getting contacts by first and last name
    public Contact getContactByFullName(String fName,String lName)
    {
        for (int x = 0; x < numContacts; x++)
        {
            if (contactList[x].getFirstName().compareTo(fName) == 0 && contactList[x].getLastName().compareTo(lName) == 0)
            {
                return contactList[x];
            }
        }
        return null;
    }
    public Contact[] getContactList(){
        return contactList;
    }

    //Method for finding contacts in same city
    public String contactsWithCity(String cityName)
    {
        String s = "Contact with city: "+cityName;
        for (int x = 0; x < numContacts; x++)
        {
            if (contactList[x].getHomeAddress().city.compareTo(cityName) == 0)
            {
                s += "\nFirst Name: " + contactList[x].getFirstName() + "\nLast Name: " + contactList[x].getLastName() + "\nPhone Number: " +contactList[x].getHomePhone() + "\n";
            }
        }
        return s;
    }

    //Method for deleting contact
    public boolean deleteContact(String fName, String lName)
    {
        ArrayList<Contact> list=new ArrayList<Contact>(Arrays.asList(contactList));
        for (int x = 0; x < numContacts; x++)
        {
            if (list.get(x).getFirstName().compareTo(fName) == 0 && list.get(x).getLastName().compareTo(lName) == 0)
            {
                list.remove(x);
                for(int i=0;i<list.size();i++){
                    contactList[i]=list.get(i);
                }
                numContacts--;
                return true;
            }
        }
        return false;
    }

    //Method for editing contacts
    public boolean editContact(String firstName, String lastName, String homePhone, String workPhone,
                               String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country,
                               String email, int day, int month, int year, String notes)
    {
        if(addContact(firstName, lastName, homePhone, workPhone, streetInfo1, streetInfo2,
                city,postalCode,province, country, email, day, month, year, notes))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
