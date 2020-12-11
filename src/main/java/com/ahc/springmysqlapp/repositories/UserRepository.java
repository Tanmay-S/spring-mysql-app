package com.ahc.springmysqlapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ahc.springmysqlapp.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
