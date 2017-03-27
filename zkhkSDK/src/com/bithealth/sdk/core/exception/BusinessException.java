package com.bithealth.sdk.core.exception;

/**
 * 系统业务异常
 * @author luocanfeng
 * @date 2011-6-30 10:20:46
 */
public class BusinessException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 2332608236621015980L;

    private String            code;

    public BusinessException(Throwable throwable, String frdMessage) {
        super(throwable);
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(createFriendlyErrMsg(message));
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private static String createFriendlyErrMsg(String msgBody) {
        String prefixStr = "抱歉，";
        String suffixStr = " 请稍后再试或与管理员联系！";

        StringBuffer friendlyErrMsg = new StringBuffer("");

        friendlyErrMsg.append(prefixStr);

        friendlyErrMsg.append(msgBody);

        friendlyErrMsg.append(suffixStr);

        return friendlyErrMsg.toString();
    }
}
