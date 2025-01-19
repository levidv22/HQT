package huequito.del.yogurt.infraestructure.adapter;

import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import huequito.del.yogurt.infraestructure.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<ProductoEntity, Integer> {

    // Método para obtener productos por categoría
    List<ProductoEntity> findByCategoria(CategoriaEntity categoria);
}