package huequito.del.yogurt.infraestructure.config;

import huequito.del.yogurt.app.repository.CategoriaRepository;
import huequito.del.yogurt.app.repository.ProductoRepository;
import huequito.del.yogurt.app.repository.UsuariosRepository;
import huequito.del.yogurt.app.service.CategoriaService;
import huequito.del.yogurt.app.service.ProductoService;
import huequito.del.yogurt.app.service.UsuariosService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    
    @Bean
    public CategoriaService categoriaService(CategoriaRepository categoriaRepository) {
        return new CategoriaService(categoriaRepository);
    }

    @Bean
    public ProductoService productoService(ProductoRepository productoRepository) {
        return new ProductoService(productoRepository);
    }
    
    @Bean
    public UsuariosService userService(UsuariosRepository userRepository) {
        return new UsuariosService(userRepository);
    }

}
