package cn.egbert.shop.error;

public interface CommonError {
    int getErrorCode();

    String getErrorMsg();

    CommonError setErrorMsg(String msg);
}
