package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = -1L;

    private int status = 500;
    private ErrorCode errorCode;

    public ApiException(int status, ErrorCode errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public ApiException(int status, ErrorCode errorCode, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
        this.status = status;
    }

    public ApiException(int status, ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: ").append(status).append(" ");
        sb.append("Error code: ").append(errorCode).append(" ");
        sb.append("FUll code: ").append(getFullCode());

        return sb.toString();
    }

    public ErrorInfo getErrorInfo(ErrorLocaleContext context) {
        long fullCode = getFullCode();
        String errorURL = "docs/"+fullCode;
        String localizedMessage;
        if(context != null) {
            localizedMessage = context.getLocalizedMessage(fullCode);
        } else {
            localizedMessage = getMessage();
        }

        ErrorInfo errorInfo = new ErrorInfo(getStatus(), getErrorCode().getSeries().getSeries(), fullCode, localizedMessage,
                getMessage(), errorURL);
        return errorInfo;
    }

    private long getFullCode(){
        long eCode = status * 100;
        eCode = eCode + getErrorCode().getSeries().getSeries();
        eCode = (eCode * 1000) + getErrorCode().getCode();
        return eCode;
    }
}