package huequito.del.yogurt.app.service;

import huequito.del.yogurt.app.repository.ProductoRepository;
import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import huequito.del.yogurt.infraestructure.entity.ProductoEntity;
import java.util.List;

public class ProductoService {
    
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public List<ProductoEntity> getProductos(){
        return productoRepository.getProductos();
    }

    public ProductoEntity getProductoById(Integer id){
        return productoRepository.getProductoById(id);
    }

    public ProductoEntity saveProducto(ProductoEntity productoEntity){
        return productoRepository.saveProducto(productoEntity);
    }

    public List<ProductoEntity> getProductsByCategory(Integer categoriaId){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(categoriaId);
        return productoRepository.findByCategoria(categoria);
    }

    public boolean deleteProductoById(Integer id){
        return productoRepository.deleteProductoById(id);
    }
}
