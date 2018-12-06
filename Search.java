
public class Search {
    public boolean error = false;

    // 1.SEQUENTIAL SEARCH
    //O(n)
    public int sequentialSearch(int[] array, int target) {
        if (array != null && array.length > 0) {
            int index = 0;
            for (; index < array.length; index++)
                if (array[index] == target)
                    return index;
        }
        error = true;
        return -1;
    }

    //2.BINARY SEARCH
    //O(logn)
    public int binarySearch(int[] array, int target) {//suppose the array is ordered
        if (array != null && array.length > 0) {
            int start = 0;
            int end = array.length - 1;
            while (end >= start) {
                int mid = (start + end) >> 1;
                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        error = true;
        return -1;
    }

    public int binarySearchRecursion(int[] array, int start, int end, int target) {//suppose the array is ordered
        if (end == start && array[start] != target) {
            error = true;
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] == target)
            return mid;
        else if (array[mid] > target)
            end = mid;
        else
            start = mid;
        return binarySearchRecursion(array, start, end, target);
    }

    public int binarySearchTree(int[] array, int target) {
        if (array != null && array.length > 0) {
            BinarySortTree bst = new BinarySortTree(array);
            BinaryNode p = bst.search(target);
            if (p != null)
                return p.value;
        }
        error = true;
        return -1;
    }

    public static void main_temp(String[] args) {

        Search test = new Search();
        //test
        //founction test
        System.out.println("Founction Test:");
        int[] array = {54, 18, 66, 87, 36, 12, 54, 81, 15, 76, 6, 40, 99, 85, 99};
        //boundary test
        System.out.println("\nBoundary Test:");

        //exception test
        System.out.println("\nException Test:");
    }

    public void display(int[] array) {
        if (array == null || array.length < 1) {
            System.out.println("The array is Exception!");
            return;
        }
        System.out.print("The array: [ ");
        for (int k : array)
            System.out.print(k + " ");
        System.out.println("]");
    }
}
