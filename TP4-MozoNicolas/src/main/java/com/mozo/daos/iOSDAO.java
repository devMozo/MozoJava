package com.mozo.daos;

import com.mozo.models.OS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface iOSDAO extends CrudRepository<OS, Long> {
}
