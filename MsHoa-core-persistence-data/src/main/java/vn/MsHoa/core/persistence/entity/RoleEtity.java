package vn.MsHoa.core.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by trinhngoclinh on 4/11/2018.
 */
@Entity
@Table(name = "role")
public class RoleEtity {
    @Id
    @Column(name = "roleid")
    private Integer roleID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roleEtity",fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList;

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
