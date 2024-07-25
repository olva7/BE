package MI.com.example.MI_Project.Controller;



import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.dto.Model.TypeEstateMiDto;
import MI.com.example.MI_Project.services.TypeEstateMiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TypeEstateMiController {
    @Autowired
    private TypeEstateMiServiceImpl typeEstateMiService;
    @GetMapping(value = "typeMi/{id}")
    public List<TypeEstateMiDto> getTypeMiByIdCategorieMi(@PathVariable Integer id) {
        return typeEstateMiService.getTypeMiById(id);
    }
    @GetMapping("type_estate/{id}")
    public ResponseEntity<String> getTypeEstateMiById(@PathVariable Integer id) {
        String categorieMi = typeEstateMiService.findTypeEstateMiById(id);
        if (categorieMi != null) {
            return ResponseEntity.ok(categorieMi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }










}
