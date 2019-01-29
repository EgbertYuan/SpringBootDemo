package cn.egbert.shop.response;

public class CommonReturnType {
    //success  failue
    private String status;
    private Object data;
    private int code;

    public static CommonReturnType createFailure(Object result, int code) {
        return CommonReturnType.create(result, "failure", code);
    }

    public static CommonReturnType create(Object result, String status, int code) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setCode(code);
        type.setData(result);
        return type;
    }

    public static CommonReturnType create(Object result) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus("success");
        type.setCode(200);
        type.setData(result);
        return type;
    }

    public static CommonReturnType create() {
        CommonReturnType type = new CommonReturnType();
        type.setStatus("success");
        type.setCode(200);
        type.setData("");
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
