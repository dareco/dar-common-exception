package kz.dar.common.exception;

/**
 * Created by sabyrzhan on 6/11/15.
 */
public class UnauthorizedErrorException extends ApiException {
    private static final int UNAUTHORIZED_EROR_CODE = 401;

    public UnauthorizedErrorException(ErrorCode errorCode) {
        super(UNAUTHORIZED_EROR_CODE, errorCode);
    }

    public UnauthorizedErrorException(ErrorCode errorCode, Throwable throwable) {
        super(UNAUTHORIZED_EROR_CODE, errorCode, throwable);
    }
}
