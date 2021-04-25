package com.eny.springproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "error_messages")
public class ErrorMessageEntity extends BaseEntity {
    private static final long serialVersionUID = 5210442167387592397L;

    private int errorCode;

    @Column(length = 60)
    private String message;

    public ErrorMessageEntity(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorMessageEntity() {

    }
}
