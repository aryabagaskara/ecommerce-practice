package tdi.bootcamp.ecommerce.ecommercetraining.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Penjual;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Produk;

import java.util.List;

public interface PenjualRepository extends PagingAndSortingRepository<Penjual,String> {

}
