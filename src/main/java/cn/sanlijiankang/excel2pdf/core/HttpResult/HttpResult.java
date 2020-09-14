package cn.sanlijiankang.excel2pdf.core.HttpResult;

import lombok.Data;

/**
 * Created by xxeNt
 * On 2020-08-15
 * Description:
 */
@Data
public class HttpResult {
    private int code = 200;
    private String msg;
    private Object data;
    private Boolean aBoolean;

    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_BAD_REQUEST, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setCode(200);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static HttpResult ok(Boolean aBoolean) {
        HttpResult r = new HttpResult();
        r.setCode(200);
        r.setABoolean(aBoolean);
        return r;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }
}
