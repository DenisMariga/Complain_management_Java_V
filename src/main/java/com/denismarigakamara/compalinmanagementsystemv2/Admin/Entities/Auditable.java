package com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
    @CreatedBy
    protected U CreatedBY;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date CreatedOn;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date LastUpdated;
    @LastModifiedBy
    protected  U UpdatedBy;
}
