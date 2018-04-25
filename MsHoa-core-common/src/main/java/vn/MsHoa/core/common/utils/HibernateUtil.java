package vn.MsHoa.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by trinhngoclinh on 4/11/2018.
 */
public class HibernateUtil {
    private static  final SessionFactory SessionFactory=buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            //tao sessionfactory tu file hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Lỗi khởi tạo session factory");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return SessionFactory;
    }
}
