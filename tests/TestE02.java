// TestE02.java — E02 Strides & Indexing test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;

public class TestE02 {
    public static void main(String[] args) {
        // --- computeStrides ---
        emit("strides_2d", stridesStr(NDArray.computeStrides(new int[]{2, 3})));
        emit("strides_3d", stridesStr(NDArray.computeStrides(new int[]{3, 4, 5})));
        emit("strides_1d", stridesStr(NDArray.computeStrides(new int[]{5})));

        // --- get: 2D ---
        NDArray a = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        emit("get_2d_00", fmt(a.get(0, 0)));
        emit("get_2d_02", fmt(a.get(0, 2)));
        emit("get_2d_10", fmt(a.get(1, 0)));
        emit("get_2d_12", fmt(a.get(1, 2)));

        // --- get: 3D ---
        float[] data3d = new float[24];
        for (int i = 0; i < 24; i++) data3d[i] = i + 1;
        NDArray b = NDArray.fromArray(data3d, 2, 3, 4);
        emit("get_3d_000", fmt(b.get(0, 0, 0)));
        emit("get_3d_123", fmt(b.get(1, 2, 3)));
        emit("get_3d_012", fmt(b.get(0, 1, 2)));

        // --- set ---
        a.set(99.0f, 1, 1);
        emit("set_get", fmt(a.get(1, 1)));
        emit("set_toString", a.toString());

        // --- isContiguous ---
        NDArray c = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        emit("isContiguous_fresh", String.valueOf(c.isContiguous()));

        // --- error: wrong index count ---
        try {
            a.get(1);
            emit("error_wrong_indices", "NO_EXCEPTION");
        } catch (Exception e) {
            emit("error_wrong_indices", "EXCEPTION");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }

    private static String stridesStr(int[] strides) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strides.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(strides[i]);
        }
        return sb.toString();
    }

    private static String fmt(float v) {
        return Float.toString(v);
    }
}
