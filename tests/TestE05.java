// TestE05.java — E05 Unary Math test driver
// Provided by tinynum-starter. Do NOT modify.
// The tester compiles and runs this file to verify your NDArray implementation.

import dev.tensorhero.tinynum.NDArray;

public class TestE05 {
    public static void main(String[] args) {
        // --- neg ---
        NDArray a = NDArray.fromArray(new float[]{1, -2, 3}, 3);
        emit("neg_toString", a.neg().toString());

        // --- abs ---
        emit("abs_toString", a.abs().toString());

        // --- exp of zeros ---
        NDArray z = NDArray.fromArray(new float[]{0, 0, 0, 0, 0, 0}, 2, 3);
        emit("exp_zeros", z.exp().toString());

        // --- log of ones ---
        NDArray ones = NDArray.fromArray(new float[]{1, 1, 1, 1}, 2, 2);
        emit("log_ones", ones.log().toString());

        // --- sqrt ---
        NDArray sq = NDArray.fromArray(new float[]{0, 1, 4, 9}, 4);
        emit("sqrt_toString", sq.sqrt().toString());

        // --- square ---
        NDArray b = NDArray.fromArray(new float[]{-2, 0, 3}, 3);
        emit("square_toString", b.square().toString());

        // --- tanh(0) ---
        NDArray t = NDArray.fromArray(new float[]{0}, 1);
        emit("tanh_zero", fmt(t.tanh().get(0)));

        // --- sin(0) and cos(0) ---
        emit("sin_zero", fmt(t.sin().get(0)));
        emit("cos_zero", fmt(t.cos().get(0)));

        // --- sign ---
        NDArray s = NDArray.fromArray(new float[]{-5, 0, 7}, 3);
        emit("sign_toString", s.sign().toString());

        // --- round ---
        NDArray r = NDArray.fromArray(new float[]{1.4f, 1.6f, -0.5f, 2.3f}, 4);
        emit("round_toString", r.round().toString());

        // --- clip ---
        NDArray c = NDArray.fromArray(new float[]{-3, -1, 0, 1, 3}, 5);
        emit("clip_toString", c.clip(-2, 2).toString());

        // --- pow ---
        NDArray p = NDArray.fromArray(new float[]{1, 4, 9}, 3);
        emit("pow_half", p.pow(0.5f).toString());

        // --- unary preserves shape (returns new array) ---
        NDArray orig = NDArray.fromArray(new float[]{1, 2, 3}, 3);
        NDArray negated = orig.neg();
        emit("unary_independent", fmt(orig.get(0)));

        // --- unary on transposed array ---
        NDArray m = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        emit("unary_transposed", m.transpose().square().toString());
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }

    private static String fmt(float v) {
        return Float.toString(v);
    }
}
