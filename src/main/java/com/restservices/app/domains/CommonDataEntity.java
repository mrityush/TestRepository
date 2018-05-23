package com.restservices.app.domains;

import com.restservices.app.enums.EntityStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Priya on 28/4/18.
 */
@MappedSuperclass
public abstract class CommonDataEntity implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private EntityStatus entityStatus;

    @CreatedDate
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(nullable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column
    private Long createdBy;

    @Column
    private Long updatedBy;


    public CommonDataEntity() {
        this.setEntityStatus(EntityStatus.ACTIVE);
        this.setDateCreated(Calendar.getInstance().getTime());
        this.setLastUpdated(Calendar.getInstance().getTime());
    }

    /**
     * Gets updatedBy.
     *
     * @return Value of updatedBy.
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Gets dateCreated.
     *
     * @return Value of dateCreated.
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Gets lastUpdated.
     *
     * @return Value of lastUpdated.
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new lastUpdated.
     *
     * @param lastUpdated New value of lastUpdated.
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Gets createdBy.
     *
     * @return Value of createdBy.
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets new createdBy.
     *
     * @param createdBy New value of createdBy.
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Sets new updatedBy.
     *
     * @param updatedBy New value of updatedBy.
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets new dateCreated.
     *
     * @param dateCreated New value of dateCreated.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets entityStatus.
     *
     * @return Value of entityStatus.
     */
    public EntityStatus getEntityStatus() {
        return entityStatus;
    }

    /**
     * Sets new entityStatus.
     *
     * @param entityStatus New value of entityStatus.
     */
    public void setEntityStatus(EntityStatus entityStatus) {
        this.entityStatus = entityStatus;
    }
}
