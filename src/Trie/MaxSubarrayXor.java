package Trie;

public class MaxSubarrayXor {

    static final int INT_SIZE = 32;

    static class TrieNode {
        int value;
        TrieNode[] arr =  new TrieNode[2];
        public TrieNode() {
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }
    static TrieNode root;

    static void insert(int pre_xor) {
        TrieNode temp = root;

        for (int i=INT_SIZE-1; i>=0; i--) {
            int val = (pre_xor & (1<<i)) >=1 ? 1 : 0;

            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();

            temp = temp.arr[val];
        }
        temp.value = pre_xor;
    }

    static int query(int pre_xor) {
        TrieNode temp = root;
        for (int i=INT_SIZE-1; i>=0; i--) {
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;

            if (temp.arr[1-val] != null)
                temp = temp.arr[1-val];

            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return pre_xor^(temp.value);
    }

    static int maxSubarrayXOR(int arr[], int n) {

        root = new TrieNode();
        insert(0);

        int result = Integer.MIN_VALUE;
        int pre_xor =0;

        for (int i=0; i<n; i++) {
            pre_xor = pre_xor^arr[i];
            insert(pre_xor);

            result = Math.max(result, query(pre_xor));
        }
        return result;
    }

    public static void main(String args[]) {
        int arr[] = {8, 1, 2, 12};
        int n = arr.length;
        System.out.println("Max subarray XOR is " +
                maxSubarrayXOR(arr, n));
    }
}