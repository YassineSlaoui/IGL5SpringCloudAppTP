package tn.rnu.fst.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.fst.userservice.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

