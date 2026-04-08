import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE09 {
    public static void main(String[] args) {
        // Test data: [[3,1,4],[1,5,9]] shape [2,3]
        NDArray a = NDArray.fromArray(new float[]{3,1,4,1,5,9}, 2, 3);

        // max
        emit("max_axis1", a.max(1, false).toString());
        NDArray maxKeep = a.max(0, true);
        emit("max_axis0_keep", maxKeep.toString());
        emit("max_axis0_keep_shape", Arrays.toString(maxKeep.shape()));

        // min
        emit("min_axis0", a.min(0, false).toString());
        emit("min_axis1_keep", a.min(1, true).toString());

        // argmax
        emit("argmax_axis1", a.argmax(1).toString());
        emit("argmax_axis0", a.argmax(0).toString());

        // argmin
        emit("argmin_axis1", a.argmin(1).toString());
        emit("argmin_axis0", a.argmin(0).toString());

        // prod — use [[1,2,3],[4,5,6]] shape [2,3]
        NDArray b = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        emit("prod_axis1", b.prod(1).toString());
        emit("prod_axis0", b.prod(0).toString());

        // var / std — use [[1,3],[2,4]] shape [2,2] (exact results)
        NDArray c = NDArray.fromArray(new float[]{1,3,2,4}, 2, 2);
        emit("var_axis1", c.var(1, false).toString());
        emit("var_axis0_keep", c.var(0, true).toString());
        emit("std_axis1", c.std(1, false).toString());
        emit("std_axis0", c.std(0, false).toString());

        // countNonZero
        NDArray d = NDArray.fromArray(new float[]{0,1,0,3,5}, 5);
        emit("count_nonzero", Integer.toString(d.countNonZero()));

        // countNonZero 2D
        NDArray e = NDArray.fromArray(new float[]{0,1,2,0,3,4}, 3, 2);
        emit("count_nonzero_2d", Integer.toString(e.countNonZero()));

        // Negative axis
        emit("max_neg_axis", a.max(-1, false).toString());

        // 3D: [[[3,1],[4,1]],[[5,9],[2,6]]] shape [2,2,2]
        NDArray f = NDArray.fromArray(new float[]{3,1,4,1,5,9,2,6}, 2, 2, 2);
        emit("max_3d", f.max(1, false).toString());

        // Error: invalid axis
        try {
            a.max(3, false);
            emit("max_axis_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("max_axis_error", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
