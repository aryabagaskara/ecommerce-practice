package tdi.bootcamp.ecommerce.ecommercetraining.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Produk;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.ProdukRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class ProdukService {

    @Autowired
    private ProdukRepository repository;

    @Transactional
    public Produk save(Produk produk){
        return repository.save(produk);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Optional<Produk> findById(String id){
        return repository.findById(id);
    }

    public Page<Produk> paginate(Pageable page){
        return repository.findAll(page);
    }

    public Page<Produk> findByPenjual_PenjualId(String id, Pageable pageable){
        return (Page<Produk>) repository.findByPenjual_Id(id, pageable);
    }


}
