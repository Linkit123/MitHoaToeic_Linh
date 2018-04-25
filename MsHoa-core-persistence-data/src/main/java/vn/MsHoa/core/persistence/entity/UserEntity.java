package vn.MsHoa.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by trinhngoclinh on 4/11/2018.
 */
@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    public RoleEtity getRoleEtity() {
        return roleEtity;

    }

    public List<CommentEntiy> getCommentEntiyList() {
        return commentEntiyList;
    }

    public void setCommentEntiyList(List<CommentEntiy> commentEntiyList) {
        this.commentEntiyList = commentEntiyList;
    }

    public void setRoleEtity(RoleEtity roleEtity) {
        this.roleEtity = roleEtity;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEtity roleEtity;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY)
    private List<CommentEntiy> commentEntiyList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "fullname")
    private  String fullName;

    @Column(name = "createddate")
    private Timestamp createdDate;

}
