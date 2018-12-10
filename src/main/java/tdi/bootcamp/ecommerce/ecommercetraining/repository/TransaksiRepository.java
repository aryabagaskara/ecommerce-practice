package tdi.bootcamp.ecommerce.ecommercetraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Transaksi;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi,String> {
}
