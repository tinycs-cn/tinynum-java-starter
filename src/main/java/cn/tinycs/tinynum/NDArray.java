gengpackage cn.tinycs.tinynum;

/**
 * N 维数组 —— tinynum 的核心数据结构。
 *
 * <p>内部使用连续的 {@code float[]} 存储数据，配合 shape 和 strides 元数据，
 * 支持 reshape、transpose、slice 的零拷贝视图。</p>
 *
 * <p><b>关于 AI 辅助编程：</b>欢迎用 AI 工具理解概念、解释报错、探索思路；
 * 但建议先独立思考再求助——直接让 AI 生成完整实现会让你错过真正的收获。</p>
 */
public class NDArray {

    // 全局随机数生成器，调用 manualSeed() 可固定随机种子。
    private static java.util.Random globalRng = new java.util.Random();

    /** 设置全局随机种子，确保随机操作可复现。 */
    public static void manualSeed(long seed) { globalRng = new java.util.Random(seed); }

    float[] data;       // 一维连续存储           [S01]
    int[] shape;        // 各维大小，如 [2, 3, 4]  [S01]
    int[] strides;      // 各维步长，如 [12, 4, 1] [S02]
    int offset;         // 视图/切片起始偏移        [S11]

    // ================================================================
    // S01 — 存储与形状
    // ================================================================

