package huequito.del.yogurt.infraestructure.adapter;

import huequito.del.yogurt.infraestructure.entity.UsuariosEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosCrudRepository extends CrudRepository<UsuariosEntity, Integer>{
    //METODO ADICIONAL NO TIENE EL CRUD REPOSITORY
    public Optional<UsuariosEntity> findByEmail(String email);
    
}
