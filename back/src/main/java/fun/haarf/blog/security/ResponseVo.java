package fun.haarf.blog.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseVo implements Serializable {

    private static final long serialVersionUID = -5534293980762889147L;

    private String result;
    private String type;
    private String message;
}
