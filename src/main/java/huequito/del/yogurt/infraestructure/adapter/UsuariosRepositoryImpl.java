package huequito.del.yogurt.infraestructure.adapter;

import huequito.del.yogurt.app.repository.UsuariosRepository;
import huequito.del.yogurt.infraestructure.entity.UsuariosEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosRepositoryImpl implements UsuariosRepository{
    
    private final UsuariosCrudRepository userCrudRepository;

    public UsuariosRepositoryImpl(UsuariosCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public Iterable<UsuariosEntity> getUsers() {
        return userCrudRepository.findAll();
    }
    
    @Override
    public UsuariosEntity createUser(UsuariosEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public UsuariosEntity findByEmail(String email) {
     return userCrudRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UsuariosEntity findById(Integer id) {
        return userCrudRepository.findById(id).get();
    }
}
