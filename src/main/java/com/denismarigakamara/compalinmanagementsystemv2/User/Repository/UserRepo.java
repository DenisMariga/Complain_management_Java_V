package com.denismarigakamara.compalinmanagementsystemv2.User.Repository;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo  extends JpaRepository<User,Long> {
    User findByUsername(String username);
    List<User> findUserByUsername(String username);
}
