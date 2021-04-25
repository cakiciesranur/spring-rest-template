package com.eny.springproject.dto.response;

import com.eny.springproject.model.UserEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserListResponse extends Serializers.Base {
    List<UserEntity> userList;
}
