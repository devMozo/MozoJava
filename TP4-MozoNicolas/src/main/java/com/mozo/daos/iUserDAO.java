package com.mozo.daos;

import com.mozo.models.Navigator;
import com.mozo.models.OS;
import com.mozo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * UserService's Interface
 */
@Repository
public interface iUserDAO extends JpaRepository<User, Long> {
    // Find a user by IP
    User findOneByIp(String ip);
    // Update a User
    @Modifying
    @Query("UPDATE User u " +
            "SET u.browser = :browser," +
                "u.os = :os " +
            "WHERE u.ip = :ip")
    int updateUser(@Param("ip") String ip, @Param("browser") Navigator browser, @Param("os") OS os);
    // Get the browser most used by users
    @Query("SELECT new Map(COUNT(u.ip) AS count, u.browser) " +
            "FROM User u " +
            "GROUP BY u.browser " +
            "ORDER BY COUNT(u.ip) DESC " )
    List<Map<String, Object>> getBrowserMostUsed();
    // Get the OS most used by users
    @Query("SELECT new Map(COUNT(u.ip) AS count, u.os) " +
            "FROM User u " +
            "GROUP BY u.os " +
            "ORDER BY COUNT(u.ip) DESC " )
    List<Map<String, Object>> getOSMostUsed();
    // Get the combination between OS and Browser most used by users
    @Query("SELECT new Map(COUNT(u.ip) AS count, u.os AS os, u.browser AS browser) " +
            "FROM User u " +
            "GROUP BY u.os, u.browser " +
            "ORDER BY COUNT(u.ip)" )
    List<Map<String, Object>> getCombinationMostUsed();
}
