package example;

public class Person {

    private String phoneNumber;
    private String firstname;
    private String surname;
    private String address;
    private String emails;

    public Person(String phoneNumber, String firstname, String surname, String address, String emails) {
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.emails = emails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }
}
