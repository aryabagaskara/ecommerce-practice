package tdi.bootcamp.ecommerce.ecommercetraining.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Penjual;
import tdi.bootcamp.ecommerce.ecommercetraining.service.PenjualService;

@RestController
@RequestMapping("/api/penjual")
public class PenjualApi {

    @Autowired
    private PenjualService service;

    @PostMapping("/save")
    public ResponseEntity<Penjual> save(@RequestBody  Penjual penjual){
        penjual = service.save(penjual);
        return ResponseEntity.ok(penjual);
    }


    @GetMapping("/list")
    public Page<Penjual> pagination(Pageable page){
        return service.paginate(page);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("penjualId") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
