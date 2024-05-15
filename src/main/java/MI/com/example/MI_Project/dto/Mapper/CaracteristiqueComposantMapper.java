package MI.com.example.MI_Project.dto.Mapper;

import MI.com.example.MI_Project.dto.Model.CaracteristiqueComposantDto;
import MI.com.example.MI_Project.entities.CaracteristiqueComposant;

public class CaracteristiqueComposantMapper {
    public static CaracteristiqueComposantDto mapToDTO(CaracteristiqueComposant caracteristiqueComposant) {

        if (caracteristiqueComposant != null) {


            return new CaracteristiqueComposantDto()
                    .setIdCaracteristiqueComposant(caracteristiqueComposant.getIdCaracteristiqueComposant())
                    //.setIdTypeComposant(caracteristiqueComposant.getIdTypeComposant())
                    //.setTypeComposantTag(caracteristiqueComposant.getTypeComposantTag())
                    .setLargeurComposant(caracteristiqueComposant.getLargeurComposant())
                    .setLongueurComposant(caracteristiqueComposant.getLongueurComposant())
                    .setSurface(caracteristiqueComposant.getIdEstate().getSurfacieEnM())

                    .setIdEstate(EstateMiMapper.mapToDTO(caracteristiqueComposant.getIdEstate()))
                    .setIdFormeComposant(FormeComposantMiMapper.mapToDTO(caracteristiqueComposant.getIdForme()));
        } else
            return null;
    }

    public static CaracteristiqueComposant mapToEntity(CaracteristiqueComposantDto caracteristiqueComposantDto) {
        if (caracteristiqueComposantDto != null) {
            CaracteristiqueComposant caracteristiqueComposant=new CaracteristiqueComposant();

            caracteristiqueComposant.setIdCaracteristiqueComposant(caracteristiqueComposantDto.getIdCaracteristiqueComposant());
            //caracteristiqueComposant.setIdTypeComposant(caracteristiqueComposantDto.getIdTypeComposant());

            //caracteristiqueComposant.setTypeComposantTag(caracteristiqueComposantDto.getTypeComposantTag());
            caracteristiqueComposant.setLargeurComposant(caracteristiqueComposantDto.getLargeurComposant());
            caracteristiqueComposant.setLongueurComposant(caracteristiqueComposantDto.getLongueurComposant());
            caracteristiqueComposant.setSurfacee(caracteristiqueComposantDto.getSurface());
            caracteristiqueComposant.setIdEstate(EstateMiMapper.mapToEntity(caracteristiqueComposantDto.getIdEstate()));
            caracteristiqueComposant.setIdForme(FormeComposantMiMapper.mapToEntity(caracteristiqueComposantDto.getIdFormeComposant()));

            return caracteristiqueComposant;
        }
        return null;

    }
}
