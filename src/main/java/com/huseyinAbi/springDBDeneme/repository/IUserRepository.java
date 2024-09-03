package com.huseyinAbi.springDBDeneme.repository;

import com.huseyinAbi.springDBDeneme.entity.UserEntity;
import com.huseyinAbi.springDBDeneme.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByIdentityNo(String identityNo);

    List<UserEntity> findAllByRole(Role role);

    List<UserEntity> findAllByRoleAndIdNotIn(Role role, List<Integer> idList);
}
