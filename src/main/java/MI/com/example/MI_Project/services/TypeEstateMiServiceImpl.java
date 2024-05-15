package MI.com.example.MI_Project.services;

import MI.com.example.MI_Project.Repository.TypeEstateMiRepository;
import MI.com.example.MI_Project.entities.TypeEstateMi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEstateMiServiceImpl {


    private TypeEstateMiRepository typeEstateMiRepository;
    @Autowired
    public TypeEstateMiServiceImpl(TypeEstateMiRepository typeEstateMiRepository) {
        this.typeEstateMiRepository = typeEstateMiRepository;
    }



}
