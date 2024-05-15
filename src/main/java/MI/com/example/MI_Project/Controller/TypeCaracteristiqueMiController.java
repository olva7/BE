package MI.com.example.MI_Project.Controller;

import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.dto.Model.TypeCaracteristiqueMiDto;
import MI.com.example.MI_Project.services.TypeCaracteristiqueMiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
public class TypeCaracteristiqueMiController {


    private final TypeCaracteristiqueMiService typeCaracteristiqueMiService;

    @Autowired
    public TypeCaracteristiqueMiController(TypeCaracteristiqueMiService typeCaracteristiqueMiService) {
        this.typeCaracteristiqueMiService = typeCaracteristiqueMiService;
    }



    @GetMapping(value = "/caracteristiqueType/{id}")
    public List<TypeCaracteristiqueMiDto> getTypeMiByIdCaracteristiqueMi(@PathVariable Integer id) {
        return typeCaracteristiqueMiService.getAllTypeMiByIdCaracteristique(id);
    }
}
