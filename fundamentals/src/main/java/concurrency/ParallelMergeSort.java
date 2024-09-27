package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort<T extends Comparable<? super T>> extends RecursiveAction {
    private List<T> list;

    public ParallelMergeSort(List<T> list) {
        this.list = list;
    }

    @Override
    protected void compute() {
        var size = list.size();
        if (size < 2) {
            return;
        }

        var leftList = new ArrayList<>(list.subList(0, size / 2));
        var rightList = new ArrayList<>(list.subList(size / 2, size));
        var leftTask = new ParallelMergeSort<>(leftList);
        var rightTask = new ParallelMergeSort<>(rightList);
        leftTask.fork();
        rightTask.fork();
        leftTask.join();
        rightTask.join();
        merge(list, leftList, rightList);
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
