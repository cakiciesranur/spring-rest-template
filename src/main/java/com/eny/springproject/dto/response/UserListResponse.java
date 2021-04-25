package com.eny.springproject.dto.response;

import com.eny.springproject.model.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserListResponse {
    List<UserEntity> userList;
}
