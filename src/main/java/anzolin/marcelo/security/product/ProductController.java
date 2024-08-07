package anzolin.marcelo.security.product;

import anzolin.marcelo.security.product.Product;
import anzolin.marcelo.security.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')") //serve para verficação de permissão
    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id) { //requestParam ?id=123 se fosse paathVariable serioa itens/123
        productService.delete(id);
    }

}
