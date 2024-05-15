package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.CategorieTypeRepository;
import MI.com.example.MI_Project.dto.Mapper.CategorieTypeMiMapper;
import MI.com.example.MI_Project.dto.Model.CategorieTypeMiDto;
import MI.com.example.MI_Project.entities.CategorieType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieTypeServiceImpl {


    private final CategorieTypeRepository categorieTypeRepository;

    @Autowired
    public CategorieTypeServiceImpl(CategorieTypeRepository categorieTypeRepository) {
        this.categorieTypeRepository = categorieTypeRepository;
    }

   /* public List<CategorieType> findAllByIdCategorieMi(Integer idCategorieMi) {
        return categorieTypeRepository.findAllByIdCategorieMi(idCategorieMi);
    }*/
  /* public List<CategorieType> findAllByIdCategorieMi(Integer idCategorie) {
       return categorieTypeRepository.findAllByIdCategorieMi(idCategorie);
   }
    public List<CategorieTypeMiDto> findAllByIdCategorieMi(Integer idCategorie) {
        List<CategorieType> categorieTypes = categorieTypeRepository.findAllByIdCategorieMi(idCategorie);
        return categorieTypes.stream()
                .map(CategorieTypeMiMapper::maptoDto)
                .collect(Collectors.toList());
    }*/

    public List<CategorieTypeMiDto> getAllTypeMiByIdCategorieMi(Integer id) {

        return categorieTypeRepository
                .findAllByIdCategorieMi(id).stream()
                .map(CategorieTypeMiMapper::maptoDto)
                .collect(Collectors.toList());
    }

}
