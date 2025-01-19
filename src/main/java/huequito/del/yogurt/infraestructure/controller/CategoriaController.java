package huequito.del.yogurt.infraestructure.controller;

import huequito.del.yogurt.app.service.CategoriaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @DeleteMapping("/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoriaById(id);
        return "redirect:/categorias";
    }
}
