package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class BadRequestException extends ApiException {
    private static final int BAD_REQUEST_STATUS = 400;
    public BadRequestException(ErrorCode errorCodes) {
        super(BAD_REQUEST_STATUS, errorCodes);
    }

    public BadRequestException(ErrorCode errorCode, Throwable throwable) {
        super(BAD_REQUEST_STATUS, errorCode, throwable);
    }
}