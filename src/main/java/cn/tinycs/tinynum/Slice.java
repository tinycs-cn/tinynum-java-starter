package cn.tinycs.tinynum;

/**
 * 描述单个轴的切片范围：[start, stop)，步长为 step。
 * 供 {@link NDArray#slice(Slice...)} 使用。
 *
 * <p>等价于 Python 的 {@code a[start:stop:step]}。</p>
 */
public record Slice(int start, int stop, int step) {

    /** 创建步长为 1 的切片 [start, stop)。 */
    public static Slice of(int start, int stop) {
        return new Slice(start, stop, 1);
    }

    /** 创建指定步长的切片 [start, stop)。 */
    public static Slice of(int start, int stop, int step) {
        return new Slice(start, stop, step);
    }

    /** 选取整个轴（等价于 Python 的 {@code :}）。 */
    public static Slice all() {
        return new Slice(0, Integer.MAX_VALUE, 1);
    }
}
