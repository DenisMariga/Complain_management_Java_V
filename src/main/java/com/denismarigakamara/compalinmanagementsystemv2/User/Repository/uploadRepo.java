package com.denismarigakamara.compalinmanagementsystemv2.User.Repository;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface uploadRepo extends JpaRepository<Upload , Long> {
List<Upload> findUploadByUsername(String user);
}
