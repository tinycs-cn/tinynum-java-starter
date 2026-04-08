// TestE07.java — E07 Broadcasting test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE07 {
    public static void main(String[] args) {
        // --- broadcastShapes ---
        emit("bc_same", Arrays.toString(NDArray.broadcastShapes(new int[]{2, 3}, new int[]{2, 3})));
        emit("bc_right_align", Arrays.toString(NDArray.broadcastShapes(new int[]{2, 3}, new int[]{3})));
        emit("bc_both_expand", Arrays.toString(NDArray.broadcastShapes(new int[]{3, 1}, new int[]{1, 4})));
        emit("bc_3d", Arrays.toString(NDArray.broadcastShapes(new int[]{2, 1, 4}, new int[]{3, 1})));
        emit("bc_scalar_like", Arrays.toString(NDArray.broadcastShapes(new int[]{2, 3}, new int[]{1})));

        try {
            NDArray.broadcastShapes(new int[]{2, 3}, new int[]{4, 3});
            emit("bc_error", "NO_ERROR");
        } catch (Exception e) {
            emit("bc_error", "ERROR");
        }

        // --- broadcastTo ---
        NDArray row = NDArray.fromArray(new float[]{1, 2, 3}, 1, 3);
        NDArray brow = row.broadcastTo(4, 3);
        emit("bt_shape", Arrays.toString(brow.shape()));
        emit("bt_get_0_1", fmt(brow.get(0, 1)));
        emit("bt_get_3_2", fmt(brow.get(3, 2)));
        emit("bt_toString", brow.toString());

        // broadcastTo error: incompatible
        try {
            NDArray.fromArray(new float[]{1, 2, 3}, 3).broadcastTo(4);
            emit("bt_error", "NO_ERROR");
        } catch (Exception e) {
            emit("bt_error", "ERROR");
        }

        // --- auto-broadcast add: matrix + row ---
        NDArray mat = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray bias = NDArray.fromArray(new float[]{10, 20, 30}, 3);
        emit("add_mat_row", mat.add(bias).toString());

        // --- auto-broadcast mul: col * row (outer product) ---
        NDArray col = NDArray.fromArray(new float[]{1, 2, 3}, 3, 1);
        NDArray rowVec = NDArray.fromArray(new float[]{10, 20, 30, 40}, 1, 4);
        emit("mul_outer", col.mul(rowVec).toString());

        // --- auto-broadcast sub: 3D ---
        NDArray a3d = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 1, 3);
        NDArray b1d = NDArray.fromArray(new float[]{10, 20, 30}, 3);
        emit("sub_3d", a3d.sub(b1d).toString());

        // --- auto-broadcast comparison: gt ---
        NDArray vals = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray thresh = NDArray.fromArray(new float[]{2, 3, 4}, 1, 3);
        emit("gt_broadcast", vals.gt(thresh).toString());

        // --- broadcastTo is zero-copy (shares data) ---
        NDArray src = NDArray.fromArray(new float[]{7, 8, 9}, 1, 3);
        NDArray view = src.broadcastTo(3, 3);
        // Mutate via set on the src (which shares data with view)
        src.set(99, 0, 0);
        emit("bt_zerocopy", fmt(view.get(0, 0)));

        // --- broadcast same-shape is identity ---
        NDArray same = NDArray.fromArray(new float[]{1, 2}, 2);
        emit("bt_identity", same.broadcastTo(2).toString());

        // --- scalar-like broadcast [1] to [4] ---
        NDArray scalar = NDArray.fromArray(new float[]{5}, 1);
        NDArray expanded = scalar.broadcastTo(4);
        emit("bt_scalar", expanded.toString());
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }

    private static String fmt(float v) {
        return Float.toString(v);
    }
}
