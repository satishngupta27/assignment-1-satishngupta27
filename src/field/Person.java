package field;

import node.MyLinkedList;

public class Person {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private MyLinkedList<Long> contactNumber;

    public Person(String firstName, String lastName, String emailAddress, MyLinkedList<Long> contactNumber) {
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

    public MyLinkedList<Long> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(MyLinkedList<Long> contactNumber) {
        this.contactNumber = contactNumber;
    }
}
