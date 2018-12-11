package tdi.bootcamp.ecommerce.ecommercetraining.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    @JoinTable(
            name = "kategori_produk",
            joinColumns = @JoinColumn(name = "produk_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "kategori_id", nullable = false)
    )
    private List<Kategori> daftarKategori = new ArrayList<>();

}
