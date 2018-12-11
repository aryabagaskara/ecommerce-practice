package tdi.bootcamp.ecommerce.ecommercetraining.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kategori")
public class Kategori {
    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;
}