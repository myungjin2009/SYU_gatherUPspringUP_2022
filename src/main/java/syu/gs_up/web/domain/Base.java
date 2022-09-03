package syu.gs_up.web.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    @PrePersist
    public void createDate(){
        created = LocalDateTime.now();
        modified = created;
    }

    @PreUpdate
    public void updateDate(){
        this.modified = LocalDateTime.now();
    }
}
