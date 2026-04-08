// TestE04.java — E04 Transpose test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;

public class TestE04 {
    public static void main(String[] args) {
        // --- 2D transpose shape ---
        NDArray a = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray t = a.transpose();
        emit("transpose_2d_shape", shapeStr(t.shape()));

        // --- 2D transpose toString ---
        emit("transpose_2d_toString", t.toString());

        // --- get(i,j) == transpose().get(j,i) ---
        emit("transpose_get_equiv", fmt(t.get(1, 0)));

        // --- 2D transpose zero-copy ---
        NDArray a2 = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray t2 = a2.transpose();
        t2.set(99.0f, 0, 1);
        emit("transpose_zerocopy", fmt(a2.get(1, 0)));

        // --- transposed is not contiguous ---
        NDArray a3 = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        emit("transpose_not_contiguous", String.valueOf(a3.transpose().isContiguous()));

        // --- N-D transpose(axes) shape ---
        NDArray b = NDArray.fromArray(new float[24], 2, 3, 4);
        NDArray bt = b.transpose(2, 0, 1);
        emit("transpose_nd_shape", shapeStr(bt.shape()));

        // --- N-D transpose identity ---
        NDArray c = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray ci = c.transpose(0, 1);
        emit("transpose_identity_toString", ci.toString());

        // --- swapAxes 3D ---
        NDArray d = NDArray.fromArray(new float[24], 2, 3, 4);
        NDArray ds = d.swapAxes(0, 2);
        emit("swapAxes_shape", shapeStr(ds.shape()));

        // --- swapAxes same axis is identity ---
        NDArray e = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray es = e.swapAxes(0, 0);
        emit("swapAxes_same_toString", es.toString());

        // --- error: transpose() on non-2D ---
        try {
            NDArray f = NDArray.fromArray(new float[24], 2, 3, 4);
            f.transpose();
            emit("error_transpose_non2d", "NO_EXCEPTION");
        } catch (Exception ex) {
            emit("error_transpose_non2d", "EXCEPTION");
        }

        // --- error: invalid axes ---
        try {
            NDArray g = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
            g.transpose(0, 0);
            emit("error_invalid_axes", "NO_EXCEPTION");
        } catch (Exception ex) {
            emit("error_invalid_axes", "EXCEPTION");
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
