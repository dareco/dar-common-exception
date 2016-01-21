package kz.dar.common.exception;

/**
 * @author sabyrzhan.tynybayev@greenapple.kz
 */
public class ErrorInfo {
	private int status;
	private int series;
	private long code;
	private String message;
	private String developerMessage;
	private String moreInfo;

    public ErrorInfo() {
    }


    public ErrorInfo(int status, int series, long code) {
        this.status = status;
        this.series = series;
        this.code = code;
    }

    public ErrorInfo(int status, int series, long code, String message, String developerMessage, String moreInfo) {
        this.status = status;
        this.series = series;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "status=" + status +
                ", series=" + series +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", developerMessage='" + developerMessage + '\'' +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }

	public int getStatus() {
		return status;
	}

	public int getSeries() {
		return series;
	}

	public long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public String getMoreInfo() {
		return moreInfo;
	}
}