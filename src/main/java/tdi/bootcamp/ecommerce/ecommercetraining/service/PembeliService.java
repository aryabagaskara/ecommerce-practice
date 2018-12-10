package tdi.bootcamp.ecommerce.ecommercetraining.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Pembeli;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.PembeliRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PembeliService {

    @Autowired
    private PembeliRepository repository;

    @Transactional
    public Pembeli save(Pembeli pembeli){
        return repository.save(pembeli);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Optional<Pembeli> findById(String id){
        return repository.findById(id);
    }

    public Page<Pembeli> paginate(Pageable page){
        return repository.findAll(page);
    }

}
