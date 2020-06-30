package Arrays;

class SortedAndRotated {

    static void checkIfSortRotated(int arr[], int n) {
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;

        int minIndex = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < minEle) {
                minEle = arr[i];
                minIndex = i;
            }
        }

        boolean flag1 = true;
        for (int i = 1; i < minIndex; i++) {
            if (arr[i] < arr[i - 1]) {
                flag1 = false;
                break;
            }
        }

        boolean flag2 = true;

        for (int i = minIndex + 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                flag2 = false;
                break;
            }
        }

        if(minIndex == 0) {
            System.out.print("NO");
            return;
        }

        if (flag1 && flag2 && (arr[n - 1] <
                arr[minIndex - 1]))
            System.out.println("YES");
        else
            System.out.print("NO");
    }

    public static void main (String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };

        int n = arr.length;

        checkIfSortRotated(arr, n);
    }
}