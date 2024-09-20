package concurrency;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4, 2, 1, 3, 0, 5));
        sort(list);
        System.out.println(list);
    }

    public static <T extends Comparable<? super T>> void sort(List<T> elements) {
        var size = elements.size();
        if (size < 2) {
            return;
        }

        var left = new ArrayList<>(elements.subList(0, size / 2));
        var right = new ArrayList<>(elements.subList(size / 2, size));

        sort(left);
        sort(right);

        merge(elements, left, right);
    }

    private static <T extends Comparable<? super T>> void merge(List<T> elements, List<T> left,
                                                           List<T> right) {
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                elements.set(i + j, left.get(i));
                i++;
            } else {
                elements.set(i + j, right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            elements.set(i + j, left.get(i));
            i++;
        }

        while (j < right.size()) {
            elements.set(i + j, right.get(j));
            j++;
        }
    }
}
