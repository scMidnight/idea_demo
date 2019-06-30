package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SOURCES")
public class Sources extends IdEntity {
    @Column(name = "SOURCE_TAG")
    private String sourceTag;//来源标签名称
    @Column(name = "INSERT_DATE")
    private Date insertDate;//插入时间
    @Column(name = "IS_DEL")
    private String isDel;//是否删除0否1是

    public String getSourceTag() {
        return sourceTag;
    }

    public void setSourceTag(String sourceTag) {
        this.sourceTag = sourceTag;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}
