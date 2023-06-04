package petmall.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@ControllerAdvice
@ResponseBody
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {RestClientException.class,})
    public ResponseEntity<ResponseErrorDTO> exceptionHandler(RestClientException restClientException, WebRequest request) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("cause", restClientException.getMessage());
        ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO("Error", "An error occured", data, 500);
        return new ResponseEntity<>(responseErrorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> exceptionHandler(DataNotFoundException notFoundException, WebRequest request){
        HashMap<String, Object> data = new HashMap<>();
        data.put("cause", notFoundException.getMessage());
        ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO("Error", "An error occured", data, 404);
        return new ResponseEntity<>(responseErrorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<ResponseErrorDTO> exceptionHandler(HttpClientErrorException httpClientErrorException, WebRequest request) {
        HashMap<String, Object> data = new HashMap<>();

        String message = httpClientErrorException.getMessage() != null ? httpClientErrorException.getMessage() : "";
        message  = message.replace(String.valueOf(httpClientErrorException.getRawStatusCode()),"").trim();
        data.put("cause", httpClientErrorException.getMessage());

        ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO("Error", message, data, httpClientErrorException.getRawStatusCode());
        return new ResponseEntity<>(responseErrorDTO, httpClientErrorException.getStatusCode());
    }
}
