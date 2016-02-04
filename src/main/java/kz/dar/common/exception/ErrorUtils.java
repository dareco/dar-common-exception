package kz.dar.common.exception;

/**
 * @author Sabyrzhan Tynybayev
 * @date 26/01/16
 */
public class ErrorUtils {
    public static long generateFullCode(int httpStatus, int errorSeries, int errorCode) {
        long eCode = httpStatus * 100;
        eCode = eCode + errorSeries;
        eCode = (eCode * 1000) + errorCode;

        return eCode;
    }

    public static long generateFullCode(int httpStatus, ErrorCode errorCode) {
        return generateFullCode(httpStatus, errorCode.getSeries().getSeries(), errorCode.getCode());
    }
}