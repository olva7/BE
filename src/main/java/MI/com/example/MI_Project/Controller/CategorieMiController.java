package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.CategorieType;
import MI.com.example.MI_Project.services.CategorieMiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategorieMiController {
    private final CategorieMiService categorieMiService;

    @Autowired
    public CategorieMiController(CategorieMiService categorieMiService) {
        this.categorieMiService = categorieMiService;
    }

    @GetMapping
    public ResponseEntity<List<CategorieMi>> getAllCategories() {
        List<CategorieMi> categories = categorieMiService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getCategorieMiById(@PathVariable Integer id) {
        String categorieMi = categorieMiService.findCategorieMiById(id);
        if (categorieMi != null) {
            return ResponseEntity.ok(categorieMi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
