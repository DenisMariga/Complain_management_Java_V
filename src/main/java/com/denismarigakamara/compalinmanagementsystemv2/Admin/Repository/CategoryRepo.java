package com.denismarigakamara.compalinmanagementsystemv2.Admin.Repository;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
  List<Category> findCategoryByUsername(String username);
}
