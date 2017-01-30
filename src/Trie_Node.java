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

    public Trie_Node(int child_depth) {
        children = new Trie_Node[27];
        depth = child_depth;
        num_children = 0;
        has_contact = false;
        contacts_with_pref = new ArrayList<>();
    }

    Trie_Node get_child(char c){
        if(c == ' '){
            return children[27];
        }
        return children[((int)c - 97)%27];
    }

    void increase_depth(){
        depth++;
    }

    void contact_list(String contact) {
        contacts_with_pref.add(contact);
    }

    void insert_child(char c){
        if(c == ' ')
            children[27] = new Trie_Node(depth + 1);
        else
            children[((int) c - 97) % 27] = new Trie_Node(depth + 1);
        num_children++;
    }

    boolean has_child_at_c(char c){
        if(c == ' ' && children[27] == null)
            return false;
        else if(children[((int) c - 97) % 27] == null && c != ' ')
            return false;
        else
            return true;
    }
}
