package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = -1L;

    private int status = 500;
    private ErrorCode errorCode;
    private ErrorSourceSystem system;

    public ApiException(int status, ErrorCode errorCode, ErrorSourceSystem system) {
        this.status = status;
        this.errorCode = errorCode;
        this.system = system;
    }

    public ApiException(int status, ErrorCode errorCode, Throwable throwable, ErrorSourceSystem system) {
        super(throwable);
        this.errorCode = errorCode;
        this.status = status;
        this.system = system;
    }

    public ApiException(int status, ErrorCode errorCode, String message, ErrorSourceSystem system) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
        this.system = system;
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
        sb.append("Status: ").append(status).append(", ");
        sb.append("Error code: ").append(errorCode).append(", ");
        sb.append("Full code: ").append(system).append(".")
                .append(ErrorUtils.generateFullCode(status, errorCode)).append(", ");
        sb.append("Exception message: ").append(super.getMessage());

        return sb.toString();
    }

    public ErrorInfo getErrorInfo(ErrorLocaleContext context) {
        long fullCode = ErrorUtils.generateFullCode(status, errorCode);
        String errorURL = "docs/"+fullCode;
        String localizedMessage;
        if(context != null) {
            localizedMessage = context.getLocalizedMessage(fullCode);
        } else {
            localizedMessage = getMessage();
        }

        ErrorInfo errorInfo = new ErrorInfo(system, getStatus(), getErrorCode().getSeries().getSeries(), fullCode, localizedMessage,
                getMessage(), errorURL);
        return errorInfo;
    }
}