package com.huseyinAbi.springDBDeneme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Entity
@Table(name="lectures")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    public Integer getTeacherId(){
        return teacher.getId();
    }

    @ManyToOne
    @JoinColumn(name= "teacher_id")
    private UserEntity teacher;


    @ManyToMany
    @JoinTable(name="user_lectures",
    joinColumns = {@JoinColumn(name = "lecture_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<UserEntity> students;


}
