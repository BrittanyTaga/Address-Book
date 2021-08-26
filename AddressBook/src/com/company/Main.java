package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        //array lists of hashmaps, object maybe a little more tidier, make sure the input is only a number
        try {


            ArrayList<Entry> list = new ArrayList<Entry>();
            boolean isrunning = true;

            while (isrunning) {
                //ensures that it prints out
                System.out.println("1) Add an entry \n" +
                        "2) Remove and entry\n" +
                        "3) Search for specific entry\n" +
                        "4) Print Address Book\n" +
                        "5) Delete Book\n" +
                        "6) Quit\n" +
                        "Can only take in a number\n");
                Scanner myObj = new Scanner(System.in);
                int a = myObj.nextInt();

                if (a == 1) {


                    //Add an entry
                    System.out.println("First Name:");
                    String firstName = myObj.next(); //getting first name
                    System.out.println("Last Name:");
                    String lastName = myObj.next();//getting last name
                    System.out.println("Phone Number:");
                    String phoneNumber = myObj.next();//getting phone number
                    System.out.println("Email:");
                    String email = myObj.next();//getting email

                    //take an entry and store into constructor
                    Entry nentry = new Entry(firstName, lastName, phoneNumber, email);
                    list.add(nentry);

                }


                //remove an entry

                else if (a == 2) {
                    System.out.println("Which entry to do you want to delete?");
                    Scanner removeEntry = new Scanner(System.in);
                    String remove = removeEntry.next();
                    Entry removeObj = null;

                    for(Entry acontact : list){
                        if (acontact.getFirstName().contains(remove) &&
                            acontact.getLastName().contains(remove)) {
                                removeObj = acontact;
                                break;
                            }

                                }
                    if(removeObj == null){
                        System.out.println("Contact not found");
                    }
                    else {
                        list.remove(removeObj);
                        System.out.println("Contact deleted");
                    }
                }

                //Search for a specific entry
                else if (a == 3) {

                    System.out.println("What are you searching for?");
                    Scanner userSearch = new Scanner(System.in);
                    String find = userSearch.next();


                    list.forEach(contact ->
                            {
                                if (contact.getFirstName().contains(find) ||
                                        contact.getPhoneNumber().contains(find) ||
                                        contact.getLastName().contains(find) ||
                                        contact.getEmail().contains(find)) {
                                    System.out.println(contact);
                                } else {
                                    System.out.println("No contact can be found");
                                }
                            }
                    );


                }

                //Print the contents of the address book
                //maybe a for loop
                else if (a == 4) {
                    list.forEach((e) -> System.out.println(e));
                }
                //Delete the contents of the address book
                else if (a == 5)
                    list.clear();


                else if (a == 6) {
                    //quit the program
                    isrunning = false;
                }


            }
        } catch (Exception e){
            e.printStackTrace();        }
    }
}
