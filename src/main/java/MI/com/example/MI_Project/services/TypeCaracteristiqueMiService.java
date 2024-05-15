package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.TypeCaracteristiqueMiRepository;

import MI.com.example.MI_Project.dto.Mapper.TypeCaracteristiqueMiMapper;

import MI.com.example.MI_Project.dto.Model.TypeCaracteristiqueMiDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeCaracteristiqueMiService {




    private final TypeCaracteristiqueMiRepository typeCaracteristiqueMi;

    @Autowired
    public TypeCaracteristiqueMiService(TypeCaracteristiqueMiRepository typeCaracteristiqueMi) {
        this.typeCaracteristiqueMi = typeCaracteristiqueMi;
    }





    public List<TypeCaracteristiqueMiDto> getAllTypeMiByIdCaracteristique(Integer id) {

        return typeCaracteristiqueMi
                .findAllByIdCaracteristique(id).stream()
                .map(TypeCaracteristiqueMiMapper::maptoDto)
                .collect(Collectors.toList());
    }

}
