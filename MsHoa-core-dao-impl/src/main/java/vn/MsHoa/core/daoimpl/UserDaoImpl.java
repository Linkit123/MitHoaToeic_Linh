package vn.MsHoa.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.MsHoa.core.common.utils.HibernateUtil;
import vn.MsHoa.core.dao.UserDao;
import vn.MsHoa.core.data.daoimpl.AbstractDao;
import vn.MsHoa.core.persistence.entity.UserEntity;
/**
 * Created by trinhngoclinh on 4/16/2018.
 */
public class UserDaoImpl extends AbstractDao<Integer,UserEntity> implements UserDao {
    public UserEntity isUserEntity(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        UserEntity entity = new UserEntity();
        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name=:name AND password=:password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }

        return entity;
    }

//    public UserEntity findRoleByUser(String name, String password) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        UserEntity entity = new UserEntity();
//        try {
//            StringBuilder sql=new StringBuilder("FROM UserEntity WHERE name=:name AND password=:password");
//            Query query=session.createQuery(sql.toString());
//            query.setParameter("name",name);
//            query.setParameter("password",password);
//            entity=query.uniqueResult();
//            transaction.commit();
//        }catch (HibernateException e){
//            transaction.rollback();
//            throw e;
//        }
//        return entity;
//    }
}
