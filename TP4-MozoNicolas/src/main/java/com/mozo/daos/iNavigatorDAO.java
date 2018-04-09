package com.mozo.daos;

import com.mozo.models.Navigator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface iNavigatorDAO extends CrudRepository<Navigator, Long> {
}
