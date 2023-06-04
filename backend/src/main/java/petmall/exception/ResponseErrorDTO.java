package petmall.exception;

import petmall.util.ResponseDto;

import java.util.HashMap;

public class ResponseErrorDTO extends ResponseDto {

    public ResponseErrorDTO() {
    }

    public ResponseErrorDTO(int error) {
        this.error = error;
    }

    public ResponseErrorDTO(String status, String message, HashMap<String, Object> data, int error) {
        super(status, message, data);
        this.error = error;
    }

    private int error;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseErrorDTO{" +
            "error=" + error +
            '}';
    }
}
