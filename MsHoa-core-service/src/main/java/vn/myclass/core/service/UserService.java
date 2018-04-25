package vn.myclass.core.service;

import vn.MsHoa.core.dto.UserDTO;
import vn.MsHoa.core.persistence.entity.UserEntity;

/**
 * Created by trinhngoclinh on 4/20/2018.
 */
public interface UserService {
    UserDTO isUserEntity(UserDTO dto);
    UserDTO finfRoleByUser(UserDTO dto);
}
