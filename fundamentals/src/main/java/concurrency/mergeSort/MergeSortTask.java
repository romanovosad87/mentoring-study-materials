package concurrency.mergeSort;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public abstract class   MergeSortTask<T extends Comparable<? super T>> extends RecursiveAction {
    public List<T> list;

    public MergeSortTask(List<T> list) {
        this.list = list;
    }

    public void merge(List<T> list, List<T> left, List<T> right) {
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                list.set((i + j), left.get(i));
                i++;
            } else {
                list.set((i + j), right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            list.set((i + j), left.get(i++));
        }

        while (j < right.size()) {
            list.set((i + j), right.get(j++));
        }
    }
}
