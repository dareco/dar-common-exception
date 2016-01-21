package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public interface ErrorCode {
    ErrorSeries getSeries();

    int getCode();
}
