package tdi.bootcamp.ecommerce.ecommercetraining.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Transaksi;
import tdi.bootcamp.ecommerce.ecommercetraining.service.TransaksiService;


@RestController
@RequestMapping("/api/transaksi")
public class TransaksiApi {

    @Autowired
    private TransaksiService transaksiService;

    @PostMapping("/pembelian")
    public ResponseEntity<?> transaksiPembelian(@RequestBody Transaksi transaksi) {
        transaksi = transaksiService.pembelian(transaksi);
//
//        Optional<Produk> produkOptional = produkService.findById(transaksi.getProduk().getId());
//        if (!produkOptional.isPresent()) return ResponseEntity.noContent().build();
//        else {
//            Produk produk1 = produkOptional.get();
//            BigDecimal biaya = produk1.getHarga().multiply(BigDecimal.valueOf(transaksi.getQty()));
//            transaksi.setBiaya(biaya);
//            Optional<Pembeli> pembeliOptional = pembeliService.findById(transaksi.getPembeli().getId());
//            if (!pembeliOptional.isPresent()) return ResponseEntity.noContent().build();
//            else {
//                Pembeli pembeli1 = pembeliOptional.get();
//                transaksi.getPembeli().setSaldo(pembeli1.getSaldo().subtract(biaya));
//            }
//            Optional<Penjual> penjualOptional = penjualService.findById(produk1.getPenjual().getId());
//            if (!penjualOptional.isPresent()) return ResponseEntity.noContent().build();
//            else {
//                Penjual penjual1 = penjualOptional.get();
//                BigDecimal deposit = penjual1.getDeposit();
//                deposit = deposit.add(biaya);
//                penjual1.setDeposit(deposit);
//                transaksi.getProduk().setPenjual(penjual1);
//            }
//        }

        return ResponseEntity.ok(transaksi);

    }


    @GetMapping("/list")
    public Page<Transaksi> pagination(Pageable page) {
        return transaksiService.findAll(page);
    }


}
