import java.util.ArrayList;

/**
 * Created by shaileshvajpayee on 1/28/17.
 */
public class Trie_Node {
    Trie_Node[] children;
    int depth;
    int num_children;
    boolean has_contact;
    ArrayList<String> contacts_with_pref;

    /**
     * Constructor
     * @param child_depth: depth for the child
     */
    public Trie_Node(int child_depth) {
        children = new Trie_Node[27];
        depth = child_depth;
        num_children = 0;
        has_contact = false;
        contacts_with_pref = new ArrayList<>();
    }

    /**
     * returns child at location c in array
     * @param c : the character
     * @return required Trie_Node
     */
    Trie_Node get_child(char c){
        if(c == ' '){
            return children[27];
        }
        return children[((int)c - 97)%27];
    }

    /**
     * increase depth of the node.
     */
    void increase_depth(){
        depth++;
    }

    /**
     * return contacts stored down the trie from curr node.
     * @param contact the contact in phonebook
     */
    void contact_list(String contact) {
        contacts_with_pref.add(contact);
    }

    /**
     * Function to insert child at char c
     * @param c : the character in contact
     */
    void insert_child(char c){
        Trie_Node child = new Trie_Node(depth + 1);
        if(c == ' ')
            children[27] = child;
        else
            children[((int) c - 97) % 27] = child;
        num_children++;
    }

    /**
     * to check if trie node is at char c in children array.
     * @param c : the character
     * @return true or false
     */
    boolean has_child_at_c(char c){
        if(c == ' ' && children[27] == null)
            return false;
        else if(children[((int) c - 97) % 27] == null && c != ' ')
            return false;
        else
            return true;
    }
}
