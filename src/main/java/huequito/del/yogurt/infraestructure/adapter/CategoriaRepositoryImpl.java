package huequito.del.yogurt.infraestructure.adapter;

import huequito.del.yogurt.app.repository.CategoriaRepository;
import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final CategoriaCrudRepository categoriaCrudRepository;

    public CategoriaRepositoryImpl(CategoriaCrudRepository categoriaCrudRepository) {
        this.categoriaCrudRepository = categoriaCrudRepository;
    }

    @Override
    public List<CategoriaEntity> getCategorias() {
        return (List<CategoriaEntity>) categoriaCrudRepository.findAll();
    }

    @Override
    public CategoriaEntity getCategoriaById(Integer id) {
        return categoriaCrudRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriaEntity saveCategoria(CategoriaEntity categoriaEntity) {
        return categoriaCrudRepository.save(categoriaEntity);
    }

    @Override
    @Transactional
    public boolean deleteCategoriaById(Integer id) {
        if (categoriaCrudRepository.existsById(id)) {
            categoriaCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
