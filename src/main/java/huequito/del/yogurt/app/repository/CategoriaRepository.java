package huequito.del.yogurt.app.repository;

import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import java.util.List;

public interface CategoriaRepository {

    List<CategoriaEntity> getCategorias();

    CategoriaEntity getCategoriaById(Integer id);

    CategoriaEntity saveCategoria(CategoriaEntity categoriaEntity);

    boolean deleteCategoriaById(Integer id);
}
