package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.CategorieMiRepository;
import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.CategorieType;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieMiService {


    private final CategorieMiRepository categorieMiRepository;

    @Autowired
    public CategorieMiService(CategorieMiRepository categorieMiRepository) {
        this.categorieMiRepository = categorieMiRepository;
    }
    public List<CategorieMi> getAllCategories() {
        return categorieMiRepository.findAll();
    }

    public String findCategorieMiById(Integer id) {
        Optional<CategorieMi> result = categorieMiRepository.findById(id);
        return result.map(CategorieMi::getCategorieMi).orElse(null);  // Retourne le type de la catégorie ou null si non trouvé
    }


}




