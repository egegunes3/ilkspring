package com.huseyinAbi.springDBDeneme.service;

import com.huseyinAbi.springDBDeneme.entity.UserEntity;
import com.huseyinAbi.springDBDeneme.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUserService extends IService<UserEntity> {

    List<UserEntity> getUsersByRole(Role role);

    List<UserEntity> getPotentialUsers(List<Integer> ids);
}
