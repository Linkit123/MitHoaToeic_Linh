package vn.MsHoa.core.data.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trinhngoclinh on 4/12/2018.
 */
//hàm này sẽ truy vấn theo ID của các bảng có các id vd như userid,commentid..
public interface GenericDao<ID extends Serializable,T> {//extends tu lop doc file
    List<T> findAll();
    //  public
    T update(T entity);

    void save(T entity);

    T findById(ID var1);

    Object[] findByProperty(String property,Object value,String sortExpression,String sortDirection);
    //tạo findBYProperty(kiểu,giá trị input,sắp xếp theo trường,sắp xếp theo chiều) trả về nhiều kiểu do người dùng input từ khóa tìm kiếm

    Integer delete(List<ID> ids);
}
