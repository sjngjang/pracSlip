package net.sj.slipp.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sj.slipp.web.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
