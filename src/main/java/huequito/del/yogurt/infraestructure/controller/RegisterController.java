package huequito.del.yogurt.infraestructure.controller;

import huequito.del.yogurt.app.service.UsuariosService;
import huequito.del.yogurt.infraestructure.entity.TypeUser;
import huequito.del.yogurt.infraestructure.entity.UsuariosEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UsuariosService usuariosService;

    public RegisterController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("usuario", new UsuariosEntity());
        return "usuarios/register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute UsuariosEntity usuario) {
        usuario.setTypeUser(TypeUser.USER);
        usuariosService.createUser(usuario);
        return "redirect:/login"; // Redirigir al formulario de inicio de sesión tras registrarse
    }
}

