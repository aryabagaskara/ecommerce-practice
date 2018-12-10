package tdi.bootcamp.ecommerce.ecommercetraining.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Produk;
import tdi.bootcamp.ecommerce.ecommercetraining.service.ProdukService;

@RestController
@RequestMapping("/api/produk")
public class ProdukApi {

    @Autowired
    public ProdukService service;

    @PostMapping("/save")
    public ResponseEntity<Produk> save(@RequestBody  Produk produk){
        produk = service.save(produk);
        return ResponseEntity.ok(produk);
    }


    @GetMapping("/list")
    public Page<Produk> pagination(Pageable page){
        return service.paginate(page);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("produkId") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
