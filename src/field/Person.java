package field;

import node.MyLinkedList;

public class Person {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private MyLinkedList<String> contactNumber;

    public Person(String firstName, String lastName, String emailAddress, MyLinkedList<String> contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public MyLinkedList<String> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(MyLinkedList<String> contactNumber) {
        this.contactNumber = contactNumber;
    }
}
