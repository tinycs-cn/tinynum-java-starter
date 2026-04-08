// TestE06.java — E06 Binary Ops & Comparisons test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;

public class TestE06 {
    public static void main(String[] args) {
        NDArray a = NDArray.fromArray(new float[]{2, 4, 6, 8, 10, 12}, 2, 3);
        NDArray b = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);

        // --- Arithmetic (NDArray) ---
        emit("add_toString", a.add(b).toString());
        emit("sub_toString", a.sub(b).toString());
        emit("mul_toString", a.mul(b).toString());
        emit("div_toString", a.div(b).toString());

        NDArray p1 = NDArray.fromArray(new float[]{2, 3, 4}, 3);
        NDArray p2 = NDArray.fromArray(new float[]{3, 2, 0}, 3);
        emit("pow_toString", p1.pow(p2).toString());

        NDArray m1 = NDArray.fromArray(new float[]{1, 5, 3}, 3);
        NDArray m2 = NDArray.fromArray(new float[]{4, 2, 3}, 3);
        emit("maximum_toString", m1.maximum(m2).toString());

        // --- Arithmetic (scalar) ---
        NDArray c = NDArray.fromArray(new float[]{10, 20, 30}, 3);
        emit("add_scalar", c.add(5).toString());
        emit("sub_scalar", c.sub(5).toString());
        emit("mul_scalar", c.mul(2).toString());
        emit("div_scalar", c.div(10).toString());

        // --- Comparisons (NDArray) ---
        NDArray x = NDArray.fromArray(new float[]{1, 2, 3, 4}, 4);
        NDArray y = NDArray.fromArray(new float[]{1, 3, 2, 4}, 4);
        emit("eq_toString", x.eq(y).toString());
        emit("neq_toString", x.neq(y).toString());
        emit("gt_toString", x.gt(y).toString());
        emit("gte_toString", x.gte(y).toString());
        emit("lt_toString", x.lt(y).toString());
        emit("lte_toString", x.lte(y).toString());

        // --- Comparisons (scalar) ---
        NDArray s = NDArray.fromArray(new float[]{1, 2, 3, 4, 5}, 5);
        emit("eq_scalar", s.eq(3).toString());
        emit("neq_scalar", s.neq(3).toString());
        emit("gt_scalar", s.gt(3).toString());
        emit("gte_scalar", s.gte(3).toString());
        emit("lt_scalar", s.lt(3).toString());
        emit("lte_scalar", s.lte(3).toString());

        // --- Binary returns new array (originals unchanged) ---
        NDArray orig1 = NDArray.fromArray(new float[]{1, 2, 3}, 3);
        NDArray orig2 = NDArray.fromArray(new float[]{4, 5, 6}, 3);
        NDArray sum = orig1.add(orig2);
        emit("binary_independent", fmt(orig1.get(0)));

        // --- Binary on transposed arrays ---
        NDArray t1 = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        NDArray t2 = NDArray.fromArray(new float[]{10, 20, 30, 40, 50, 60}, 3, 2);
        emit("binary_transposed", t1.transpose().add(t2).toString());

        // --- Shape mismatch ---
        try {
            NDArray.fromArray(new float[]{1, 2, 3}, 3)
                .add(NDArray.fromArray(new float[]{1, 2}, 2));
            emit("shape_mismatch", "NO_ERROR");
        } catch (Exception e) {
            emit("shape_mismatch", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }

    private static String fmt(float v) {
        return Float.toString(v);
    }
}
