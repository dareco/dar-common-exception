package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ForbiddenErrorException extends ApiException {
    public static final int FORBIDDEN_STATUS = 403;

    public ForbiddenErrorException(ErrorCode errorCodes) {
        super(FORBIDDEN_STATUS, errorCodes, ErrorSourceSystem.DAR);
    }

    public ForbiddenErrorException(ErrorCode errorCodes, Throwable throwable) {
        super(FORBIDDEN_STATUS, errorCodes, throwable, ErrorSourceSystem.DAR);
    }
}
