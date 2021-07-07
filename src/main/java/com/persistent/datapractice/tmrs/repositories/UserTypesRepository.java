package com.persistent.datapractice.tmrs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.datapractice.tmrs.model.UserTypes;

@Repository
public interface UserTypesRepository extends CrudRepository<UserTypes, Long>{

}
