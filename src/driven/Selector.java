package driven;

import field.Person;
import node.MyLinkedList;
import regex.RegexCheck;

import java.util.Scanner;

public class Selector {
    Scanner scanner = new Scanner(System.in);
    Person personLinked = null;
    RegexCheck check = new RegexCheck();

    public Person addDetails() {
        System.out.print("You have chosen to add a new contact: \n" +
                "Please enter the name of the Person\n" +
                "First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name : ");
        String lastName = scanner.nextLine();
        MyLinkedList<Long> contactList = new MyLinkedList<>();
        char choice = 'y';
        MyLinkedList<Long> contactNumber = 0L;
        while (choice == 'y') {
            System.out.print("Contact Number: ");
            contactNumber = Long.parseLong(scanner.nextLine());
            if (check.isContactNumberCorrect(contactNumber)) {
                contactList.insert(contactNumber);
            } else {
                System.out.println("Invalid Contact Number Entered");
                continue;
            }
            System.out.print("Would you like to add another contact number? (y/n): ");
            choice = (scanner.nextLine()).charAt(0);

        }
        System.out.print("Would you like to add email address? (y/n): ");
        char ch = scanner.nextLine().charAt(0);
        String emailId = "";
        if (ch == 'y') {
            System.out.print("Email Address: ");
            emailId = scanner.nextLine();
        }
        while (ch == 'y') {
            if (check.isEmailCorrect(emailId)) {
                personLinked = new Person(firstName, lastName, emailId, contactNumber);
                break;
            } else {
                System.out.println("Invalid Email Address Entered");
                System.out.print("Email Address: ");
                emailId = scanner.nextLine();
            }
        }
        if (ch == 'n') {
            personLinked = new Person(firstName, lastName, "", contactNumber);
        }
        return personLinked;
    }

    public void print(Person person) {
        System.out.print("-------- * -------- * -------- * --------\n" +
                "First Name: " + person.getFirstName() + "\n" +
                "Last Name: " + person.getLastName() + "\n");
        if (person.getContactNumber().getSize() > 1) {
            System.out.print("Contact Number(s): ");
            for (int j = 0; j < person.getContactNumber().getSize(); j++) {
                System.out.print(person.getContactNumber().getNode(j).getData() + (j < person.getContactNumber().getSize() - 1 ? ", " : ""));
            }
        } else {
            System.out.print("Contact Number: " + person.getContactNumber().getNode(0).getData());
        }
        if (person.getEmailAddress().compareTo("") != 0) {
            System.out.print("\nEmail Address: " + person.getEmailAddress());
        }
        System.out.println("\n-------- * -------- * -------- * --------");

    }

    public void searchContact(MyLinkedList personLinked) {
        MyLinkedList<Person> searchedContact = new MyLinkedList<>();
        System.out.println("You could search for a contact from their first names: ");
        String elementFor = scanner.nextLine();
        int match = 0;
        for (int i = 0; i < personLinked.getSize(); i++) {
            Person person1 = (Person) personLinked.getNode(i).getData();
            if (elementFor.equals(person1.getFirstName())) {
                match++;
                searchedContact.insert(person1);
            }
        }
        if (match > 0) {
            System.out.println(match + " match found!");
            for (int i = 0; i < searchedContact.getSize(); i++) {
                Person name = (Person) searchedContact.getNode(i).getData();
                print(name);
            }
        } else {
            System.out.println("NO RESULTS FOUND!");
        }
    }

    public void viewContact(MyLinkedList person1) {
        System.out.println("---Here are all your contacts---");
        int size = person1.getSize();
        for (int i = 0; i < size; i++) {
            Person person = (Person) person1.getNode(i).getData();
            print(person);
        }
    }

    public void deleteContact(MyLinkedList personLinked) {
        System.out.println("Here are all your contacts");
        int i = 0;
        System.out.println("Here are all your contacts: ");
        for (int j = 0; j < personLinked.getSize(); j++) {
            Person person1 = (Person) personLinked.getNode(j).getData();
            System.out.println(++i + ". " + person1.getFirstName() + " " + person1.getLastName());
        }
        System.out.println("Press the number against the contact to delete it: ");
        int number = scanner.nextInt();
        Person person2 = (Person) personLinked.getNode(number - 1).getData();
        System.out.println(person2.getFirstName() + "'s contact deleted from list!");
        personLinked.delete(number - 1);
    }

}
