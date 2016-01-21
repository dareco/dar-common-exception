package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public interface ErrorLocaleContext {
    String getLocalizedMessage(long fullErrorCode);
}