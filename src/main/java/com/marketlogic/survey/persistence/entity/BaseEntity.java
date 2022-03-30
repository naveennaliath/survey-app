package com.marketlogic.survey.persistence.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseEntity {

  @CreatedBy
  private String createdBy;

  @CreatedDate
  private LocalDateTime createdOn;
  
  @LastModifiedBy
  private String lastModifiedBy;
  
  @LastModifiedDate
  private LocalDateTime lastModifiedOn;
}
