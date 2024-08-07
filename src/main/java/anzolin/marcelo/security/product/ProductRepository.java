package anzolin.marcelo.security.product;

import anzolin.marcelo.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
