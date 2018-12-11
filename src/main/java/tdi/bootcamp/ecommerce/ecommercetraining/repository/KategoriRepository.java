package tdi.bootcamp.ecommerce.ecommercetraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Kategori;

public interface KategoriRepository extends PagingAndSortingRepository<Kategori, String> {
}
