package huequito.del.yogurt.app.repository;

import huequito.del.yogurt.infraestructure.entity.UsuariosEntity;

public interface UsuariosRepository {
     //crear un nuevo usuario
    Iterable<UsuariosEntity> getUsers();
    public UsuariosEntity createUser(UsuariosEntity userEntity);
    public UsuariosEntity findByEmail(String email);
    public UsuariosEntity findById(Integer id);
    
    
}

