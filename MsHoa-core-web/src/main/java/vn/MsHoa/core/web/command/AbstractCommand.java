package vn.MsHoa.core.web.command;

import java.util.List;

/**
 * Created by trinhngoclinh on 4/15/2018.
 */
public class AbstractCommand<T> {
    protected T pojo;
    private String crudaction;
/********************************/
    private int maxPageItems=20;
    private int firstItem=0;
    private int totalItems=0;
    private String sortExpression;
    private String sortDirection;
    private String[] checkList;
    private List<T> listResult;
    private String tableId="tableList";
    private String messageRespone;
    private int page = 1;

    public String getCrudaction() {
        return crudaction;
    }

    public void setCrudaction(String crudaction) {
        this.crudaction = crudaction;
    }
    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }
}
