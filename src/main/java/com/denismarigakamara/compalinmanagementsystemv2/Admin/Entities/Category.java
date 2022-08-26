package com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Complain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Category extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String categoryName;
    private String Description;
    @OneToMany(mappedBy = "category")
    private List<SubCategory>subCategoryList;
    @OneToMany(mappedBy = "category")
    private List<Complain>complainList;
    private String username;
}
