import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shaileshvajpayee on 1/28/17.
 */
public class Contacts {
    private static Scanner s;
    private static Trie_Node root;

    public Contacts(){
        s = new Scanner(System.in);
        root = new Trie_Node(0);
    }

    /**
     * Prints the contact list with given prefix
     * @param node the curr node
     */
    void print_contact_list(Trie_Node node){
        System.out.println("Total contacts : " + node.contacts_with_pref.size());
        System.out.println(node.contacts_with_pref.toString());
    }

    /**
     * Traverse the phonebook
     * @param root the root of the trie
     * @param prefix the prefix for the contacts.
     */
    void traverse_phonebook(Trie_Node root, String prefix){
        for(char c:prefix.toCharArray()){
            root = root.get_child(c);
        }
        print_contact_list(root);
    }

    /**
     * Insert trie node for contact.
     * @param contact the contact for the trie node.
     */
    void insert_trie_node(String contact){
        Trie_Node Parent = root;
        char c;
        root.contact_list(contact);
        for (int i = 0; i < contact.length(); i++) {
            c = contact.charAt(i);
            if(Parent.has_child_at_c(c)){
                Parent = Parent.get_child(c);
                Parent.contact_list(contact);
            }
            else {
                Parent.insert_child(c);
                Parent = Parent.get_child(c);
                Parent.contact_list(contact);
            }
        }
    }

    /**
     * Function used to create a phone book
     */
    public void create_phonebook(ArrayList<String> contacts){
        Trie_Node new_node = root;
        for(String contact:contacts){
            insert_trie_node(contact);
        }
        System.out.println("Finished insertion in trie!");
    }

    /**
     * This is the main function of the class
     * @param args : ignored
     */
    public static void main(String[] args){
        Contacts app = new Contacts();
        char option = 'c';
        System.out.println("\t\tCONTACTS\n");
        while(option != '4') {
            System.out.println("Please choose an option:\n1) Insert contacts\n2) display phonebook\n3) Search\n4) Exit");
            option =  s.nextLine().charAt(0);
            ArrayList<String> contacts = new ArrayList<>();
            switch(option) {
                case '1':
                    System.out.println("Enter number of contacts");
                    int number_of_contacts = Integer.parseInt(s.nextLine());
                    for (int i = 0; i < number_of_contacts; i++) {
                        System.out.println("Enter contact name: ");
                        contacts.add(s.nextLine().toLowerCase());
                    }
                    app.create_phonebook(contacts);
                    break;
                case '2':
                    System.out.println("Your phonebook");
                    app.print_contact_list(root);
                    break;
                case '3':
                    System.out.println("Please enter a prefix to search the contacts");
                    String prefix = s.nextLine();
                    System.out.println("Contacts with requested prefix: -");
                    app.traverse_phonebook(root, prefix);
                    break;
                case '4':
                    System.exit(0);
            }
        }
    }

}
