package org.javaboy.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.security.model.Role;
import org.javaboy.security.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRolesByUid(Integer uid);
}
