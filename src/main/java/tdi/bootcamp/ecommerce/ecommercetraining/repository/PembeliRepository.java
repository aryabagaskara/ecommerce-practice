package tdi.bootcamp.ecommerce.ecommercetraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Pembeli;

public interface PembeliRepository extends PagingAndSortingRepository<Pembeli,String> {
}
