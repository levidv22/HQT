package huequito.del.yogurt.app.repository;

import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import huequito.del.yogurt.infraestructure.entity.ProductoEntity;
import java.util.List;

public interface ProductoRepository {

    List<ProductoEntity> getProductos();

    ProductoEntity getProductoById(Integer id);

    ProductoEntity saveProducto(ProductoEntity productoEntity);

    List<ProductoEntity> findByCategoria(CategoriaEntity categoria);

    boolean deleteProductoById(Integer id);
}
