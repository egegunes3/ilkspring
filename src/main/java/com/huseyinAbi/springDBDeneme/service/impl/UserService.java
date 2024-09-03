package com.huseyinAbi.springDBDeneme.service.impl;

import com.huseyinAbi.springDBDeneme.common.GeneralException;
import com.huseyinAbi.springDBDeneme.entity.UserEntity;
import com.huseyinAbi.springDBDeneme.entity.enums.Role;
import com.huseyinAbi.springDBDeneme.repository.IUserRepository;
import com.huseyinAbi.springDBDeneme.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private IUserRepository userRepository;


    @Override
    public List<UserEntity> getUsersByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<UserEntity> getPotentialUsers(List<Integer> ids) {
        if (ids.isEmpty()) {
            return userRepository.findAllByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdNotIn(Role.STUDENT, ids);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {

        if (userEntity.getId() != null) return null; //id null exception

        if (userEntity.getIdentityNo() == null || userEntity.getIdentityNo().length() != 11) {
            throw new GeneralException("Invalid identity no!!");
        }
        if (userRepository.existsByIdentityNo(userEntity.getIdentityNo())) {
            throw new GeneralException("Identitiy no is already exist.");
        }

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getById(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new GeneralException("User not found");
        }
        return userEntity.get();
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<UserEntity> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new GeneralException("User not found");
        }
        userRepository.deleteById(id);

    }
}
