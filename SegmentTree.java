package org.example;

public class SegmentTree {

    private int[] tree;
    private int size;

    public SegmentTree(int[] arr) {
        size = arr.length;
        tree = new int[4 * size];
        buildTree(arr, 1, 0, size - 1);
    }


    private void buildTree(int[] arr, int v, int tl, int tr) {
        if (tl == tr) {
            tree[v] = arr[tl];
        } else {
            int tm = (tl + tr) / 2;
            buildTree(arr, v * 2, tl, tm);
            buildTree(arr, v * 2 + 1, tm + 1, tr);
            tree[v] = tree[v * 2] + tree[v * 2 + 1];
        }
    }


    public void update(int i, int value) {
        updateHelper(1, 0, size - 1, i, value);
    }

    private void updateHelper(int v, int tl, int tr, int i, int value) {
        if (tl == tr) {
            tree[v] = value;
        } else {
            int tm = (tl + tr) / 2;
            if (i <= tm) {
                updateHelper(v * 2, tl, tm, i, value);
            } else {
                updateHelper(v * 2 + 1, tm + 1, tr, i, value);
            }
            tree[v] = tree[v * 2] + tree[v * 2 + 1];
        }
    }


    public int sum(int l, int r) {
        return sumHelper(1, 0, size - 1, l, r);
    }

    private int sumHelper(int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return tree[v];
        }
        int tm = (tl + tr) / 2;
        return sumHelper(v * 2, tl, tm, l, Math.min(r, tm))
                + sumHelper(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }
}

