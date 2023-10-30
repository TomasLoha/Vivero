package controllers;

import com.spd.vivero.Producto;
import repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> findAllProducts() {
        return productoRepository.findAll();
    }

    // Guardar un producto
    @PostMapping
    public Producto saveProduct(@Validated @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener un producto por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> findProductById(@PathVariable(value = "id") Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    // Actualizar un producto por id
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProduct(@PathVariable(value = "id") Integer idProducto,
            @Validated @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        producto.setNombreProducto(productoDetails.getNombreProducto());
        producto.setTipoProducto(productoDetails.getTipoProducto());
        producto.setPrecioProducto(productoDetails.getPrecioProducto());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setCaracteristicas(productoDetails.getCaracteristicas());
        Producto updatedProduct = productoRepository.save(producto);
        return ResponseEntity.ok(updatedProduct);
    }

    // Eliminar un producto por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProduct(@PathVariable(value = "id") Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        productoRepository.delete(producto);
        return ResponseEntity.ok(producto);
    }
}