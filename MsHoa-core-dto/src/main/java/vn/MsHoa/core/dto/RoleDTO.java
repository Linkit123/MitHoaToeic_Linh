package vn.MsHoa.core.dto;

import java.io.Serializable;

/**
 * Created by trinhngoclinh on 4/15/2018.
 */
public class RoleDTO implements Serializable {
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer roleId;
    private String name;
}
