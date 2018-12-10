package tdi.bootcamp.ecommerce.ecommercetraining.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Produk;

public interface ProdukRepository extends PagingAndSortingRepository<Produk, String> {

    Page<Produk> findByPenjual_Id(String Id, Pageable pageable);


}
