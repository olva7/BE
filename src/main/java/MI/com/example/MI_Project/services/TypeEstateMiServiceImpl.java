package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.TypeEstateMiRepository;
import MI.com.example.MI_Project.dto.Mapper.CategorieTypeMiMapper;
import MI.com.example.MI_Project.dto.Mapper.TypeEstateMiMapper;
import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.dto.Model.TypeEstateMiDto;
import MI.com.example.MI_Project.entities.CategorieMi;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeEstateMiServiceImpl {


    private TypeEstateMiRepository typeEstateMiRepository;
    @Autowired
    public TypeEstateMiServiceImpl(TypeEstateMiRepository typeEstateMiRepository) {
        this.typeEstateMiRepository = typeEstateMiRepository;
    }
    public List<TypeEstateMiDto> getTypeMiById(Integer id) {

        return typeEstateMiRepository
                .findById(id).stream()
                .map(TypeEstateMiMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    public String findTypeEstateMiById(Integer id) {
        Optional<TypeEstateMi> result = typeEstateMiRepository.findById(id);
        return result.map(TypeEstateMi::getTypeEstate).orElse(null);  // Retourne le type de la catégorie ou null si non trouvé
    }


}
