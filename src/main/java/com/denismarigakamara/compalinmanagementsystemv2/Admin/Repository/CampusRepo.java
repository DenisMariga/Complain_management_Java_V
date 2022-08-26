package com.denismarigakamara.compalinmanagementsystemv2.Admin.Repository;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepo extends JpaRepository<Campus, Long> {
}
