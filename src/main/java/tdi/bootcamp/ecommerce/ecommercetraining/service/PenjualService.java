package tdi.bootcamp.ecommerce.ecommercetraining.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Penjual;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.PenjualRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PenjualService {

    @Autowired
    private PenjualRepository repository;


    @Transactional
    public Penjual save(Penjual penjual) {
        return repository.save(penjual);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Optional<Penjual> findById(String id){
        return repository.findById(id);
    }

    public Page<Penjual> paginate(Pageable page){
        return repository.findAll(page);
    }

}
