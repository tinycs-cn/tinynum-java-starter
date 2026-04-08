// TestE03.java — E03 Reshape test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;

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
            emit("error_reshape_size", "NO_EXCEPTION");
        } catch (Exception ex) {
            emit("error_reshape_size", "EXCEPTION");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }

    private static String shapeStr(int[] shape) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shape.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(shape[i]);
        }
        return sb.toString();
    }

    private static String fmt(float v) {
        return Float.toString(v);
    }
}
