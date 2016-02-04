package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ServerErrorRequestException extends ApiException {
    public static final int HTTP_STATUS = 500;
    public ServerErrorRequestException(ErrorCode errorCodes) {
        super(HTTP_STATUS, errorCodes,ErrorSourceSystem.DAR);
    }

    public ServerErrorRequestException(ErrorCode errorCode, Throwable throwable) {
        super(HTTP_STATUS, errorCode, throwable,ErrorSourceSystem.DAR);
    }

    public ServerErrorRequestException(int status, ErrorCode errorCode, ErrorSourceSystem system) {
        super(status, errorCode, system);
    }

    public ServerErrorRequestException(int status, ErrorCode errorCode, Throwable throwable, ErrorSourceSystem system) {
        super(status, errorCode, throwable, system);
    }
}