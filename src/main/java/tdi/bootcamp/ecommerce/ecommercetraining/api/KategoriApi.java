package tdi.bootcamp.ecommerce.ecommercetraining.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Kategori;
import tdi.bootcamp.ecommerce.ecommercetraining.service.KategoriService;

@RestController
@RequestMapping("/api/kategori")
public class KategoriApi {

    @Autowired
    private KategoriService service;

    @GetMapping("/list")
    public Page<Kategori> list(Pageable page) {
        return service.paginate(page);
    }

    @PostMapping("/save")
    public ResponseEntity<Kategori> save(@RequestBody Kategori kategori) {
        kategori = service.save(kategori);
        return ResponseEntity.ok(kategori);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
