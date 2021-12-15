
package com.example.assignment2;

public class Contact {

    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private Address homeAdress;
    private String email;
    private MyDate birthday;
    private String notes;

    public Contact(String firstName, String lastName, String homePhone, String workPhone,
                   String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country,
                   String email, int day, int month, int year, String notes)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAdress = new Address(streetInfo1, streetInfo2, city, postalCode, province, country);
        this.email = email;
        this.birthday = new MyDate(day, month, year);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public Address getHomeAddress() {
        return homeAdress;
    }

    public void setHomeAddress(Address homeAdress) {
        this.homeAdress = homeAdress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString(){
        String output = "\n<------- Contact Information ------->";
        output += "\nFirst name: " + firstName;
        output += "\nLast name: " + lastName;
        output += "\nHome Phone: " + homePhone;
        output += "\nWork Phone: " + workPhone;
        output += "\n" + homeAdress.toString();
        output += "\nEmail: " + email;
        output += "\n" + birthday.toString();
        output += "\nNotes: " + notes;
        output += "";
        return output;
    }
}
