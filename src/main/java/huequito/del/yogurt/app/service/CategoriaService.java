package huequito.del.yogurt.app.service;

import huequito.del.yogurt.app.repository.CategoriaRepository;
import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import java.util.List;


public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    public List<CategoriaEntity> getCategorias(){
        return categoriaRepository.getCategorias();
    }

    public CategoriaEntity getCategoriaById(Integer id){
        return categoriaRepository.getCategoriaById(id);
    }

    public CategoriaEntity saveCategoria(CategoriaEntity categoriaEntity){
        return categoriaRepository.saveCategoria(categoriaEntity);
    }

    public boolean deleteCategoriaById(Integer id){
        return categoriaRepository.deleteCategoriaById(id);
    }
}
