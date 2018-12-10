package tdi.bootcamp.ecommerce.ecommercetraining.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Pembeli;
import tdi.bootcamp.ecommerce.ecommercetraining.service.PembeliService;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/pembeli")
public class PembeliApi {

    @Autowired
    private PembeliService service;

    @PostMapping("/save")
    public ResponseEntity<Pembeli> save(@RequestBody Pembeli pembeli) {
        pembeli = service.save(pembeli);
        return ResponseEntity.ok(pembeli);
    }

    @GetMapping("/list")
    public Page<Pembeli> pagination(Pageable page) {
        return service.paginate(page);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("pembeliId") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addsaldo")
    public ResponseEntity<Pembeli> addsaldo(@RequestParam("pembeliId") String id,
                                            @RequestParam("pembeliSaldo") BigDecimal saldo) {
        Optional<Pembeli> pembeliOptional = service.findById(id);
        if (!pembeliOptional.isPresent()) return ResponseEntity.noContent().build();
        else {
            Pembeli pembeli1 = pembeliOptional.get();
            BigDecimal saldo1 = new BigDecimal(String.valueOf(pembeli1.getSaldo()));
            saldo1 = saldo1.add(saldo);
            pembeli1.setSaldo(saldo1);
            service.save(pembeli1);
            return ResponseEntity.ok(pembeli1);
        }
    }


}
