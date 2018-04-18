package com.mozo.daos;

import com.mozo.models.Navigator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface iNavigatorDAO extends JpaRepository<Navigator, Long> {
    Navigator findOneByName(String name);
}