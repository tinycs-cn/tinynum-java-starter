import dev.tensorhero.tinynum.NDArray;
import dev.tensorhero.tinynum.DType;
import java.util.Arrays;

public class TestE15 {
    public static void main(String[] args) {
        // ---- tril default diagonal ----
        NDArray t0 = NDArray.tril(3, 0);
        emit("tril_default", t0.toString());

        // ---- tril with diagonal=1 ----
        NDArray t1 = NDArray.tril(3, 1);
        emit("tril_diag1", t1.toString());

        // ---- triu default diagonal ----
        NDArray u0 = NDArray.triu(3, 0);
        emit("triu_default", u0.toString());

        // ---- triu with diagonal=-1 ----
        NDArray u1 = NDArray.triu(3, -1);
        emit("triu_diag_neg1", u1.toString());

        // ---- norm axis=1 (row-wise) ----
        NDArray n1 = NDArray.fromArray(new float[]{3,4,6,8}, 2, 2);
        emit("norm_axis1", n1.norm(1).toString());

        // ---- norm axis=0 (col-wise) ----
        NDArray n1b = NDArray.fromArray(new float[]{3,5,4,12}, 2, 2);
        emit("norm_axis0", n1b.norm(0).toString());

        // ---- diff axis=0 on 1D ----
        NDArray d1 = NDArray.fromArray(new float[]{1,3,6,10}, 4);
        emit("diff_1d", d1.diff(0).toString());

        // ---- diff axis=1 on 2D ----
        NDArray d2 = NDArray.fromArray(new float[]{1,3,6,10,2,5,9,14}, 2, 4);
        emit("diff_axis1", d2.diff(1).toString());
        emit("diff_axis1_shape", Arrays.toString(d2.diff(1).shape()));

        // ---- diff axis=0 on 2D ----
        emit("diff_axis0", d2.diff(0).toString());

        // ---- percentile 50 ----
        NDArray p1 = NDArray.fromArray(new float[]{1,2,3,4,5}, 5);
        emit("percentile_50", p1.percentile(50).toString());

        // ---- percentile 0 and 100 ----
        emit("percentile_0", p1.percentile(0).toString());
        emit("percentile_100", p1.percentile(100).toString());

        // ---- percentile 25 ----
        emit("percentile_25", p1.percentile(25).toString());

        // ---- argsort 1D ----
        NDArray a1 = NDArray.fromArray(new float[]{30, 10, 20}, 3);
        emit("argsort_1d", a1.argsort(0).toString());

        // ---- argsort 2D axis=1 ----
        NDArray a2 = NDArray.fromArray(new float[]{30,10,20,5,15,1}, 2, 3);
        emit("argsort_2d_axis1", a2.argsort(1).toString());

        // ---- unique ----
        NDArray uq = NDArray.fromArray(new float[]{3,1,2,1,3,2}, 6);
        emit("unique", uq.unique().toString());
        emit("unique_shape", Arrays.toString(uq.unique().shape()));

        // ---- allClose true ----
        NDArray ac1 = NDArray.fromArray(new float[]{1.0f, 2.0f, 3.0f}, 3);
        NDArray ac2 = NDArray.fromArray(new float[]{1.0001f, 2.0001f, 3.0001f}, 3);
        emit("allclose_true", String.valueOf(ac1.allClose(ac2, 0.001f)));

        // ---- allClose false ----
        NDArray ac3 = NDArray.fromArray(new float[]{1.0f, 2.0f, 3.0f}, 3);
        NDArray ac4 = NDArray.fromArray(new float[]{1.0f, 2.5f, 3.0f}, 3);
        emit("allclose_false", String.valueOf(ac3.allClose(ac4, 0.001f)));

        // ---- allClose shape mismatch ----
        NDArray ac5 = NDArray.fromArray(new float[]{1.0f, 2.0f}, 2);
        emit("allclose_shape_diff", String.valueOf(ac1.allClose(ac5, 0.001f)));

        // ---- astype float32 -> int8 ----
        NDArray at1 = NDArray.fromArray(new float[]{150.5f, -200.3f, 50.0f, 0.7f}, 4);
        emit("astype_int8", at1.astype(DType.INT8).toString());

        // ---- astype int8 -> float32 (identity on already-int-valued) ----
        NDArray at2 = NDArray.fromArray(new float[]{127, -128, 50}, 3);
        emit("astype_float32", at2.astype(DType.FLOAT32).toString());

        // ---- softmax integration test ----
        // softmax(x, axis=1) = exp(x - max(x, axis=1, keepDims=true)) / sum(exp(...), axis=1, keepDims=true)
        NDArray x = NDArray.fromArray(new float[]{1,2,3,1,2,3}, 2, 3);
        NDArray maxVal = x.max(1, true);
        NDArray shifted = x.sub(maxVal);
        NDArray expVal = shifted.exp();
        NDArray sumExp = expVal.sum(1, true);
        NDArray softmax = expVal.div(sumExp);

        // Check row sums ≈ 1.0
        NDArray rowSums = softmax.sum(1, false);
        NDArray expectedOnes = NDArray.fromArray(new float[]{1.0f, 1.0f}, 2);
        emit("softmax_row_sum", String.valueOf(rowSums.allClose(expectedOnes, 0.0001f)));

        // Check softmax values are reasonable (max element has largest prob)
        // For [1,2,3]: softmax[2] > softmax[1] > softmax[0]
        float s0 = softmax.get(0, 0);
        float s1 = softmax.get(0, 1);
        float s2 = softmax.get(0, 2);
        emit("softmax_order", String.valueOf(s2 > s1 && s1 > s0));
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
