package com.mozo.daos;

import com.mozo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * UserService's Interface
 */
@Transactional
public interface iUserDAO extends CrudRepository<User, Long> {

}
