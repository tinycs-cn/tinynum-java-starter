// TestE03.java — E03 Reshape test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import cn.tinycs.tinynum.NDArray;

public class TestE03 {
    public static void main(String[] args) {
        NDArray a = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);

        // --- reshape basic ---
        NDArray b = a.reshape(3, 2);
        emit("reshape_shape", shapeStr(b.shape()));
        emit("reshape_toString", b.toString());

        // --- reshape -1 ---
        NDArray c = a.reshape(3, -1);
        emit("reshape_neg1_shape", shapeStr(c.shape()));

        // --- reshape -1 in 3D ---
        NDArray d = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8,9,10,11,12}, 2, 6);
        NDArray e = d.reshape(2, -1, 3);
        emit("reshape_neg1_3d_shape", shapeStr(e.shape()));

        // --- reshape zero-copy ---
        NDArray f = a.reshape(6);
        f.set(99.0f, 0);
        emit("reshape_zerocopy", fmt(a.get(0, 0)));

        // --- flatten ---
        NDArray g = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray flat = g.flatten();
        emit("flatten_shape", shapeStr(flat.shape()));
        emit("flatten_toString", flat.toString());

        // --- duplicate ---
        NDArray h = NDArray.fromArray(new float[]{1, 2, 3, 4}, 2, 2);
        NDArray dup = h.duplicate();
        emit("duplicate_toString", dup.toString());
        dup.set(99.0f, 0, 0);
        emit("duplicate_independent", fmt(h.get(0, 0)));

        // --- error: reshape size mismatch ---
        try {
            a.reshape(4, 4);
            emit("error_reshape_size", "NO_ERROR");
        } catch (Exception ex) {
            emit("error_reshape_size", "ERROR");
        }

        // --- error: two -1 dimensions ---
        try {
            a.reshape(-1, -1);
            emit("error_reshape_double_neg1", "NO_ERROR");
        } catch (Exception ex) {
            emit("error_reshape_double_neg1", "ERROR");
        }

        // --- reshape on non-contiguous (transposed) array ---
        // original [[1,2,3],[4,5,6]], transposed = [[1,4],[2,5],[3,6]]
        // flatten of transposed (shape [6]) = [1,4,2,5,3,6]
        NDArray nc = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray ncT = nc.transpose();          // shape [3,2], non-contiguous
        NDArray ncR = ncT.reshape(6);          // must deep-copy then reshape
        emit("reshape_noncontiguous_toString", ncR.toString());
        ncR.set(99.0f, 0);
        emit("reshape_noncontiguous_copy", fmt(nc.get(0, 0)));  // original unchanged
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }

    private static String shapeStr(int[] shape) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < shape.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(shape[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static String fmt(float v) {
        return Float.toString(v);
    }
}
