package Trie;

public class Deletion {

    static int ALPHABATE_SIZE=26;

    static class TrieNode {
        TrieNode children[]=new TrieNode[ALPHABATE_SIZE];

        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord=false;
            for(int i = 0; i<ALPHABATE_SIZE;i++) {
                children[i]=null;
            }
        }
    };

    static TrieNode root;

    static void insert(String key) {
        int level;
        int length=key.length();
        int index;
        TrieNode pCrawl=root;
        for(level = 0;level<length;level++) {
            index=key.charAt(level)-'a';
            if(pCrawl.children[index]==null)
            {
                pCrawl.children[index]=new TrieNode();
            }
            pCrawl=pCrawl.children[index];
        }

        pCrawl.isEndOfWord=true;
    }

    static boolean search(String key) {
        int index;
        int length=key.length();
        int level;
        TrieNode pCrawl=root;

        for(level = 0;level<length;level++) {
            index=key.charAt(level)-'a';
            if(pCrawl.children[index]==null) {
                return false;
            }
            pCrawl=pCrawl.children[index];
        }

        if(pCrawl!=null && pCrawl.isEndOfWord) {
            return true;
        } else {
            return false;
        }
    }

    static boolean hasNoChild(TrieNode currentNode) {
        for(int level=0;level<currentNode.children.length;level++) {
            if(currentNode.children[level]!=null) {
                return false;
            }
        }
        return true;
    }

    static boolean removeUtil(TrieNode currentNode,String key,
                              int level,int length) {
        if(currentNode==null) {
            System.out.println("Does not exist");
            return false;
        }

        if(level==length) {
            currentNode.isEndOfWord=false;
            if(hasNoChild(currentNode)) {
                return true;
            } else {
                return false;
            }
        } else{
            TrieNode childNode =
                    currentNode.children[key.charAt(level)-'a'];

            boolean childDeleted =
                    removeUtil(childNode,key,level+1,length);

            if(childDeleted) {
                return (currentNode.isEndOfWord
                        &&hasNoChild(currentNode));
            }
        }

        return false;
    }

    static void remove(String key) {
        int length=key.length();

        if(length>0) {
            removeUtil(root,key,0,length);
        }
    }

    public static void main(String[] args) {
        root = new TrieNode();

        String keys[] = {"the", "a", "there",
                "answer", "any", "by", "bye", "their",
                "hero", "heroplane"};

        for (int i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        if (search("the") == true)
            System.out.println("Yes");
        else
            System.out.println("No");

        if (search("these") == true)
            System.out.println("Yes");
        else
            System.out.println("No");

        remove("heroplane");

        if (search("hero") == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