    /**
     * 从一维数据数组和指定 shape 创建 NDArray。
     *
     * <p>S01 只需初始化 {@code data} 和 {@code shape}；
     * {@code strides} 在 S02 中初始化，{@code offset} 默认为 0。</p>
     *
     * @param data  一维数据数组
     * @param shape 目标形状（如 2, 3 表示 2×3 矩阵）
     * @return 新的 NDArray
     * @throws IllegalArgumentException 若 data.length 不等于 shape 各维之积
     */
    public static NDArray fromArray(float[] data, int... shape) {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 创建全零 NDArray。 */
    public static NDArray zeros(int... shape) {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 创建全一 NDArray。 */
    public static NDArray ones(int... shape) {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 创建以 {@code value} 填充的 NDArray。 */
    public static NDArray full(float value, int... shape) {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 创建与 {@code other} 同形的全零 NDArray。 */
    public static NDArray zerosLike(NDArray other) {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 创建与 {@code other} 同形的全一 NDArray。 */
    public static NDArray onesLike(NDArray other) {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 返回元素总数。 */
    public int size() {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 返回维度数。 */
    public int ndim() {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 返回 shape 数组的副本。 */
    public int[] shape() {
        throw new UnsupportedOperationException("TODO: S01");
    }

    /** 格式化打印，如 {@code [[1.0, 2.0], [3.0, 4.0]]}。 */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO: S01");
    }

    // ================================================================
    // S02 — 步长与索引
    // ================================================================

    /**
     * 计算行优先步长。
     * <p>示例：shape [3, 4, 5] → strides [20, 5, 1]</p>
     */
    public static int[] computeStrides(int[] shape) {
        throw new UnsupportedOperationException("TODO: S02");
    }

    /**
     * 按多维索引取值。
     * <p>物理索引 = offset + Σ(index[i] × stride[i])</p>
     */
    public float get(int... indices) {
        throw new UnsupportedOperationException("TODO: S02");
    }

    /** 按多维索引赋值。 */
    public void set(float value, int... indices) {
        throw new UnsupportedOperationException("TODO: S02");
    }

    /** 判断是否为标准行优先连续布局。 */
    public boolean isContiguous() {
        throw new UnsupportedOperationException("TODO: S02");
    }

    // ================================================================
    // S03 — 变形
    // ================================================================

    /**
     * 返回指定形状的视图（连续时零拷贝）。
     * 支持一个维度传入 -1 自动推断大小。
     */
    public NDArray reshape(int... newShape) {
        throw new UnsupportedOperationException("TODO: S03");
    }

    /** 展平为一维数组，等价于 {@code reshape(-1)}。 */
    public NDArray flatten() {
        throw new UnsupportedOperationException("TODO: S03");
    }

    /** 返回深拷贝（始终连续）。 */
    public NDArray duplicate() {
        throw new UnsupportedOperationException("TODO: S03");
    }

    // ================================================================
    // S04 — 转置
    // ================================================================

    /** 二维转置：交换 axis 0 与 axis 1（零拷贝）。 */
    public NDArray transpose() {
        throw new UnsupportedOperationException("TODO: S04");
    }

    /** N 维转置：按给定排列重排轴顺序（零拷贝）。 */
    public NDArray transpose(int... axes) {
        throw new UnsupportedOperationException("TODO: S04");
    }

    /** 交换两个轴（零拷贝）。 */
    public NDArray swapAxes(int axis1, int axis2) {
        throw new UnsupportedOperationException("TODO: S04");
    }

    // ================================================================
    // S05 — 一元运算
    // ================================================================

    /** 逐元素取负。 */
    public NDArray neg() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素取绝对值。 */
    public NDArray abs() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算 e^x。 */
    public NDArray exp() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算自然对数。 */
    public NDArray log() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算平方根。 */
    public NDArray sqrt() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算平方。 */
    public NDArray square() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算 tanh。 */
    public NDArray tanh() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算 sin。 */
    public NDArray sin() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算 cos。 */
    public NDArray cos() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素取符号（sgn）。 */
    public NDArray sign() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素四舍五入。 */
    public NDArray round() {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素截断到 [{@code min}, {@code max}]。 */
    public NDArray clip(float min, float max) {
        throw new UnsupportedOperationException("TODO: S05");
    }

    /** 逐元素计算 x^p。 */
    public NDArray pow(float p) {
        throw new UnsupportedOperationException("TODO: S05");
    }

    // ================================================================
    // S06 — 二元运算与比较（同形）
    // ================================================================

    // --- 数组间算术 ---

    /** 逐元素加法。 */
    public NDArray add(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素减法。 */
    public NDArray sub(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素乘法。 */
    public NDArray mul(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素除法。 */
    public NDArray div(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素幂运算：{@code x^y}。 */
    public NDArray pow(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素取最大值。 */
    public NDArray maximum(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    // --- 标量算术 ---

    /** 每个元素加标量。 */
    public NDArray add(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 每个元素减标量。 */
    public NDArray sub(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 每个元素乘标量。 */
    public NDArray mul(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 每个元素除以标量。 */
    public NDArray div(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    // --- 数组间比较：结果为 1.0f / 0.0f ---

    /** 逐元素相等，满足处返回 1.0。 */
    public NDArray eq(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素不等，满足处返回 1.0。 */
    public NDArray neq(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素大于，满足处返回 1.0。 */
    public NDArray gt(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素大于等于，满足处返回 1.0。 */
    public NDArray gte(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素小于，满足处返回 1.0。 */
    public NDArray lt(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    /** 逐元素小于等于，满足处返回 1.0。 */
    public NDArray lte(NDArray other) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    // --- Comparisons (scalar) ---

    public NDArray eq(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    public NDArray neq(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    public NDArray gt(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    public NDArray gte(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    public NDArray lt(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    public NDArray lte(float scalar) {
        throw new UnsupportedOperationException("TODO: S06");
    }

    // ================================================================
    // S07 — 广播
    // ================================================================

    /**
     * 计算两个 shape 广播后的输出 shape。
     * <p>示例：[3, 1] + [1, 4] → [3, 4]</p>
     *
     * @throws IllegalArgumentException 若两个 shape 不兼容广播
     */
    public static int[] broadcastShapes(int[] shapeA, int[] shapeB) {
        throw new UnsupportedOperationException("TODO: S07");
    }

    /**
     * 返回广播到目标 shape 的视图（零拷贝，利用 stride=0 技巧）。
     */
    public NDArray broadcastTo(int... targetShape) {
        throw new UnsupportedOperationException("TODO: S07");
    }

    // ================================================================
    // S08 — 归约：求和与均值
    // ================================================================

    /** 所有元素求和。 */
    public float sum() {
        throw new UnsupportedOperationException("TODO: S08");
    }

    /** 所有元素求均值。 */
    public float mean() {
        throw new UnsupportedOperationException("TODO: S08");
    }

    /** 沿指定轴求和。 */
    public NDArray sum(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S08");
    }

    /** 沿指定轴求均值。 */
    public NDArray mean(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S08");
    }

    /** 沿多个轴求和。 */
    public NDArray sum(int[] axes, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S08");
    }

    // ================================================================
    // S09 — 归约：最大值、方差等
    // ================================================================

    /** 沿指定轴取最大值。 */
    public NDArray max(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 沿指定轴取最小值。 */
    public NDArray min(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 沿指定轴返回最大值的索引。 */
    public NDArray argmax(int axis) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 沿指定轴返回最小值的索引。 */
    public NDArray argmin(int axis) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 沿指定轴求乘积。 */
    public NDArray prod(int axis) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 沿指定轴计算方差。 */
    public NDArray var(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 沿指定轴计算标准差。 */
    public NDArray std(int axis, boolean keepDims) {
        throw new UnsupportedOperationException("TODO: S09");
    }

    /** 统计非零元素个数。 */
    public int countNonZero() {
        throw new UnsupportedOperationException("TODO: S09");
    }

    // ================================================================
    // S10 — 矩阵乘法
    // ================================================================

    /** 向量点积（1-D · 1-D → 标量，包装为 0-D 数组）。 */
    public NDArray dot(NDArray other) {
        throw new UnsupportedOperationException("TODO: S10");
    }

    /**
     * 矩阵乘法。
     * <ul>
     *   <li>二维：(M,K) × (K,N) → (M,N)</li>
     *   <li>批量：(...,M,K) × (...,K,N) → (...,M,N)</li>
     * </ul>
     */
    public NDArray matMul(NDArray other) {
        throw new UnsupportedOperationException("TODO: S10");
    }

    // ================================================================
    // S11 — 切片与视图
    // ================================================================

    /**
     * 返回子区域视图（零拷贝）。
     *
     * @param ranges 每个轴对应一个 {@link Slice}
     */
    public NDArray slice(Slice... ranges) {
        throw new UnsupportedOperationException("TODO: S11");
    }

    /** 在指定轴插入大小为 1 的新维度。 */
    public NDArray expandDims(int axis) {
        throw new UnsupportedOperationException("TODO: S11");
    }

    /** 移除指定轴上大小为 1 的维度。 */
    public NDArray squeeze(int axis) {
        throw new UnsupportedOperationException("TODO: S11");
    }

    /** 移除所有大小为 1 的维度。 */
    public NDArray squeeze() {
        throw new UnsupportedOperationException("TODO: S11");
    }

    // ================================================================
    // S12 — 创建与随机
    // ================================================================

    /** 创建一维等差数组：[start, end)，步长为 step。 */
    public static NDArray arange(float start, float end, float step) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 在 [start, end] 内均匀生成 {@code num} 个值。 */
    public static NDArray linspace(float start, float end, int num) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 创建 n×n 单位矩阵。 */
    public static NDArray eye(int n) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 以一维向量为对角线创建对角矩阵。 */
    public static NDArray diag(NDArray vector) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 创建标准正态分布随机数组 N(0,1)。 */
    public static NDArray randn(int... shape) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 创建 [0, 1) 均匀分布随机数组。 */
    public static NDArray rand(int... shape) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 创建 [lo, hi) 均匀分布随机数组。 */
    public static NDArray uniform(float lo, float hi, int... shape) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 原地随机打乱索引数组（Fisher-Yates 算法）。 */
    public static void shuffle(int[] indices) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    /** 原地将所有元素填充为指定值。 */
    public void fill(float value) {
        throw new UnsupportedOperationException("TODO: S12");
    }

    // ================================================================
    // S13 — 拼接与变换
    // ================================================================

    /** 沿已有轴拼接数组。 */
    public static NDArray concatenate(NDArray[] arrays, int axis) {
        throw new UnsupportedOperationException("TODO: S13");
    }

    /** 沿新轴堆叠数组。 */
    public static NDArray stack(NDArray[] arrays, int axis) {
        throw new UnsupportedOperationException("TODO: S13");
    }

    /**
     * 对数组进行填充。
     *
     * @param padWidth {@code padWidth[i] = {前, 后}} 表示第 i 轴两侧的填充量
     * @param value    填充值
     */
    public NDArray pad(int[][] padWidth, float value) {
        throw new UnsupportedOperationException("TODO: S13");
    }

    /** 沿指定轴翻转元素。 */
    public NDArray flip(int axis) {
        throw new UnsupportedOperationException("TODO: S13");
    }

    // ================================================================
    // S14 — 花式索引
    // ================================================================

    /**
     * 按索引选取行/列（用于 Embedding 查表）。
     * <p>示例：{@code weight.indexSelect(0, new int[]{3, 0, 3, 7})}</p>
     */
    public NDArray indexSelect(int axis, int[] indices) {
        throw new UnsupportedOperationException("TODO: S14");
    }

    /**
     * 将 {@code src} 按索引散射累加到本数组（Embedding 反向传播）。
     * <p>等价于 NumPy 的 {@code np.add.at(self, indices, src)}。</p>
     */
    public void scatterAdd(int axis, int[] indices, NDArray src) {
        throw new UnsupportedOperationException("TODO: S14");
    }

    /**
     * 返回新数组，{@code mask == 1.0} 的位置替换为 {@code value}。
     */
    public NDArray maskedFill(NDArray mask, float value) {
        throw new UnsupportedOperationException("TODO: S14");
    }

    /**
     * 逐元素条件选择：condition 非零取 {@code x}，否则取 {@code y}。
     */
    public static NDArray where(NDArray condition, NDArray x, NDArray y) {
        throw new UnsupportedOperationException("TODO: S14");
    }

    // ================================================================
    // S15 — 收官：工具箱
    // ================================================================

    /** 生成 n×n 下三角矩阵（用于因果掩码）。 */
    public static NDArray tril(int n, int diagonal) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 生成 n×n 上三角矩阵。 */
    public static NDArray triu(int n, int diagonal) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 沿指定轴计算 L2 范数。 */
    public NDArray norm(int axis) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 沿指定轴计算相邻元素差分。 */
    public NDArray diff(int axis) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 计算所有元素的第 q 百分位数。 */
    public NDArray percentile(float q) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 返回沿指定轴排序所需的索引。 */
    public NDArray argsort(int axis) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 返回去重后的排序元素。 */
    public NDArray unique() {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /**
     * 若所有元素与 {@code other} 对应元素之差均在 {@code atol} 以内，则返回 true。
     */
    public boolean allClose(NDArray other, float atol) {
        throw new UnsupportedOperationException("TODO: S15");
    }

    /** 转换元素类型：float32 ↔ int8。 */
    public NDArray astype(DType dtype) {
        throw new UnsupportedOperationException("TODO: S15");
    }
}
