package vn.MsHoa.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by trinhngoclinh on 4/12/2018.
 */
@Entity
@Table(name = "listenguideline")
public class ListenGuidelineEntity {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getListenGuidelineID() {
        return listenGuidelineID;
    }

    public void setListenGuidelineID(Integer listenGuidelineID) {
        this.listenGuidelineID = listenGuidelineID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuidelineID;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "createddate")
    private Timestamp createdDate;

    @Column(name = "modifieddate")
    private  Timestamp modifiedDate;

    public List<CommentEntiy> getCommentEntiyList() {
        return commentEntiyList;
    }

    public void setCommentEntiyList(List<CommentEntiy> commentEntiyList) {
        this.commentEntiyList = commentEntiyList;
    }

    @OneToMany(mappedBy = "listenGuidelineEntity",fetch = FetchType.LAZY)
    private List<CommentEntiy> commentEntiyList;



}
