package pl.workshop5.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonIgnoreProperties({"stackTrace", "cause", "localizedMessage", "suppressed"})
public class ApiException extends RuntimeException {
    private final HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]")
    private final LocalDateTime timeStamp = LocalDateTime.now();

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
