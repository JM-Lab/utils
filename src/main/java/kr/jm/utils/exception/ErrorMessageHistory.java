package kr.jm.utils.exception;

import lombok.Data;

@Data
public class ErrorMessageHistory {

	private long timestamp;
	private String errorMessage;

	public ErrorMessageHistory(long timestamp, String errorMessage) {
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
	}

}
