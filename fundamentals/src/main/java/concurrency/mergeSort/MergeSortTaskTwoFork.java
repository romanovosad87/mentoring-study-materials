package concurrency.mergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTaskTwoFork<T extends Comparable<? super T>> extends MergeSortTask<T> {
    public MergeSortTaskTwoFork(List<T> list) {
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
        var leftTask = new MergeSortTaskTwoFork<>(left);
        var rightTask = new MergeSortTaskTwoFork<>(right);
        leftTask.fork();
        rightTask.fork();
        leftTask.join();
        rightTask.join();

        super.merge(list, left, right);
    }
}
