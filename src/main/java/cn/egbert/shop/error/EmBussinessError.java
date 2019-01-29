package cn.egbert.shop.error;

public enum EmBussinessError implements CommonError {
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOWN(10002, "未知错误"),
    USER_NOT_EXIST(20001, "用户不存在");

    private int errCode;
    private String errMsg;

    EmBussinessError() {
    }

    EmBussinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String msg) {
        this.errMsg = msg;
        return this;
    }
}
