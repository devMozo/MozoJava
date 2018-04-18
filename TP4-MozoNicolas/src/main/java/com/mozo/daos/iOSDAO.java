package com.mozo.daos;

import com.mozo.models.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iOSDAO extends JpaRepository<OS, Long> {
    OS findOneByName(String name);
}
