package com.mozo.daos;

import com.mozo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAO implements iUserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertUser(User user) {
        // Persist the user on the DB
        this.entityManager.persist(user);
    }

    @Override
    public List<User> findAllUsers() {
        // Used to construct criteria queries, compound selections, expressions, predicates, orderings.
        CriteriaBuilder tCriteriaBuilder = this.entityManager.getCriteriaBuilder();
        // Create a CriteriaQuery object with the specified result type.
        CriteriaQuery<User> tCriteriaUserQuery = tCriteriaBuilder.createQuery(User.class);
        // Create and add a query root corresponding to the given entity, forming a cartesian product with any existing roots.
        Root<User> root = tCriteriaUserQuery.from(User.class);
        // Specify the item that is to be returned in the query result.
        tCriteriaUserQuery.select(root);
        // Create an instance of TypedQuery for executing a criteria query
        // and then return the query results as a typed List.
        return this.entityManager.createQuery(tCriteriaUserQuery).getResultList();
    }
}
