import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE12 {
    public static void main(String[] args) {
        // ---- arange ----
        NDArray a1 = NDArray.arange(0, 5, 1);
        emit("arange_basic", a1.toString());
        emit("arange_basic_shape", Arrays.toString(a1.shape()));

        NDArray a2 = NDArray.arange(1, 2, 0.3f);
        emit("arange_float_len", Integer.toString(a2.shape()[0]));

        // ---- linspace ----
        NDArray l1 = NDArray.linspace(0, 1, 5);
        emit("linspace_basic", l1.toString());
        emit("linspace_basic_shape", Arrays.toString(l1.shape()));

        NDArray l2 = NDArray.linspace(0, 10, 3);
        emit("linspace_three", l2.toString());

        NDArray l3 = NDArray.linspace(5, 5, 1);
        emit("linspace_single", l3.toString());

        // ---- eye ----
        NDArray e1 = NDArray.eye(3);
        emit("eye_3", e1.toString());
        emit("eye_3_shape", Arrays.toString(e1.shape()));

        NDArray e2 = NDArray.eye(1);
        emit("eye_1", e2.toString());

        // ---- diag ----
        NDArray v = NDArray.fromArray(new float[]{3, 5, 7}, 3);
        NDArray d1 = NDArray.diag(v);
        emit("diag_basic", d1.toString());
        emit("diag_basic_shape", Arrays.toString(d1.shape()));

        // ---- randn ----
        NDArray rn = NDArray.randn(2, 3);
        emit("randn_shape", Arrays.toString(rn.shape()));
        // statistical: mean of large randn should be near 0
        NDArray rn_large = NDArray.randn(10000);
        float rn_mean = rn_large.mean();
        emit("randn_mean_near_zero", (Math.abs(rn_mean) < 0.1f) ? "true" : "false");

        // ---- rand ----
        NDArray rd = NDArray.rand(3, 4);
        emit("rand_shape", Arrays.toString(rd.shape()));
        // check all values in [0, 1)
        boolean randInRange = true;
        NDArray rd_flat = NDArray.rand(1000);
        for (int i = 0; i < 1000; i++) {
            float val = rd_flat.get(i);
            if (val < 0 || val >= 1) { randInRange = false; break; }
        }
        emit("rand_in_range", Boolean.toString(randInRange));

        // ---- uniform ----
        NDArray u = NDArray.uniform(-2, 3, 2, 5);
        emit("uniform_shape", Arrays.toString(u.shape()));
        boolean uniformInRange = true;
        NDArray u_flat = NDArray.uniform(-2, 3, 1000);
        for (int i = 0; i < 1000; i++) {
            float val = u_flat.get(i);
            if (val < -2 || val >= 3) { uniformInRange = false; break; }
        }
        emit("uniform_in_range", Boolean.toString(uniformInRange));

        // ---- shuffle ----
        int[] idx = {0, 1, 2, 3, 4};
        NDArray.shuffle(idx);
        emit("shuffle_length", Integer.toString(idx.length));
        // check all elements preserved (sort and compare)
        int[] sorted = idx.clone();
        Arrays.sort(sorted);
        emit("shuffle_elements_preserved", Arrays.equals(sorted, new int[]{0,1,2,3,4}) ? "true" : "false");

        // ---- fill ----
        NDArray f = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6}, 2, 3);
        f.fill(0);
        emit("fill_zeros", f.toString());

        NDArray f2 = NDArray.fromArray(new float[]{1, 2, 3, 4}, 2, 2);
        f2.fill(7);
        emit("fill_value", f2.toString());

        // ---- eye identity property: eye(3) * x == x ----
        NDArray x = NDArray.fromArray(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 3);
        NDArray identity = NDArray.eye(3);
        NDArray product = identity.matMul(x);
        emit("eye_identity_property", product.toString());

        // ---- error: diag with non-1D ----
        try {
            NDArray.diag(NDArray.fromArray(new float[]{1,2,3,4}, 2, 2));
            emit("diag_error_non1d", "NO_ERROR");
        } catch (Exception ex) {
            emit("diag_error_non1d", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
