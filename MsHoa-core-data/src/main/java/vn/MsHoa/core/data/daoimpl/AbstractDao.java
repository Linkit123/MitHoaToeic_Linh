package vn.MsHoa.core.data.daoimpl;

import org.hibernate.*;
import vn.MsHoa.core.common.constant.CoreConstant;
import vn.MsHoa.core.common.utils.HibernateUtil;
import vn.MsHoa.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trinhngoclinh on 4/12/2018.
 */
public class AbstractDao<ID extends Serializable,T> implements GenericDao<ID,T>{
    //tạo đối tượng để get session từ HibernateUtil mà ta đã tạo ra
    private Class<T> persistenceClass;//cung cấp biến chứa các class Entity(bảng CSDL)
    public AbstractDao(){//cung cấp giá trị cho biến ClassEntity
        //tạo contructor cho class thay vì get set,thứ 1 vì ta chỉ sử dụng cho class AbstractDAo
        //thứ 2 là ngay sau khi chạy class contructor nó có nhiệm vụ khởi tạo biến
        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        //ParametterType...getActualTypeArguments()[1]:get kiểu của tất cả các biến trong AbstractClass(ID và T)
        //biến có vị trí [1](là T-biến T là sẽ đc gán cho các class Entity như UserEntity,RoleEntity...)
        //sau đó gán giá trị này cho persistenceClass
    }

    //hàm chuyển class sang string
    public String getPersisteceClassName(){
        return persistenceClass.getSimpleName();
    }
    //    protected Session getSession(){//hàm này cho phép mở 1 phiên giao dịch
//        return HibernateUtil.getSessionFactory().openSession();
//    }
    public List<T> findAll() {
        List<T> list =new ArrayList<T>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        //do transaction
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();//mở 1 phiên giao dịch
            //HQL sqlBuilder
            StringBuilder sql=new StringBuilder("from ");
            sql.append(this.getPersisteceClassName());
            Query query=session.createQuery(sql.toString());
            list=query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
        return list;
    }
    //api Update
    public T update(T entity) {
        T result=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try{
            Object object = session.merge(entity);//gộp dữ liệu đã tạo vào đối tượng vừa tạo
            result= (T) object;
            transaction.commit();
        }catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }
    //api Save
    public void save(T entity) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.persist(entity);//lưu dữ liệu
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

    }
    //api findById
    public T findById(ID id) {
        T result=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try{
            result=(T) session.get(persistenceClass,id);
            if(result==null){
                throw  new ObjectNotFoundException("Không tìm thấy"+id,null);
            }
            transaction.commit();
        }catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }
    //api findByProperty
    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T> list=new ArrayList<T>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Object totalItem=0;
        /*truy vấn tìm ra danh sách theo property*/
        try {
            StringBuilder sql=new StringBuilder("from ");
            sql.append(getPersisteceClassName());
            if(property!=null && value!=null) {
                sql.append(" where ").append(property).append("=:value");
            }
            if(sortExpression!=null && sortExpression!=null) {
                sql.append(" order by ").append(sortExpression);
                sql.append(" " +(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query queryList=session.createQuery(sql.toString());
            if(value!=null) {
                queryList.setParameter("value", value);
            }
            list=queryList.list();

            /*truy vấn đếm size list vừa sinh*/
            StringBuilder sql1=new StringBuilder("select count(*) from ");
            sql1.append(getPersisteceClassName());
            if(property!=null && value!=null) {
                sql1.append(" where ").append(property).append("= :value");
            }
            Query querySize=session.createQuery(sql1.toString());
            if(value!=null) {
                querySize.setParameter("value", value);
            }
            totalItem=querySize.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return new Object[]{totalItem,list};
    }
    //api delete
    public Integer delete(List<ID> ids) {
        Integer count=0;
        List<T> list =new ArrayList<T>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            for (ID item : ids) {
                T t= (T) session.get(persistenceClass,item);
                session.delete(t);
                count ++;
            }
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
        return count;
    }
//    private Class<T> persistenceClass;
//    public AbstractDao(){
//        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//    }
//    public String getPersistenceClassNametoString(){
//        return persistenceClass.getSimpleName();
//    }
//    protected Session getSession()
//    {
//        return HibernateUtil.getSessionFactory().openSession();
//    }
//    public List<T> findAll() {
//        List<T> list=new ArrayList<T>();
//        Session session=HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction=null;
//        try{
//            transaction=session.beginTransaction();
//            StringBuilder sqlfindAll=new StringBuilder("from ");
//            sqlfindAll.append(this.getPersistenceClassNametoString());
//            Query querryfindAll=session.createQuery(sqlfindAll.toString());
//            list=querryfindAll.list();
//            transaction.commit();
//        }catch (HibernateException e){
//            transaction.rollback();
//            throw e;
//        }
//        return list;
//    }
}
