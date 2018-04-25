package vn.MsHoa.core.dao;

import vn.MsHoa.core.data.dao.GenericDao;
import vn.MsHoa.core.persistence.entity.UserEntity;

/**
 * Created by trinhngoclinh on 4/16/2018.
 */
public interface UserDao extends GenericDao<Integer,UserEntity> {
    UserEntity isUserEntity(String name, String password);
    //UserEntity findRoleByUser(String name,String password);
}
