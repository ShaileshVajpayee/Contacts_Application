import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shaileshvajpayee on 1/28/17.
 */
public class Contacts {
    private static ArrayList<String> contacts;
    private static Scanner s;
    private static Trie_Node root;

    public Contacts(){
        contacts = new ArrayList<>();
        s = new Scanner(System.in);
        root = new Trie_Node(0);

    }

    public static void main(String[] args){
        Contacts app = new Contacts();
        System.out.println("Enter number of contacts");
        int number_of_contacts = Integer.parseInt(s.nextLine());
//        int number_of_contacts = 0;
        for (int i = 0; i < number_of_contacts; i++)
            contacts.add(s.nextLine());
        app.create_phonebook();
        System.out.println("Your phonebook");
        app.print_contact_list(root);
        System.out.println("Please enter a prefix to search the contacts");
        String prefix = s.nextLine();
        System.out.println("Contacts with requested prefix: -");
        app.traverse_phonebook(root, prefix);
    }

    void print_contact_list(Trie_Node node){
        System.out.println(node.contacts_with_pref.toString());
    }

    void traverse_phonebook(Trie_Node root, String prefix){
        for(char c:prefix.toCharArray()){
            root = root.get_child(c);
        }
        print_contact_list(root);
    }

    void insert_trie_node(String contact){
        Trie_Node Parent = root;
        char c;

        for (int i = 0; i < contact.length(); i++) {
            c = contact.charAt(i);
            Parent.contact_list(contact);
            if(Parent.has_child_at_c(c)){
                Parent = Parent.get_child(c);
            }
            else {
                Parent.insert_child(c);
                Parent = Parent.get_child(c);
            }
        }
    }

    public void create_phonebook(){
        Trie_Node new_node = root;
        for(String contact:contacts){
            insert_trie_node(contact);
        }
        System.out.println("Finished insertion in trie!");
    }
}
