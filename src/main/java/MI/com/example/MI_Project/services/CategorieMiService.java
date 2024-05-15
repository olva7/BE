package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.CategorieMiRepository;
import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.CategorieType;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    }




