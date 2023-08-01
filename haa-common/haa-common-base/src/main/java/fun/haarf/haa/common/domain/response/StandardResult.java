package fun.haarf.haa.common.domain.response;

import fun.haarf.haa.common.enums.ResultEnum;
import lombok.Data;

/**
 * @Author: gourf
 * @Date: 2023-07-13  16:48
 * @Description: 通用接口返回包装类
 * @Version: 1.0
 */

@Data
public class StandardResult<T> {
    private String code;
    private String message;
    private T data;

    protected StandardResult() {
    }

    protected StandardResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> StandardResult<T> success(T data) {
        return new StandardResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> StandardResult<T> success(T data, String message) {
        return new StandardResult<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> StandardResult<T> failed() {
        return new StandardResult<>(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> StandardResult<T> failed(String message) {
        return new StandardResult<>(ResultEnum.FAILED.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> StandardResult<T> badRequest() {
        return new StandardResult<>(ResultEnum.BAD_REQUEST.getCode(), ResultEnum.BAD_REQUEST.getMessage(), null);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> StandardResult<T> badRequest(String message) {
        return new StandardResult<>(ResultEnum.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> StandardResult<T> unauthorized(T data) {
        return new StandardResult<>(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> StandardResult<T> forbidden(T data) {
        return new StandardResult<>(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage(), data);
    }
}
