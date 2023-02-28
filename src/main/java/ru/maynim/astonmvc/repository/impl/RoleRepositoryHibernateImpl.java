package ru.maynim.astonmvc.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.maynim.astonmvc.entity.Role;
import ru.maynim.astonmvc.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Component
public class RoleRepositoryHibernateImpl implements RoleRepository {

    private final SessionFactory sessionFactory;

    public RoleRepositoryHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Role> findAllWithUsers() {
        List<Role> findRoleList;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            findRoleList = session.createQuery("select r from Role r join fetch r.users", Role.class)
                    .getResultList();

            session.getTransaction().commit();
        }

        return findRoleList;
    }

    @Override
    public Optional<Role> findById(long id) {
        Role findRole;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            findRole = session.get(Role.class, id);

            session.getTransaction().commit();
        }

        return Optional.ofNullable(findRole);
    }

    @Override
    public int update(long id, Role role) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();

                int updatedRows = session.createQuery(
                                "update Role r " +
                                        "set name = :name, " +
                                        "description = :description " +
                                        "where r.id = :id"
                        )
                        .setParameter("name", role.getName())
                        .setParameter("description", role.getDescription())
                        .setParameter("id", id)
                        .executeUpdate();

                session.getTransaction().commit();

                return updatedRows;
            } catch (Exception e) {
                session.getTransaction().rollback();

                throw e;
            }
        }
    }

    @Override
    public void deleteById(long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();

                session.createQuery("delete Role r where r.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();

                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();

                throw e;
            }
        }
    }

    @Override
    public void save(Role role) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();

                session.save(role);

                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();

                throw e;
            }
        }
    }

    @Override
    public List<Role> findAll() {
        List<Role> findRoleList;
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            findRoleList = session.createQuery("select r from Role r", Role.class).getResultList();

            session.getTransaction().commit();
        }
        return findRoleList;
    }
}
