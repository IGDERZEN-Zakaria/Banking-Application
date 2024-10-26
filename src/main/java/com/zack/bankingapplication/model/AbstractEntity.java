package com.zack.bankingapplication.model;

import jakarta.persistence.*;

import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long version;

    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

    @PrePersist
    public void prePersist() {
        createDate = new Date();
        version = 1L;
    }

    @PreUpdate
    public void preUpdate() {
        version++;
        lastUpdateDate = new Date();
    }

}
