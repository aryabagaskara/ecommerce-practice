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
    public ResponseEntity<?> transaksiPembelian(@RequestBody Transaksi transaksi){
        transaksi = transaksiService.pembelian(transaksi);
        return ResponseEntity.ok(transaksi);
    }
    @GetMapping("/list")
    public Page<Transaksi> pagination(Pageable page){
        return transaksiService.findAll(page);
    }

}
