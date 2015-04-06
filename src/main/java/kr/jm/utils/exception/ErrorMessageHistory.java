package kr.jm.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageHistory {

	private long timestamp;
	private String errorMessage;

}
