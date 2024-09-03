package com.huseyinAbi.springDBDeneme.entity;


import com.huseyinAbi.springDBDeneme.entity.enums.Gender;
import com.huseyinAbi.springDBDeneme.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String identityNo;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="user_role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
