package com.denismarigakamara.compalinmanagementsystemv2.User.Repository;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface complain extends JpaRepository<Complain, Long> {
    List<Complain> findComplainByUsername(String user);
}
