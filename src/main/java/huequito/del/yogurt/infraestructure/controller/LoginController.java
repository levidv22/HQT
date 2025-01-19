package huequito.del.yogurt.infraestructure.controller;

import huequito.del.yogurt.app.service.UsuariosService;
import huequito.del.yogurt.infraestructure.entity.TypeUser;
import huequito.del.yogurt.infraestructure.entity.UsuariosEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UsuariosService usuariosService;

    public LoginController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("usuario", new UsuariosEntity());
        return "usuarios/login";
    }

    @PostMapping
    public String loginUser(@ModelAttribute UsuariosEntity usuario, HttpSession session) {
        UsuariosEntity existingUser = usuariosService.findByEmail(usuario.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(usuario.getPassword())) {
            session.setAttribute("loggedInUser", existingUser);

            // Redirigir según el tipo de usuario
            if (existingUser.getTypeUser() == TypeUser.ADMIN) {
                return "redirect:/productos"; // Redirigir a la ruta del administrador
            } else if (existingUser.getTypeUser() == TypeUser.USER) {
                return "redirect:/productos"; // Redirigir a la vista de productos
            }
        }

        // Redirigir con error si las credenciales son incorrectas
        return "redirect:/login?error=true";
    }
}
