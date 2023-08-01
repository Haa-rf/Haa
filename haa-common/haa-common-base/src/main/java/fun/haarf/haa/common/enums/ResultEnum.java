package fun.haarf.haa.common.enums;

import lombok.Getter;

/**
 * @Author: gourf
 * @Date: 2023-07-13  17:31
 * @Description: 返回结果枚举类
 * @Version: 1.0
 */
@Getter
public enum ResultEnum {
    SUCCESS("200", "操作成功"),
    FAILED("500", "操作失败"),
    BAD_REQUEST("400", "参数错误"),
    UNAUTHORIZED("401", "未登录或token已过期"),
    FORBIDDEN("403", "没有相关权限");
    private final String code;
    private final String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
