package tdi.bootcamp.ecommerce.ecommercetraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Pembeli;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Penjual;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Produk;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Transaksi;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.PembeliRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.PenjualRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.ProdukRepository;
import tdi.bootcamp.ecommerce.ecommercetraining.repository.TransaksiRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class TransaksiService {

    @Autowired
    private TransaksiRepository repository;
    @Autowired
    private ProdukRepository produkRepository;
    @Autowired
    private PenjualRepository penjualRepository;
    @Autowired
    private PembeliRepository pembeliRepository;

    @Transactional
    public Transaksi pembelian(Transaksi transaksi) {
        transaksi.setTanggalTransaksi(Date.valueOf(LocalDate.now()));
        //set biaya
        Optional<Produk> produkOptional = produkRepository.findById(transaksi.getProduk().getId());
        if (produkOptional.isPresent()) {
            Produk produk1 = produkOptional.get();
            BigDecimal biaya = produk1.getHarga().multiply(BigDecimal.valueOf(transaksi.getQty()));
            transaksi.setBiaya(biaya);
            Optional<Pembeli> pembeliOptional = pembeliRepository.findById(transaksi.getPembeli().getId());
            if (pembeliOptional.isPresent()) {
                Pembeli pembeli1 = pembeliOptional.get();
                BigDecimal saldo = pembeli1.getSaldo();
                saldo = saldo.subtract(biaya);
                pembeli1.setSaldo(saldo);
                transaksi.setPembeli(pembeli1);
            }
            Optional<Penjual> penjualOptional = penjualRepository.findById(produk1.getPenjual().getId());
            if (penjualOptional.isPresent()) {
                Penjual penjual1 = penjualOptional.get();
                BigDecimal deposit = penjual1.getDeposit();
                deposit = deposit.add(biaya);
                penjual1.setDeposit(deposit);
                transaksi.getProduk().setPenjual(penjual1);
            }
        }

        return repository.save(transaksi);
    }

    public Optional<Transaksi> findById(String id) {
        return repository.findById(id);
    }

    public Page<Transaksi> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Iterable<Transaksi> list() {
        return repository.findAll();
    }

    public List<Transaksi> findAll(){
        return (List<Transaksi>) repository.findAll();
    }

    public Page<Transaksi> findByPembeli_Id(String id, Pageable pageable) {
        return (Page<Transaksi>) repository.findByPembeli_Id(id, pageable);
    }

    public Page<Transaksi> findByProduk_Id(String id, Pageable pageable) {
        return (Page<Transaksi>) repository.findByProduk_Id(id,pageable);
    }


}

