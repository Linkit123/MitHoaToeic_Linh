package vn.MsHoa.core.web.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by trinhngoclinh on 4/20/2018.
 */
public class FormUtil {
    public static <T> T populate(Class<T> tClass, HttpServletRequest request){
        T object=null;
        try {
            object=(T) tClass.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
