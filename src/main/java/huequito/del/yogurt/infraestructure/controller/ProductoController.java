package huequito.del.yogurt.infraestructure.controller;

import huequito.del.yogurt.app.service.CategoriaService;
import huequito.del.yogurt.app.service.ProductoService;
import huequito.del.yogurt.infraestructure.entity.CategoriaEntity;
import huequito.del.yogurt.infraestructure.entity.ProductoEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    // Ruta para mostrar productos (tanto para clientes autenticados como no autenticados)
    @GetMapping
    public String showIndex(Model model, HttpSession session) {
        Iterable<ProductoEntity> products = productoService.getProductos();
        // Obtener todas las categorías para los botones
        Iterable<CategoriaEntity> categories = categoriaService.getCategorias();
        // Añadir productos y categorías al modelo
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        return "productos/lista"; // Redirigir a la vista index.html
    }

    // Mostrar el formulario para crear un producto
    @GetMapping("/crear")
    public String showCreateForm(Model model) {
        // Obtener las categorías para llenar el select del formulario
        Iterable<CategoriaEntity> categories = categoriaService.getCategorias();
        model.addAttribute("categories", categories);
        model.addAttribute("producto", new ProductoEntity());
        return "productos/crear";
    }

// Procesar la creación de un producto
    @PostMapping("/crear")
    public String createProducto(@ModelAttribute ProductoEntity producto) {
        productoService.saveProducto(producto);
        return "redirect:/productos"; // Redirige a la lista de productos
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.deleteProductoById(id);
        return "redirect:/productos";
    }
}
