package com.rrachet.dsaforge.benchmarks;

import com.rrachet.dsaforge.sorting.MergeSort;
import com.rrachet.dsaforge.sorting.QuickSort;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class SortingBenchmark {
    private int[] source;

    @Setup(Level.Trial)
    public void setup() {
        source = ThreadLocalRandom.current().ints(10_000, -100_000, 100_000).toArray();
    }

    @Benchmark
    public int[] mergeSort() {
        int[] copy = source.clone();
        MergeSort.sort(copy);
        return copy;
    }

    @Benchmark
    public int[] quickSort() {
        int[] copy = source.clone();
        QuickSort.sort(copy);
        return copy;
    }
}
