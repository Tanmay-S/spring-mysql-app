package com.ahc.springmysqlapp.repositories;

import com.ahc.springmysqlapp.domain.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
