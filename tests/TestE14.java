import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE14 {
    public static void main(String[] args) {
        // ---- indexSelect axis=0 (row select) ----
        NDArray w = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8,9,10,11,12}, 4, 3);
        NDArray r0 = w.indexSelect(0, new int[]{2, 0, 3});
        emit("index_select_axis0", r0.toString());
        emit("index_select_axis0_shape", Arrays.toString(r0.shape()));

        // ---- indexSelect axis=1 (column select) ----
        NDArray r1 = w.indexSelect(1, new int[]{2, 0});
        emit("index_select_axis1", r1.toString());
        emit("index_select_axis1_shape", Arrays.toString(r1.shape()));

        // ---- indexSelect 1D ----
        NDArray v = NDArray.fromArray(new float[]{10, 20, 30, 40, 50}, 5);
        NDArray r2 = v.indexSelect(0, new int[]{4, 1, 1, 3});
        emit("index_select_1d", r2.toString());

        // ---- indexSelect duplicate indices ----
        NDArray r3 = w.indexSelect(0, new int[]{0, 0, 2});
        emit("index_select_dup", r3.toString());

        // ---- scatterAdd basic ----
        NDArray grad = NDArray.fromArray(new float[]{0,0,0,0,0,0,0,0,0,0,0,0}, 4, 3);
        NDArray src = NDArray.fromArray(new float[]{1,1,1,2,2,2}, 2, 3);
        grad.scatterAdd(0, new int[]{2, 0}, src);
        emit("scatter_add_basic", grad.toString());

        // ---- scatterAdd duplicate indices (accumulation) ----
        NDArray grad2 = NDArray.fromArray(new float[]{0,0,0,0,0,0}, 2, 3);
        NDArray src2 = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8,9}, 3, 3);
        grad2.scatterAdd(0, new int[]{0, 1, 0}, src2);
        emit("scatter_add_dup", grad2.toString());

        // ---- maskedFill 2D ----
        NDArray scores = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        NDArray mask = NDArray.fromArray(new float[]{0,0,1,1,0,0}, 2, 3);
        NDArray filled = scores.maskedFill(mask, -999.0f);
        emit("masked_fill_2d", filled.toString());

        // ---- maskedFill 1D ----
        NDArray v2 = NDArray.fromArray(new float[]{10, 20, 30}, 3);
        NDArray m2 = NDArray.fromArray(new float[]{1, 0, 1}, 3);
        emit("masked_fill_1d", v2.maskedFill(m2, 0).toString());

        // ---- maskedFill no change (all zeros mask) ----
        NDArray m3 = NDArray.fromArray(new float[]{0, 0, 0}, 3);
        emit("masked_fill_none", v2.maskedFill(m3, -99).toString());

        // ---- where 2D ----
        NDArray cond = NDArray.fromArray(new float[]{1,0,0,1}, 2, 2);
        NDArray x = NDArray.fromArray(new float[]{10,20,30,40}, 2, 2);
        NDArray y = NDArray.fromArray(new float[]{-1,-2,-3,-4}, 2, 2);
        emit("where_2d", NDArray.where(cond, x, y).toString());

        // ---- where 1D ----
        NDArray c1 = NDArray.fromArray(new float[]{0, 1, 0, 1, 1}, 5);
        NDArray x1 = NDArray.fromArray(new float[]{1, 2, 3, 4, 5}, 5);
        NDArray y1 = NDArray.fromArray(new float[]{-1, -2, -3, -4, -5}, 5);
        emit("where_1d", NDArray.where(c1, x1, y1).toString());

        // ---- error: maskedFill shape mismatch ----
        try {
            NDArray a = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
            NDArray badMask = NDArray.fromArray(new float[]{1,2,3}, 3);
            a.maskedFill(badMask, 0);
            emit("masked_fill_shape_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("masked_fill_shape_error", "ERROR");
        }

        // ---- error: where shape mismatch ----
        try {
            NDArray a = NDArray.fromArray(new float[]{1,0}, 2);
            NDArray b = NDArray.fromArray(new float[]{1,2,3}, 3);
            NDArray c = NDArray.fromArray(new float[]{4,5,6}, 3);
            NDArray.where(a, b, c);
            emit("where_shape_error", "NO_ERROR");
        } catch (Exception ex) {
            emit("where_shape_error", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
