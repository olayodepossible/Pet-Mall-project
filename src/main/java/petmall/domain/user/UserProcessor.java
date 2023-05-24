package petmall.domain.user;

import petmall.adapters.mysql.user.UserEntity;
import petmall.api.user.dto.UserRequestPayload;

public interface UserProcessor {
    String getUserType();
    UserEntity processUserTypeReq(UserRequestPayload req);
}
