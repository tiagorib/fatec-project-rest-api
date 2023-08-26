package br.com.fatec.FatecProjectRestAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "first_name_customer", nullable = false, length = 300)
    private String firstNameCustomer;

    @Column(name = "last_name_customer", nullable = false, length = 300)
    private String lastNameCustomer;

    @Column(name = "cpf_customer", unique = true, nullable = false, length = 11)
    private String cpfCustomer;

    @Column(name = "birthdate_customer", nullable = false)
    private LocalDate birthdateCustomer;

    @Column(name = "date_created_customer", nullable = false, updatable = false)
    private LocalDate dateCreatedCustomer;

    @Column(name = "monthly_income_customer", nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyIncomeCustomer;

    @Column(name = "status_customer", nullable = false)
    private Boolean statusCustomer;

    @Column(name = "email_customer", unique = true, nullable = false, length = 300)
    private String emailCustomer;

    @Column(name = "password_customer", nullable = false, length = 3000)
    private String passwordCustomer;

    @PrePersist
    private void prePersist() {
        this.setDateCreatedCustomer(LocalDate.now());
        this.setStatusCustomer(true);
    }
    
}