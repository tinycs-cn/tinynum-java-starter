package cn.tinycs.tinynum;

/**
 * {@link NDArray} 支持的数据类型。
 *
 * <p>课程全程使用 {@code FLOAT32}。{@code INT8} 在 S15 引入，
 * 为 tinytorch4j 的 int8 量化做准备。</p>
 */
public enum DType {
    FLOAT32,
    INT8
}
