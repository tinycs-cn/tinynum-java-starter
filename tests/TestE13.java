import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE13 {
    public static void main(String[] args) {
        // ---- concatenate axis=0 ----
        NDArray a = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
        NDArray b = NDArray.fromArray(new float[]{5,6,7,8}, 2, 2);
        NDArray c0 = NDArray.concatenate(new NDArray[]{a, b}, 0);
        emit("concat_axis0", c0.toString());
        emit("concat_axis0_shape", Arrays.toString(c0.shape()));

        // ---- concatenate axis=1 ----
        NDArray c1 = NDArray.concatenate(new NDArray[]{a, b}, 1);
        emit("concat_axis1", c1.toString());
        emit("concat_axis1_shape", Arrays.toString(c1.shape()));

        // ---- concatenate different sizes on concat axis ----
        NDArray d = NDArray.fromArray(new float[]{9,10}, 1, 2);
        NDArray c2 = NDArray.concatenate(new NDArray[]{a, d}, 0);
        emit("concat_diff_size", c2.toString());
        emit("concat_diff_size_shape", Arrays.toString(c2.shape()));

        // ---- concatenate 1D ----
        NDArray e = NDArray.fromArray(new float[]{1,2,3}, 3);
        NDArray f = NDArray.fromArray(new float[]{4,5}, 2);
        NDArray c3 = NDArray.concatenate(new NDArray[]{e, f}, 0);
        emit("concat_1d", c3.toString());

        // ---- stack axis=0 ----
        NDArray g = NDArray.fromArray(new float[]{1,2,3}, 3);
        NDArray h = NDArray.fromArray(new float[]{4,5,6}, 3);
        NDArray s0 = NDArray.stack(new NDArray[]{g, h}, 0);
        emit("stack_axis0", s0.toString());
        emit("stack_axis0_shape", Arrays.toString(s0.shape()));

        // ---- stack axis=1 ----
        NDArray s1 = NDArray.stack(new NDArray[]{g, h}, 1);
        emit("stack_axis1", s1.toString());
        emit("stack_axis1_shape", Arrays.toString(s1.shape()));

        // ---- stack 2D ----
        NDArray i = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
        NDArray j = NDArray.fromArray(new float[]{5,6,7,8}, 2, 2);
        NDArray s2 = NDArray.stack(new NDArray[]{i, j}, 0);
        emit("stack_2d_shape", Arrays.toString(s2.shape()));

        // ---- pad ----
        NDArray p = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        NDArray p1 = p.pad(new int[][]{{1,1},{0,0}}, 0);
        emit("pad_rows", p1.toString());
        emit("pad_rows_shape", Arrays.toString(p1.shape()));

        // ---- pad with value ----
        NDArray p2 = p.pad(new int[][]{{0,0},{1,2}}, -1);
        emit("pad_cols_value", p2.toString());
        emit("pad_cols_shape", Arrays.toString(p2.shape()));

        // ---- pad 1D ----
        NDArray q = NDArray.fromArray(new float[]{1,2,3}, 3);
        NDArray q1 = q.pad(new int[][]{{2,1}}, 0);
        emit("pad_1d", q1.toString());

        // ---- flip axis=0 ----
        NDArray r = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        emit("flip_axis0", r.flip(0).toString());

        // ---- flip axis=1 ----
        emit("flip_axis1", r.flip(1).toString());

        // ---- flip 1D ----
        NDArray t = NDArray.fromArray(new float[]{1,2,3,4,5}, 5);
        emit("flip_1d", t.flip(0).toString());

        // ---- error: concat shape mismatch ----
        try {
            NDArray x1 = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
            NDArray x2 = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
            NDArray.concatenate(new NDArray[]{x1, x2}, 0);
            emit("concat_shape_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("concat_shape_error", "ERROR");
        }

        // ---- error: pad wrong padWidth length ----
        try {
            NDArray y = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
            y.pad(new int[][]{{1,1}}, 0);  // 1 pad for 2D
            emit("pad_dim_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("pad_dim_error", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
