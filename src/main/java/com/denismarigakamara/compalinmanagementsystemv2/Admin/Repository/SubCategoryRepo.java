package com.denismarigakamara.compalinmanagementsystemv2.Admin.Repository;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Long> {
    List<SubCategory>findSubCategoryByUsername(String username);
}
