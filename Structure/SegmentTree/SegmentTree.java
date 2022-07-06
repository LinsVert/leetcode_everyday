package Structure.SegmentTree;

import java.util.Arrays;

/**
 * 线段树 通用的数据结构
 *
 * @author linsvert
 */
public class SegmentTree<T> {
    /**
     * 线段树数组
     */
    private final T[] tree;
    /**
     * 原数据数组
     */
    private final T[] data;

    /**
     * 注入合并方法
     */
    private final Merge<T> merge;

    public SegmentTree(T[] data, Merge<T> merge) {
        this.data = data;
        this.merge = merge;
        //树的长度为 n * 4
        this.tree = (T[]) new Object[data.length * 4];
        if (data.length > 0) {
            build(0, 0, data.length - 1);
        }
    }

    T[] get() {
        return tree;
    }

    /**
     * 更新data[i]节点 对应的线段树
     * @param index int
     * @param t T
     */
    public void update(int index, T t) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = t;
        //更新其它节点信息
        updateTree(0, 0, getDataLength() - 1, index, t);
    }

    public void updateTree(int treeIndex, int l, int r, int index, T t) {
        if (l == r) {
            tree[treeIndex] = t;
            return;
        }
        int leftIndex = leftIndex(treeIndex);
        int rightIndex = rightIndex(treeIndex);
        int mid = l + r >> 1;
        if (index > mid) {
            updateTree(rightIndex, mid + 1, r, index, t);
        } else {
            updateTree(leftIndex, l, mid, index, t);
        }
        tree[treeIndex] = merge.merge(tree[leftIndex], tree[rightIndex]);
    }

    /**
     * 在treeIndex位置检索 [l, r] 内的 [findL, findR]
     *
     * @param treeIndex int
     * @param l         int
     * @param r         int
     * @param findL     int
     * @param findR     int
     * @return T
     */
    public T query(int treeIndex, int l, int r, int findL, int findR) {
        //检索到了
        if (l == findL && r == findR) {
            return tree[treeIndex];
        }
        int leftIndex = leftIndex(treeIndex);
        int rightIndex = rightIndex(treeIndex);
        int mid = l + r >> 1;
        if (findL > mid) {
            return query(rightIndex, mid + 1, r, findL, findR);
        }
        if (findR <= mid) {
            return query(leftIndex, l, mid, findL, findR);
        }
        //拆成两个区间 分别寻找[findL, mid] [mid + 1, findR]
        T left = query(leftIndex, l, mid, findL, mid);
        T right =  query(rightIndex, mid + 1, r, mid + 1, findR);
        return merge.merge(left, right);
    }

    /**
     * 构建线段树
     *
     * @param treeIndex 树索引
     * @param l         左区间起点
     * @param r         右区间起点
     */
    public void build(int treeIndex, int l, int r) {
        if (l == r) {
            this.tree[treeIndex] = data[l];
            return;
        }
        int mid = l + r >> 1;
        int lefIndex = leftIndex(treeIndex);
        int rightIndex = rightIndex(treeIndex);
        build(lefIndex, l, mid);
        build(rightIndex, mid + 1, r);

        //执行自定义的合并操作
        tree[treeIndex] = this.merge.merge(tree[lefIndex], tree[rightIndex]);
    }

    /**
     * 针对数组结构下 该节点左子节点的下标
     *
     * @param index int
     * @return int
     */
    private int leftIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 针对数组结构下 该节点右子节点的下标
     *
     * @param index int
     * @return int
     */
    private int rightIndex(int index) {
        return 2 * index + 2;
    }
    public int getDataLength () {
        return data.length;
    }


    /**
     * 两类T 合并接口
     *
     * @param <T>
     */
    public interface Merge<T> {
        /**
         * 合并方法
         *
         * @param a E
         * @param b E
         * @return T
         */
        T merge(T a, T b);
    }


    public static void main(String[] args) {
        Integer[] data = {1,3,5};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(data, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        segmentTree.update(1,2);
        Integer r = segmentTree.query(0, 0, data.length - 1, 0, 2);
        System.out.println(r);
        System.out.println(Arrays.toString(segmentTree.get()));
    }
}
