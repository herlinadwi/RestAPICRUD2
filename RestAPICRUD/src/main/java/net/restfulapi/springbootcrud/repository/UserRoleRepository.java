package net.restfulapi.springbootcrud.repository;

import net.restfulapi.springbootcrud.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query(value = "select distinct a from user_role as a " +
            "inner join users as b on a.user_id = b.users_id " +
            "inner join roles as c on a.role_id = c.role_id" +
            "where b.username = :username", nativeQuery = true)
    UserRole findByRoleAndUser(@Param("username") String username);

}
