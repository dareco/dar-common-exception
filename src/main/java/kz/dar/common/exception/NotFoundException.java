package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class NotFoundException extends ApiException {
    private static final int HTTP_STATUS = 404;
    public NotFoundException(ErrorCode errorCodes) {
        super(HTTP_STATUS, errorCodes);
    }

    public NotFoundException(ErrorCode errorCodes, Throwable throwable) {
        super(HTTP_STATUS, errorCodes, throwable);
    }
}
