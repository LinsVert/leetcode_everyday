package Structure.SegmentTree;

/**
 * 线段树 动态开点 + 懒加载
 * 通用结构体
 * @author linsvert
 */
public class SegmentTreeAuto<T> {

    private final Merge<T> merge;

    public SegmentTreeAuto(Merge<T> merge) {
        this.merge = merge;
    }

    /**
     * 更新操作
     * @param node 当前节点
     * @param l 节点的左区间
     * @param r 节点的右区间
     * @param findL 需要更新的左区间
     * @param findR 需要更新的右区间
     * @param val 更新的值
     */
    public void update(Node<T> node, int l, int r, int findL, int findR, T val) {
        if (findL <= l && findR >= r) {
            node.val = this.merge.merge(node.val, val, r - l + 1);
            node.merge = this.merge.merge(node.merge, val);
            return;
        }
        lazyCreate(node);
        pushDown(node, l, r);

        int mid = l + ((r - l) >> 1);

        if (findL <= mid) {
            update(node.left, l, mid, findL, findR, val);
        }
        if (findR > mid) {
            update(node.right, mid + 1, r, findL, findR, val);
        }
        pushUp(node);
    }

    /**
     * 向上更新
     */
    public void pushUp(Node<T> node) {
        node.val = this.merge.merge(node.left.val, node.right.val);
    }

    /**
     * 下发更新
     */
    public void pushDown(Node<T> node, int l, int r) {

        //如果没有懒加载 返回
        if (node.merge == null) {
            return;
        }

        int mid = l + ((r - l) >> 1);

        //更新子节点的值
        node.left.val = this.merge.merge(node.left.val, node.merge, mid - l + 1);
        node.right.val = this.merge.merge(node.right.val, node.merge, r - mid);

        //下发更新
        node.left.merge = this.merge.merge(node.left.merge, node.merge);
        node.right.merge = this.merge.merge(node.right.merge, node.merge);

        node.merge = null;
    }

    public void lazyCreate(Node<T> node) {
        if (node.left == null) {
            node.left = new Node<>();
        }
        if (node.right == null) {
            node.right = new Node<>();
        }
    }


    /**
     * 查询区间内节点 起点为全区间 根节点
     * @param node 对应区间的起始节点
     * @param l 该节点的左区间
     * @param r 该节点的右区间
     * @param findL 目标左区间
     * @param findR 目标右区间
     * @return T
     */
    public T query(Node<T> node, int l, int r, int findL, int findR) {
        //区间断开 直接返回 和上层query进行merge
        if (findL <= l && findR >= r) {
            return node.val;
        }
        lazyCreate(node);
        //防止 l + r 求和超过 int最大值
        int mid = l + ((r - l) >> 1);
        pushDown(node, l, r);
        //在右子节点
        if (findL > mid) {
            return query(node.right, mid + 1, r, findL, findR);
        } else if (findR <= mid) {
            return query(node.left, l, mid, findL, findR);
        }
        //断开区间的 需要合并查询结果 [findL, mid] [mid + 1, findR]
        return this.merge.merge(query(node.left, l, mid, findL, mid), query(node.right, mid + 1, r, mid + 1, findR));
    };

    /**
     * 树节点数据结构
     */
    public static class Node<T> {
        /**
         * 左子树
         */
        Node<T> left;
        /**
         * 右子树
         */
        Node<T> right;
        /**
         * 懒加载标记
         */
        T merge;
        /**
         * 当前节点的值
         */
        T val;
    }

    /**
     * 合并接口
     * @param <T>
     */
    public interface Merge<T> {
        /**
         * 区间数据的合并方法
         * @param a T
         * @param b T
         * @return T
         */
        T merge(T a, T b);

        /**
         * 区间数据的合并方法
         * @param a T
         * @param b T
         * @param diff 节点数
         * @return T
         */
        T merge(T a, T b, int diff);

    }
}
