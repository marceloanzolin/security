package anzolin.marcelo.security.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        if(product.getId() != null){
            throw new RuntimeException("Já existe um produto com este ID");
        }
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if(product.getId() == null){
            throw new RuntimeException("Id não informado");
        }
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
