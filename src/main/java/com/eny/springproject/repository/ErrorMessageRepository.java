package com.eny.springproject.repository;

import com.eny.springproject.model.ErrorMessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ErrorMessageRepository extends CrudRepository<ErrorMessageEntity, String> {

    ErrorMessageEntity findByErrorCode(int errorCode);
}
