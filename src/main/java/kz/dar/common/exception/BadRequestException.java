package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class BadRequestException extends ApiException {
    public static final int BAD_REQUEST_STATUS = 400;
    public BadRequestException(ErrorCode errorCodes) {
        super(BAD_REQUEST_STATUS, errorCodes, ErrorSourceSystem.DAR);
    }

    public BadRequestException(ErrorCode errorCode, Throwable throwable) {
        super(BAD_REQUEST_STATUS, errorCode, throwable, ErrorSourceSystem.DAR);
    }

    public BadRequestException(int status, ErrorCode errorCode, ErrorSourceSystem system) {
        super(status, errorCode, system);
    }

    public BadRequestException(int status, ErrorCode errorCode, Throwable throwable, ErrorSourceSystem system) {
        super(status, errorCode, throwable, system);
    }
}