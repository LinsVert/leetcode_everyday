package Structure.SegmentTree;

public class SegmentTreeTest {
    public static void main(String[] args) {
        SegmentTreeAuto.Node<Integer> node = new SegmentTreeAuto.Node<>();
        SegmentTreeAuto<Integer> segmentTreeAuto = new SegmentTreeAuto<>(new SegmentTreeAuto.Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return this.merge(a, b, 1);
            }

            @Override
            public Integer merge(Integer a, Integer b, int diff) {
                if (a == null && b == null) {
                    return null;
                }
                return 1;
            }
        });
        int l = 0, r = (int) 1e9;
        segmentTreeAuto.update(node, 0, r, 10, 20, 1);
        Integer result = segmentTreeAuto.query(node, l, r, 20, 30);
        System.out.println(node.toString());

    }
}
