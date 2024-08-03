package generics;

public class ReuseCode {
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{3, 2, 1, 0, 4};
//        insertionSortInt(intArray);
//        System.out.println(Arrays.toString(intArray));
//
//        String[] strArray = new String[]{"a", "c", "a"};
//        insertionSortString(strArray);
//        System.out.println(Arrays.toString(strArray));
//
//

    }

    public static Integer[] insertionSortInt(Integer[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            var current = intArray[i];
            int j = i - 1;
            while (j >= 0 && intArray[j].compareTo(current) > 0) {
                intArray[j + 1] = intArray[j];
                j--;
            }
            intArray[j + 1] = current;
        }
        return intArray;
    }

    public static String[] insertionSortString(String[] strArray) {
        for (int i = 1; i < strArray.length; i++) {
            var current = strArray[i];
            int j = i - 1;
            while (j >= 0 && strArray[j].compareTo(current) > 0) {
                strArray[j + 1] = strArray[j];
                j--;
            }
            strArray[j + 1] = current;
        }
        return strArray;
    }




    public static Comparable[] insertionSortComparable(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            var current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }
}
