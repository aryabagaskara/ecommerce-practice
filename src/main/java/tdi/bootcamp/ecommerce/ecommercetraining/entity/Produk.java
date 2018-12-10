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
@Table(name = "produk")
public class Produk {


    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id")
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "harga")
    private BigDecimal harga;

    @ManyToOne
    @JoinColumn(name = "penjual_id")
    private Penjual penjual;

}
