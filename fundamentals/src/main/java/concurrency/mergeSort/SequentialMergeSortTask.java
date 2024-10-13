package concurrency.mergeSort;

import java.util.ArrayList;
import java.util.List;

public class SequentialMergeSortTask<T extends Comparable<? super T>> extends MergeSortTask<T>{

    public SequentialMergeSortTask(List<T> list) {
        super(list);
    }

    @Override
    protected void compute() {
        int size = list.size();
        if (size < 2) {
            return;
        }
        var left = new ArrayList<>(list.subList(0, size / 2));
        var right = new ArrayList<>(list.subList(size / 2, size));
        var leftTask = new SequentialMergeSortTask<>(left);
        var rightTask = new SequentialMergeSortTask<>(right);
        leftTask.compute();
        rightTask.compute();

        super.merge(list, left, right);
    }
}
