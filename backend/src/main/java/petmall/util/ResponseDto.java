package petmall.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String status;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    public Map<String, Object> addData(String key, Object value){
        this.data.put(key,value);
        return this.data;
    }

}

