package org.itstep.webApp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "t_students")
public class Student extends BaseEntity {

    // в Студенте
    @ManyToOne(fetch = FetchType.EAGER)
    private Group group;
}
