package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ServerErrorRequestException extends ApiException {
    private static final int HTTP_STATUS = 500;
    public ServerErrorRequestException(ErrorCode errorCodes) {
        super(HTTP_STATUS, errorCodes);
    }

    public ServerErrorRequestException(ErrorCode errorCode, Throwable throwable) {
        super(HTTP_STATUS, errorCode, throwable);
    }
}