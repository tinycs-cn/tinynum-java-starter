import dev.tensorhero.tinynum.NDArray;
import dev.tensorhero.tinynum.Slice;
import java.util.Arrays;

public class TestE11 {
    public static void main(String[] args) {
        // ---- slice 2D ----
        NDArray a = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8,9}, 3, 3);
        NDArray s1 = a.slice(Slice.of(0, 2), Slice.of(1, 3));
        emit("slice_2d", s1.toString());
        emit("slice_2d_shape", Arrays.toString(s1.shape()));

        // ---- slice with step ----
        NDArray b = NDArray.fromArray(new float[]{0,1,2,3,4,5}, 6);
        NDArray s2 = b.slice(Slice.of(0, 6, 2));
        emit("slice_step", s2.toString());
        emit("slice_step_shape", Arrays.toString(s2.shape()));

        // ---- Slice.all() ----
        NDArray s3 = a.slice(Slice.of(1, 2), Slice.all());
        emit("slice_all", s3.toString());

        // ---- view shared memory ----
        NDArray orig = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
        NDArray view = orig.slice(Slice.of(0, 1), Slice.all());
        view.set(99.0f, 0, 0);
        emit("slice_view_shared", Float.toString(orig.get(0, 0)));

        // ---- 3D slice ----
        // [[[1,2],[3,4]],[[5,6],[7,8]]] shape [2,2,2]
        NDArray c = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8}, 2, 2, 2);
        NDArray s4 = c.slice(Slice.all(), Slice.of(0, 1), Slice.all());
        emit("slice_3d", s4.toString());
        emit("slice_3d_shape", Arrays.toString(s4.shape()));

        // ---- expandDims ----
        NDArray d = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        emit("expand_dims_0", Arrays.toString(d.expandDims(0).shape()));
        emit("expand_dims_1", Arrays.toString(d.expandDims(1).shape()));
        emit("expand_dims_last", Arrays.toString(d.expandDims(2).shape()));

        // expandDims is a view
        NDArray e0 = NDArray.fromArray(new float[]{10,20}, 2);
        NDArray e1 = e0.expandDims(0);
        e1.set(99.0f, 0, 0);
        emit("expand_dims_view", Float.toString(e0.get(0)));

        // ---- squeeze ----
        NDArray f = NDArray.fromArray(new float[]{1,2,3}, 1, 3, 1);
        NDArray sq1 = f.squeeze(0);
        emit("squeeze_axis", sq1.toString());
        emit("squeeze_axis_shape", Arrays.toString(sq1.shape()));

        NDArray sq2 = f.squeeze();
        emit("squeeze_all", sq2.toString());
        emit("squeeze_all_shape", Arrays.toString(sq2.shape()));

        // ---- errors ----
        try {
            f.squeeze(1);  // axis 1 has size 3
            emit("squeeze_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("squeeze_error", "ERROR");
        }

        try {
            a.slice(Slice.of(0, 2));  // 1 slice for 2D array
            emit("slice_range_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("slice_range_error", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
