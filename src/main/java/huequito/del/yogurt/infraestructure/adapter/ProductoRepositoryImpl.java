package huequito.del.yogurt.infraestructure.adapter;

import huequito.del.yogurt.app.repository.ProductoRepository;
import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import huequito.del.yogurt.infraestructure.entity.ProductoEntity;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private final ProductoCrudRepository productoCrudRepository;

    public ProductoRepositoryImpl(ProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    @Override
    public List<ProductoEntity> getProductos() {
        return (List<ProductoEntity>) productoCrudRepository.findAll();
    }

    @Override
    public ProductoEntity getProductoById(Integer id) {
        return productoCrudRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoEntity saveProducto(ProductoEntity productoEntity) {
        return productoCrudRepository.save(productoEntity);
    }

    @Override
    public List<ProductoEntity> findByCategoria(CategoriaEntity categoria) {
        return productoCrudRepository.findByCategoria(categoria);
    }

    @Override
    @Transactional
    public boolean deleteProductoById(Integer id) {
        if (productoCrudRepository.existsById(id)) {
            productoCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
