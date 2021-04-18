package org.itstep.webApp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "t_employees")
public class Employee extends BaseEntity{

    @ManyToMany(fetch = FetchType.EAGER)
    List<Course> courses;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
