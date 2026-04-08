package dev.tensorhero.tinynum;

/**
 * N-dimensional array — the core data structure of tinynum.
 *
 * <p>Internally stores data in a flat {@code float[]} with shape and strides
 * metadata, enabling zero-copy views for reshape, transpose, and slice.</p>
 */
public class NDArray {

    // Shared RNG — call manualSeed() for reproducible results.
    private static java.util.Random globalRng = new java.util.Random();

    /** Seed the global RNG for reproducible random operations. */
    public static void manualSeed(long seed) { globalRng = new java.util.Random(seed); }

    float[] data;       // flat storage
    int[] shape;        // e.g. [2, 3, 4]
    int[] strides;      // e.g. [12, 4, 1] (row-major)
    int offset;         // for views/slices

    // ================================================================
    // E01 — Storage & Shape
    // ================================================================

    /**
     * Creates an NDArray from a flat data array with the given shape.
     *
     * @param data the flat data array
     * @param shape the desired shape (e.g. 2, 3 for a 2×3 matrix)
     * @return a new NDArray
     * @throws IllegalArgumentException if data.length != product of shape
     */
    public static NDArray fromArray(float[] data, int... shape) {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Creates a zero-filled NDArray with the given shape. */
    public static NDArray zeros(int... shape) {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Creates a one-filled NDArray with the given shape. */
    public static NDArray ones(int... shape) {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Creates an NDArray filled with {@code value}. */
    public static NDArray full(float value, int... shape) {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Creates a zero-filled NDArray with the same shape as {@code other}. */
    public static NDArray zerosLike(NDArray other) {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Creates a one-filled NDArray with the same shape as {@code other}. */
    public static NDArray onesLike(NDArray other) {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Returns the total number of elements. */
    public int size() {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Returns the number of dimensions. */
    public int ndim() {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Returns a copy of the shape array. */
    public int[] shape() {
        throw new UnsupportedOperationException("TODO: E01");
    }

    /** Pretty-prints the NDArray: e.g. {@code [[1.0, 2.0], [3.0, 4.0]]}. */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO: E01");
    }

    // ================================================================
    // E02 — Strides & Indexing
    // ================================================================

    /**
     * Computes row-major strides for the given shape.
     * <p>Example: shape [3, 4, 5] → strides [20, 5, 1]</p>
     */
    public static int[] computeStrides(int[] shape) {
        throw new UnsupportedOperationException("TODO: E02");
    }

    /**
     * Gets the element at the given multi-dimensional indices.
     * <p>Uses: {@code physicalIndex = offset + Σ(index[i] × stride[i])}</p>
     */
    public float get(int... indices) {
        throw new UnsupportedOperationException("TODO: E02");
    }

    /** Sets the element at the given multi-dimensional indices. */
    public void set(float value, int... indices) {
        throw new UnsupportedOperationException("TODO: E02");
    }

    /** Returns true if strides form a standard row-major contiguous layout. */
    public boolean isContiguous() {
        throw new UnsupportedOperationException("TODO: E02");
    }

    // ================================================================
    // E03 — Reshape
    // ================================================================

    /**
     * Returns a view with a new shape (zero-copy when contiguous).
     * Supports -1 for one dimension to auto-infer its size.
     */
    public NDArray reshape(int... newShape) {
        throw new UnsupportedOperationException("TODO: E03");
    }

    /** Flattens to a 1-D array. Equivalent to {@code reshape(-1)}. */
    public NDArray flatten() {
        throw new UnsupportedOperationException("TODO: E03");
    }

    /** Returns a deep copy (always contiguous). */
    public NDArray duplicate() {
        throw new UnsupportedOperationException("TODO: E03");
    }

    // ================================================================
    // E04 — Transpose
    // ================================================================

    /** 2-D transpose: swaps axis 0 and axis 1 (zero-copy). */
    public NDArray transpose() {
        throw new UnsupportedOperationException("TODO: E04");
    }

    /** N-D transpose: rearranges axes according to the given permutation (zero-copy). */
    public NDArray transpose(int... axes) {
        throw new UnsupportedOperationException("TODO: E04");
    }

    /** Swaps two axes (zero-copy). */
    public NDArray swapAxes(int axis1, int axis2) {
        throw new UnsupportedOperationException("TODO: E04");
    }

    // ================================================================
    // E05 — Unary Math
    // ================================================================

    /** Returns {@code -x} element-wise. */
    public NDArray neg() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code |x|} element-wise. */
    public NDArray abs() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code e^x} element-wise. */
    public NDArray exp() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code ln(x)} element-wise. */
    public NDArray log() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code √x} element-wise. */
    public NDArray sqrt() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code x²} element-wise. */
    public NDArray square() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code tanh(x)} element-wise. */
    public NDArray tanh() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code sin(x)} element-wise. */
    public NDArray sin() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code cos(x)} element-wise. */
    public NDArray cos() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code sgn(x)} element-wise. */
    public NDArray sign() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns rounded values element-wise. */
    public NDArray round() {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Clips values to {@code [min, max]} element-wise. */
    public NDArray clip(float min, float max) {
        throw new UnsupportedOperationException("TODO: E05");
    }

    /** Returns {@code x^p} element-wise. */
    public NDArray pow(float p) {
        throw new UnsupportedOperationException("TODO: E05");
    }

    // ================================================================
    // E06 — Binary Ops & Comparisons (same shape)
    // ================================================================

    // --- Arithmetic (NDArray) ---

    /** Element-wise addition. */
    public NDArray add(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise subtraction. */
    public NDArray sub(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise multiplication. */
    public NDArray mul(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise division. */
    public NDArray div(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise power: {@code x^y}. */
    public NDArray pow(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise maximum: {@code max(x, y)}. */
    public NDArray maximum(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    // --- Arithmetic (scalar) ---

    /** Adds a scalar to every element. */
    public NDArray add(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Subtracts a scalar from every element. */
    public NDArray sub(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Multiplies every element by a scalar. */
    public NDArray mul(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Divides every element by a scalar. */
    public NDArray div(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    // --- Comparisons (NDArray) — returns 1.0f / 0.0f ---

    /** Element-wise equal: returns 1.0 where {@code x == y}. */
    public NDArray eq(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise not-equal: returns 1.0 where {@code x != y}. */
    public NDArray neq(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise greater-than: returns 1.0 where {@code x > y}. */
    public NDArray gt(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise greater-than-or-equal: returns 1.0 where {@code x >= y}. */
    public NDArray gte(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise less-than: returns 1.0 where {@code x < y}. */
    public NDArray lt(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    /** Element-wise less-than-or-equal: returns 1.0 where {@code x <= y}. */
    public NDArray lte(NDArray other) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    // --- Comparisons (scalar) ---

    public NDArray eq(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    public NDArray neq(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    public NDArray gt(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    public NDArray gte(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    public NDArray lt(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    public NDArray lte(float scalar) {
        throw new UnsupportedOperationException("TODO: E06");
    }

    // ================================================================
    // E07 — Broadcasting
    // ================================================================

    /**
     * Computes the broadcast-compatible output shape for two input shapes.
     * <p>Example: [3, 1] + [1, 4] → [3, 4]</p>
     *
     * @throws IllegalArgumentException if shapes are not broadcast-compatible
     */
    public static int[] broadcastShapes(int[] shapeA, int[] shapeB) {
        throw new UnsupportedOperationException("TODO: E07");
    }

    /**
     * Returns a view broadcast to the target shape (zero-copy, stride=0 trick).
     */
    public NDArray broadcastTo(int... targetShape) {
        throw new UnsupportedOperationException("TODO: E07");
    }

    // ================================================================
    // E08 — Reduction: Sum & Mean
    // ================================================================

    /** Returns the sum of all elements. */
    public float sum() {
        throw new UnsupportedOperationException("TODO: E08");
    }

    /** Returns the mean of all elements. */
    public float mean() {
        throw new UnsupportedOperationException("TODO: E08");
    }

    /** Sum along a single axis. */
    public NDArray sum(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E08");
    }

    /** Mean along a single axis. */
    public NDArray mean(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E08");
    }

    /** Sum along multiple axes. */
    public NDArray sum(int[] axes, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E08");
    }

    // ================================================================
    // E09 — Reduction: Max, Var & friends
    // ================================================================

    /** Max along an axis. */
    public NDArray max(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Min along an axis. */
    public NDArray min(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Index of the maximum value along an axis. */
    public NDArray argmax(int axis) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Index of the minimum value along an axis. */
    public NDArray argmin(int axis) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Product of elements along an axis. */
    public NDArray prod(int axis) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Variance along an axis. */
    public NDArray var(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Standard deviation along an axis. */
    public NDArray std(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: E09");
    }

    /** Counts non-zero elements. */
    public int countNonZero() {
        throw new UnsupportedOperationException("TODO: E09");
    }

    // ================================================================
    // E10 — MatMul
    // ================================================================

    /** Vector dot product (1-D · 1-D → scalar wrapped in 0-D array). */
    public NDArray dot(NDArray other) {
        throw new UnsupportedOperationException("TODO: E10");
    }

    /**
     * Matrix multiplication.
     * <ul>
     *   <li>2-D × 2-D: (M,K) × (K,N) → (M,N)</li>
     *   <li>Batched: (...,M,K) × (...,K,N) → (...,M,N)</li>
     * </ul>
     */
    public NDArray matMul(NDArray other) {
        throw new UnsupportedOperationException("TODO: E10");
    }

    // ================================================================
    // E11 — Slicing & Views
    // ================================================================

    /**
     * Returns a view into a sub-region of this array (zero-copy).
     *
     * @param ranges one {@link Slice} per axis
     */
    public NDArray slice(Slice... ranges) {
        throw new UnsupportedOperationException("TODO: E11");
    }

    /** Adds a dimension of size 1 at the given axis. */
    public NDArray expandDims(int axis) {
        throw new UnsupportedOperationException("TODO: E11");
    }

    /** Removes a dimension of size 1 at the given axis. */
    public NDArray squeeze(int axis) {
        throw new UnsupportedOperationException("TODO: E11");
    }

    /** Removes all dimensions of size 1. */
    public NDArray squeeze() {
        throw new UnsupportedOperationException("TODO: E11");
    }

    // ================================================================
    // E12 — Creation & Random
    // ================================================================

    /** Creates a 1-D array: [start, start+step, ..., end). */
    public static NDArray arange(float start, float end, float step) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Creates a 1-D array of {@code num} evenly spaced values in [start, end]. */
    public static NDArray linspace(float start, float end, int num) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Creates an n×n identity matrix. */
    public static NDArray eye(int n) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Creates a diagonal matrix from a 1-D vector. */
    public static NDArray diag(NDArray vector) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Creates an NDArray with standard normal random values N(0,1). */
    public static NDArray randn(int... shape) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Creates an NDArray with uniform random values in [0, 1). */
    public static NDArray rand(int... shape) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Creates an NDArray with uniform random values in [lo, hi). */
    public static NDArray uniform(float lo, float hi, int... shape) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Shuffles an index array in-place (Fisher-Yates). */
    public static void shuffle(int[] indices) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    /** Fills all elements with the given value (in-place). */
    public void fill(float value) {
        throw new UnsupportedOperationException("TODO: E12");
    }

    // ================================================================
    // E13 — Join & Transform
    // ================================================================

    /** Concatenates arrays along an existing axis. */
    public static NDArray concatenate(NDArray[] arrays, int axis) {
        throw new UnsupportedOperationException("TODO: E13");
    }

    /** Stacks arrays along a new axis. */
    public static NDArray stack(NDArray[] arrays, int axis) {
        throw new UnsupportedOperationException("TODO: E13");
    }

    /**
     * Pads this array.
     *
     * @param padWidth {@code padWidth[i] = {before, after}} for axis i
     * @param value    the fill value for padded regions
     */
    public NDArray pad(int[][] padWidth, float value) {
        throw new UnsupportedOperationException("TODO: E13");
    }

    /** Reverses elements along the given axis. */
    public NDArray flip(int axis) {
        throw new UnsupportedOperationException("TODO: E13");
    }

    // ================================================================
    // E14 — Fancy Indexing
    // ================================================================

    /**
     * Selects rows/columns by index (embedding lookup).
     * <p>Example: {@code weight.indexSelect(0, new int[]{3, 0, 3, 7})}</p>
     */
    public NDArray indexSelect(int axis, int[] indices) {
        throw new UnsupportedOperationException("TODO: E14");
    }

    /**
     * Scatter-adds {@code src} into this array (embedding backward).
     * <p>Equivalent to NumPy's {@code np.add.at(self, indices, src)}.</p>
     */
    public void scatterAdd(int axis, int[] indices, NDArray src) {
        throw new UnsupportedOperationException("TODO: E14");
    }

    /**
     * Returns a new array where positions with {@code mask == 1.0} are
     * replaced by {@code value}.
     */
    public NDArray maskedFill(NDArray mask, float value) {
        throw new UnsupportedOperationException("TODO: E14");
    }

    /**
     * Element-wise conditional: picks from {@code x} where condition is
     * non-zero, else from {@code y}.
     */
    public static NDArray where(NDArray condition, NDArray x, NDArray y) {
        throw new UnsupportedOperationException("TODO: E14");
    }

    // ================================================================
    // E15 — Capstone: Toolkit
    // ================================================================

    /** Lower-triangular matrix of size n (for causal masks). */
    public static NDArray tril(int n, int diagonal) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** Upper-triangular matrix of size n. */
    public static NDArray triu(int n, int diagonal) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** L2 norm along an axis. */
    public NDArray norm(int axis) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** Differences between consecutive elements along an axis. */
    public NDArray diff(int axis) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** Computes the q-th percentile across all elements. */
    public NDArray percentile(float q) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** Returns the indices that would sort along the given axis. */
    public NDArray argsort(int axis) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** Returns sorted unique elements. */
    public NDArray unique() {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /**
     * Returns true if all elements are within {@code atol} of the
     * corresponding elements in {@code other}.
     */
    public boolean allClose(NDArray other, float atol) {
        throw new UnsupportedOperationException("TODO: E15");
    }

    /** Converts element type: float32 ↔ int8. */
    public NDArray astype(DType dtype) {
        throw new UnsupportedOperationException("TODO: E15");
    }
}
