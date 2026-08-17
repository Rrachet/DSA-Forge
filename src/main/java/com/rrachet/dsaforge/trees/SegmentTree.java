package com.rrachet.dsaforge.trees;

/** Segment tree supporting point updates and inclusive range-sum queries in O(log n). */
public final class SegmentTree {
    private final int[] tree;
    private final int size;

    public SegmentTree(int[] values) {
        if (values == null || values.length == 0) throw new IllegalArgumentException("values must not be empty");
        size = values.length;
        tree = new int[size * 4];
        build(values, 1, 0, size - 1);
    }

    public void update(int index, int value) {
        checkIndex(index);
        update(1, 0, size - 1, index, value);
    }

    public int rangeSum(int left, int right) {
        if (left < 0 || right >= size || left > right) throw new IndexOutOfBoundsException("invalid range");
        return query(1, 0, size - 1, left, right);
    }

    private void build(int[] values, int node, int left, int right) {
        if (left == right) { tree[node] = values[left]; return; }
        int mid = (left + right) >>> 1;
        build(values, node * 2, left, mid);
        build(values, node * 2 + 1, mid + 1, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private void update(int node, int left, int right, int index, int value) {
        if (left == right) { tree[node] = value; return; }
        int mid = (left + right) >>> 1;
        if (index <= mid) update(node * 2, left, mid, index, value);
        else update(node * 2 + 1, mid + 1, right, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private int query(int node, int left, int right, int ql, int qr) {
        if (ql <= left && right <= qr) return tree[node];
        int mid = (left + right) >>> 1;
        int sum = 0;
        if (ql <= mid) sum += query(node * 2, left, mid, ql, qr);
        if (qr > mid) sum += query(node * 2 + 1, mid + 1, right, ql, qr);
        return sum;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("invalid index: " + index);
    }
}
