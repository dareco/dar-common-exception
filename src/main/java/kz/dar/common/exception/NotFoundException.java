package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class NotFoundException extends ApiException {
    public static final int HTTP_STATUS = 404;
    public NotFoundException(ErrorCode errorCodes) {
        super(HTTP_STATUS, errorCodes,ErrorSourceSystem.DAR);
    }

    public NotFoundException(ErrorCode errorCodes, Throwable throwable) {
        super(HTTP_STATUS, errorCodes, throwable, ErrorSourceSystem.DAR);
    }

    public NotFoundException(int status, ErrorCode errorCode, ErrorSourceSystem system) {
        super(status, errorCode, system);
    }

    public NotFoundException(int status, ErrorCode errorCode, Throwable throwable, ErrorSourceSystem system) {
        super(status, errorCode, throwable, system);
    }
}
