package com.denismarigakamara.compalinmanagementsystemv2.User.Entity;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Auditable;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Complain extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String natureComplain;
    private String ComplaintDetails;
    private String Solution;
    @ManyToOne
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private Category category;
    private Long categoryid;
    @ManyToOne
    @JoinColumn(name = "subcategoryid", insertable = false, updatable = false)
    private SubCategory subCategory;
    private Long subcategoryid;
    private Campuses campuses;
    private ComplainType complainType;
    private String username;


}
