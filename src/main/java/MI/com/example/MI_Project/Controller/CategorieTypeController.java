package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.Repository.CategorieTypeRepository;
import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.entities.CategorieType;
import MI.com.example.MI_Project.services.CategorieTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class CategorieTypeController {
    /*@Autowired
    private CategorieTypeRepository categorieTypeRepository;

    @GetMapping("/categorie-types/{idCategorieMi}")
    public List<CategorieType> findAllByIdCategorieMi(@PathVariable Integer idCategorieMi) {
        return categorieTypeRepository.findAllByIdCategorieMi(idCategorieMi);
    }*/
    @Autowired
    private CategorieTypeServiceImpl categorieTypeService;

    @GetMapping(value = "/categorieType/{id}")
    public List<CategorieTypeMiDto> getTypeMiByIdCategorieMi(@PathVariable Integer id) {
        return categorieTypeService.getAllTypeMiByIdCategorieMi(id);
    }

}
