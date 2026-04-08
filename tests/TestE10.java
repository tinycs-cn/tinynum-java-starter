import dev.tensorhero.tinynum.NDArray;
import java.util.Arrays;

public class TestE10 {
    public static void main(String[] args) {
        // ---- dot ----
        NDArray a = NDArray.fromArray(new float[]{1,2,3}, 3);
        NDArray b = NDArray.fromArray(new float[]{4,5,6}, 3);
        NDArray dotResult = a.dot(b);
        emit("dot_1d", Float.toString(dotResult.get()));
        emit("dot_shape", Arrays.toString(dotResult.shape()));

        // ---- matmul 2D ----
        NDArray A = NDArray.fromArray(new float[]{1,2,3,4}, 2, 2);
        NDArray B = NDArray.fromArray(new float[]{5,6,7,8}, 2, 2);
        emit("matmul_2d", A.matMul(B).toString());
        emit("matmul_2d_shape", Arrays.toString(A.matMul(B).shape()));

        // ---- matmul rectangular ----
        NDArray C = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 2, 3);
        NDArray D = NDArray.fromArray(new float[]{1,2,3,4,5,6}, 3, 2);
        NDArray rectResult = C.matMul(D);
        emit("matmul_rect", rectResult.toString());
        emit("matmul_rect_shape", Arrays.toString(rectResult.shape()));

        // ---- matmul identity ----
        // Manual 3x3 identity
        NDArray eye = NDArray.fromArray(new float[]{1,0,0,0,1,0,0,0,1}, 3, 3);
        NDArray X = NDArray.fromArray(new float[]{2,3,4,5,6,7,8,9,10}, 3, 3);
        emit("matmul_identity", eye.matMul(X).toString());

        // ---- batch matmul ----
        // [2,2,3] @ [2,3,2]
        NDArray bA = NDArray.fromArray(new float[]{1,2,3,4,5,6,7,8,9,10,11,12}, 2, 2, 3);
        NDArray bB = NDArray.fromArray(new float[]{1,0,0,1,1,0,0,1,1,0,0,1}, 2, 3, 2);
        NDArray batchResult = bA.matMul(bB);
        emit("matmul_batch", batchResult.toString());
        emit("matmul_batch_shape", Arrays.toString(batchResult.shape()));

        // ---- batch broadcast: [2,2,3] @ [1,3,2] -> [2,2,2] ----
        NDArray bC = NDArray.fromArray(new float[]{1,0,0,1,1,0}, 1, 3, 2);
        NDArray broadcastResult = bA.matMul(bC);
        emit("matmul_batch_broadcast", broadcastResult.toString());
        emit("matmul_batch_broadcast_shape", Arrays.toString(broadcastResult.shape()));

        // ---- errors ----
        try {
            NDArray.fromArray(new float[]{1,2,3}, 3).dot(NDArray.fromArray(new float[]{1,2}, 2));
            emit("dot_length_error", "NO_ERROR");
        } catch (Exception e) {
            emit("dot_length_error", "ERROR");
        }

        try {
            NDArray.fromArray(new float[]{1,2,3,4}, 2, 2).matMul(NDArray.fromArray(new float[]{1,2,3,4,5,6}, 3, 2));
            emit("matmul_dim_error", "NO_ERROR");
        } catch (Exception e) {
            emit("matmul_dim_error", "ERROR");
        }

        try {
            NDArray.fromArray(new float[]{1,2,3,4}, 2, 2).dot(NDArray.fromArray(new float[]{1,2}, 2));
            emit("dot_not_1d_error", "NO_ERROR");
        } catch (Exception e) {
            emit("dot_not_1d_error", "ERROR");
        }
    }

    private static void emit(String testName, String result) {
        System.out.println("TEST:" + testName);
        System.out.println("RESULT:" + result);
    }
}
