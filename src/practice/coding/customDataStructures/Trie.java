package practice.coding.customDataStructures;

/**
 * Created by rnuka on 1/25/17.
 */
public class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //insert into trie
    public void insert(String word){

        TrieNode p = root;

        //loop through each char of word and insert into Trie
        for(char ch : word.toCharArray()){
            int charPos = ch - 'a';
            if(p.children[charPos] == null){
                TrieNode child = new TrieNode();
                p.children[charPos] = child;
                p = child;
            }else{
                p = p.children[charPos];
            }
        }
        p.endFlag = true;
    }

    //search the trie
    public boolean search(String word){

        TrieNode p = root;

        //loop through each character and see if can be found
        for(char ch: word.toCharArray()){
            int charPos = ch - 'a';
            if(p.children[charPos] == null){
                return false;
            }else{
                p = p.children[charPos];
            }
        }

        if(p.endFlag == true){
            return true;
        }else{
            return false;
        }

    }



    //TrieNode structure
    class TrieNode{
        TrieNode[] children;
        boolean endFlag;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }



    void testcaseAdd(String word){
        insert(word);
    }

    static void testbed(){
        Trie t = new Trie();
        t.testcaseAdd("apple");
        System.out.println("word apple is found in Trie? "+t.search("apple"));
    }

    public static void main(String args[]){
        testbed();
    }



}
