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
}
