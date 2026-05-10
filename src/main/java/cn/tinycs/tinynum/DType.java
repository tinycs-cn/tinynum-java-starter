package cn.tinycs.tinynum;

/**
 * Supported data types for {@link NDArray}.
 *
 * <p>The course uses {@code FLOAT32} throughout. {@code INT8} is introduced
 * in S15 to prepare for int8 quantization in tinytorch4j.</p>
 */
public enum DType {
    FLOAT32,
    INT8
}
