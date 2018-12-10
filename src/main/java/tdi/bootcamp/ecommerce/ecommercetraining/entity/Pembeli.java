package tdi.bootcamp.ecommerce.ecommercetraining.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pembeli")
public class Pembeli {
    @Id
    @GenericGenerator(name = "uuid_gen",strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id")
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "no_ktp")
    private String noKtp;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "saldo")
    private BigDecimal saldo;


}
