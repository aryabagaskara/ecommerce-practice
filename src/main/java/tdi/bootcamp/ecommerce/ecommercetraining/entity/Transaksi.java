package tdi.bootcamp.ecommerce.ecommercetraining.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id")
    private String id;

    @Column(name = "tanggal_transaksi")
    private Date tanggalTransaksi;

    @ManyToOne
    @JoinColumn(name = "produk_id")
    private Produk produk;

    @ManyToOne
    @JoinColumn(name = "pembeli_id")
    private Pembeli pembeli;

    @Column(name = "qty")
    private int qty;

    @Column(name = "biaya")
    private BigDecimal biaya;

}
