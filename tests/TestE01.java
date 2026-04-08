// TestE01.java — E01 Storage & Shape test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;

public class TestE01 {
    public static void main(String[] args) {
        // --- zeros ---
        NDArray z = NDArray.zeros(2, 3);
        emit("zeros_size", String.valueOf(z.size()));
        emit("zeros_ndim", String.valueOf(z.ndim()));
        emit("zeros_shape", shapeStr(z.shape()));
        emit("zeros_toString", z.toString());

        // --- ones ---
        NDArray o = NDArray.ones(3, 4);
        emit("ones_size", String.valueOf(o.size()));
        emit("ones_toString", NDArray.ones(2, 3).toString());

        // --- fromArray 2D ---
        NDArray a = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        emit("fromArray_2d_toString", a.toString());

        // --- full ---
        NDArray f = NDArray.full(7.0f, 2, 2);
        emit("full_toString", f.toString());

        // --- zerosLike / onesLike ---
        NDArray base = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
        emit("zerosLike_toString", NDArray.zerosLike(base).toString());
        emit("onesLike_toString", NDArray.onesLike(base).toString());

        // --- 1D ---
        NDArray v = NDArray.fromArray(new float[]{1,2,3}, 3);
        emit("1d_toString", v.toString());

        // --- 3D ---
        NDArray t = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8,9,10,11,12}, 2, 3, 2);
        emit("3d_ndim", String.valueOf(t.ndim()));
        emit("3d_size", String.valueOf(t.size()));
        emit("3d_toString", t.toString());

        // --- error: data/shape mismatch ---
        try {
            NDArray.fromArray(new float[]{1,2,3}, 2, 2);
            emit("error_mismatch", "NO_EXCEPTION");
        } catch (Exception e) {
            emit("error_mismatch", "EXCEPTION");
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
}
