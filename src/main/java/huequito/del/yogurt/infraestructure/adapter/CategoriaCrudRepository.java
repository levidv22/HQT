package huequito.del.yogurt.infraestructure.adapter;

import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaCrudRepository extends CrudRepository<CategoriaEntity, Integer> {

}