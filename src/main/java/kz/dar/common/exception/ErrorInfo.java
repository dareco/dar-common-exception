package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ErrorInfo {
    private ErrorSourceSystem system;
	private int status;
	private int series;
	private String code;
	private String message;
	private String developerMessage;
	private String moreInfo;

    public ErrorInfo() {
    }

    public ErrorInfo(ErrorSourceSystem system, int httpStatus, ErrorCode errorCode) {
        this(system, httpStatus, errorCode.getSeries().getSeries(),
                ErrorUtils.generateFullCode(httpStatus, errorCode.getSeries().getSeries(), errorCode.getCode()),
                null, null, null);
    }

    public ErrorInfo(ErrorSourceSystem system, int httpStatus, int series, long code) {
        this(system, httpStatus, series, code, null, null, null);
    }

    public ErrorInfo(ErrorSourceSystem system, int status, int series, long code,
                     String message, String developerMessage, String moreInfo) {
        this.system = system;
        this.status = status;
        this.series = series;
        this.code = system + "." + code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.moreInfo = moreInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public ErrorSourceSystem getSystem() {
        return system;
    }

    public void setSystem(ErrorSourceSystem system) {
        this.system = system;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getMoreInfo() {
        if(moreInfo != null) {
            return "docs/" + code;
        }

        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorInfo{");
        sb.append("system=").append(system);
        sb.append(", status=").append(status);
        sb.append(", series=").append(series);
        sb.append(", code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", developerMessage='").append(developerMessage).append('\'');
        sb.append(", moreInfo='").append(moreInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}