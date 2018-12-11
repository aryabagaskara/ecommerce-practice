package tdi.bootcamp.ecommerce.ecommercetraining.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Transaksi;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, String> {

    Page<Transaksi> findByPembeli_Id(String Id, Pageable pageable);
    Page<Transaksi> findByProduk_Id(String Id, Pageable pageable);
}
