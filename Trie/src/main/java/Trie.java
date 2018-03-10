import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashSet;

class TreeNode{
    int count;
    TreeNode[] childNodes;
    char nodeChar;
    public TreeNode(){
        this.count = 0;
        this.childNodes = new TreeNode[26];
    }
}

public class Trie {
    TreeNode root;
    public Trie(){
        root = new TreeNode();
    }
    //插入字符串
    public void InsertTrieNode(String word){
        if(word == null || word.length() == 0)
            return;
        InsertTrieNode(this.root, word);
    }
    public void InsertTrieNode(TreeNode root,String word){
        if(word.length() == 0)
            return;
        int index = word.charAt(0) -'a';
        if(root.childNodes[index] == null){
            root.childNodes[index] = new TreeNode();
            root.childNodes[index].nodeChar = word.charAt(0);
        }
        word = word.substring(1);
        if(word.length() == 0){
            root.childNodes[index].count +=1;
        }
        InsertTrieNode(root.childNodes[index], word);
    }
    //删除节点
    public void DeleteTrieNode(String word){
        if(word == null || word.length() == 0)
            return;
        DeleteTrieNode(this.root, word);
    }
    public void DeleteTrieNode(TreeNode root, String word){
        if(word.length() == 0 && root.count>0){
            root.count -= 1;
            return;
        }
        int index = word.charAt(0) -'a';
        if(root.childNodes[index] == null)
            return;
        word = word.substring(1);
        DeleteTrieNode(root.childNodes[index], word);
    }
    //查找节点
    public TreeNode SearchTrieNode(String word){
        if(word == null || word.length() == 0)
            return null;
        return SearchTrieNode(this.root, word);
    }
    public TreeNode SearchTrieNode(TreeNode root, String word){
        if(word.length() == 0)
            return root;
        int index = word.charAt(0) -'a';
        if(root.childNodes[index] == null)
            return null;
        word = word.substring(1);
        return SearchTrieNode(root.childNodes[index], word);
    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.InsertTrieNode("and");
        trie.InsertTrieNode("a");
        trie.InsertTrieNode("animals");
        trie.InsertTrieNode("and");
        trie.InsertTrieNode("and");
        trie.InsertTrieNode("and");
        trie.InsertTrieNode("and");
        trie.InsertTrieNode("bug");
        trie.InsertTrieNode("b");
        trie.InsertTrieNode("bring");
        trie.InsertTrieNode("bugs");
        trie.InsertTrieNode("bug");
        trie.InsertTrieNode("cat");
        trie.InsertTrieNode("c");

        trie.DeleteTrieNode("and");
        trie.DeleteTrieNode("d");


        String target = "an";
        TreeNode node = trie.SearchTrieNode(target);
        if(node!=null){
            System.out.println(target +":"+  node.count);
        }else{
            System.out.println(" 找不到该节点");
        }
    }
}
