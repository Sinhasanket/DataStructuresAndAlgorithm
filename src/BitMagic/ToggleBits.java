package BitMagic;

public class ToggleBits {
    static int setmiddlebits(int n) {

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n >> 1) ^ 1;
    }

    static int togglemiddlebits(int n) {
        if (n == 1)
            return 1;
        return n ^ setmiddlebits(n);
    }

    public static void main (String[] args) {
        int n = 3;
           System.out.println(togglemiddlebits(n));
    }
}