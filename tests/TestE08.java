import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE08 {
    public static void main(String[] args) {
        // Test data: [[1,2,3],[4,5,6]] shape [2,3]
        NDArray a = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);

        // Global reduction
        emit("sum_global", Float.toString(a.sum()));
        emit("mean_global", Float.toString(a.mean()));

        // sum along axis (no keepDims)
        NDArray s0 = a.sum(0, false);
        emit("sum_axis0_nokeep", s0.toString());
        emit("sum_axis0_shape_nokeep", Arrays.toString(s0.shape()));

        NDArray s1 = a.sum(1, false);
        emit("sum_axis1_nokeep", s1.toString());
        emit("sum_axis1_shape_nokeep", Arrays.toString(s1.shape()));

        // sum along axis (keepDims=true)
        NDArray s0k = a.sum(0, true);
        emit("sum_axis0_keep", s0k.toString());
        emit("sum_axis0_shape_keep", Arrays.toString(s0k.shape()));

        NDArray s1k = a.sum(1, true);
        emit("sum_axis1_keep", s1k.toString());
        emit("sum_axis1_shape_keep", Arrays.toString(s1k.shape()));

        // mean along axis
        NDArray m1 = a.mean(1, false);
        emit("mean_axis1_nokeep", m1.toString());

        NDArray m0k = a.mean(0, true);
        emit("mean_axis0_keep", m0k.toString());

        // Negative axis
        NDArray sNeg = a.sum(-1, false);
        emit("sum_neg_axis", sNeg.toString());

        // 3D array: [[[1,2],[3,4]],[[5,6],[7,8]]] shape [2,2,2]
        NDArray b = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8}, 2, 2, 2);
        NDArray b1 = b.sum(1, false);
        emit("sum_3d_axis1", b1.toString());
        emit("sum_3d_axis1_shape", Arrays.toString(b1.shape()));

        // Multi-axis sum: axes=[0,2] on shape [2,2,2]
        NDArray bm = b.sum(new int[]{0, 2}, false);
        emit("sum_multi_axes", bm.toString());
        emit("sum_multi_axes_shape", Arrays.toString(bm.shape()));

        // 1D array sum
        NDArray c = NDArray.fromArray(new float[]{10, 20, 30}, 3);
        NDArray c0 = c.sum(0, false);
        emit("sum_1d", Float.toString(c0.sum()));

        // Error: invalid axis
        try {
            a.sum(3, false);
            emit("sum_axis_error", "NO_ERROR");
        } catch (Exception e) {
            emit("sum_axis_error", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
