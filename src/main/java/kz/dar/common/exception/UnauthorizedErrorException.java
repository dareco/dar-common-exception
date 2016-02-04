package kz.dar.common.exception;

/**
 * Created by sabyrzhan on 6/11/15.
 */
public class UnauthorizedErrorException extends ApiException {
    public static final int UNAUTHORIZED_EROR_CODE = 401;

    public UnauthorizedErrorException(ErrorCode errorCode) {
        super(UNAUTHORIZED_EROR_CODE, errorCode,ErrorSourceSystem.DAR);
    }

    public UnauthorizedErrorException(ErrorCode errorCode, Throwable throwable) {
        super(UNAUTHORIZED_EROR_CODE, errorCode, throwable,ErrorSourceSystem.DAR);
    }

    public UnauthorizedErrorException(int status, ErrorCode errorCode, ErrorSourceSystem system) {
        super(status, errorCode, system);
    }

    public UnauthorizedErrorException(int status, ErrorCode errorCode, Throwable throwable, ErrorSourceSystem system) {
        super(status, errorCode, throwable, system);
    }
}
