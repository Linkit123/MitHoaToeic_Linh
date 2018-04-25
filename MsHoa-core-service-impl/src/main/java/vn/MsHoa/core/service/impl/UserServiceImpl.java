package vn.MsHoa.core.service.impl;

import vn.MsHoa.core.dao.UserDao;
import vn.MsHoa.core.daoimpl.UserDaoImpl;
import vn.MsHoa.core.dto.UserDTO;
import vn.MsHoa.core.persistence.entity.UserEntity;
import vn.MsHoa.core.utils.UserBeanUtil;
import vn.myclass.core.service.UserService;

/**
 * Created by trinhngoclinh on 4/16/2018.
 */
public class UserServiceImpl implements UserService {

    public UserDTO isUserEntity(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity=userDao.isUserEntity(dto.getName(),dto.getPassword());
    return UserBeanUtil.entitytoDto(entity);
    }

    public UserDTO finfRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity=userDao.isUserEntity(dto.getName(),dto.getPassword());
        return UserBeanUtil.entitytoDto(entity);
    }
}
