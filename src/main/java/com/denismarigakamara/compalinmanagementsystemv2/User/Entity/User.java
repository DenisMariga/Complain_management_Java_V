package com.denismarigakamara.compalinmanagementsystemv2.User.Entity;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "First Name is Mandatory")
    private String FirstName;
    @NotEmpty(message = "Last Name is Mandatory")
    private String LastName;
    @Email
    @Column(nullable = false, unique = true)
    private String username;
    //@Size(min = 6, max =12)
    //@Pattern(regexp = " (^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{6,12}$)")
   //private Campuses campuses;
    // @NotEmpty(message = "Password is Mandatory")
    private String Password;
    @NotEmpty(message = "Country is Mandatory")
    private String Country;
    @NotEmpty(message = "Address is Mandatory")
    private String Address;
//    @NotBlank(message = "Phone is Mandatory")
    private Long Phone;

}
