package tdi.bootcamp.ecommerce.ecommercetraining.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Kategori;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.KategoriRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class KategoriService {

    @Autowired
    private KategoriRepository repository;

    @Transactional
    public Kategori save(Kategori kategori){
        return repository.save(kategori);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Optional<Kategori> findById(String id){
        return repository.findById(id);
    }

    public Page<Kategori> paginate(Pageable page){
        return repository.findAll(page);
    }
}
