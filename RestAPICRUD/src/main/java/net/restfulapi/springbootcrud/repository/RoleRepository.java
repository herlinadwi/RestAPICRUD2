package net.restfulapi.springbootcrud.repository;

import net.restfulapi.springbootcrud.model.Role;
import net.restfulapi.springbootcrud.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<String> findByName(String name);
}
