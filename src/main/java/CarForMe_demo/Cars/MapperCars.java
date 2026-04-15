package CarForMe_demo.Cars;

import org.springframework.stereotype.Component;

@Component
public class MapperCars {
    public ModelCars map (ModelDTO modelDTO){
        ModelCars modelCars = new ModelCars();

        modelCars.setId(modelDTO.getId());
        modelCars.setName(modelDTO.getName());
        modelCars.setBrand(modelDTO.getBrand());
        modelCars.setBody(modelDTO.getBody());
        modelCars.setManufactureYear(modelDTO.getManufactureYear());
        modelCars.setValueCar(modelDTO.getValueCar());
        modelCars.setConsume(modelDTO.getConsume());
        modelCars.setDescription(modelDTO.getDescription());
        modelCars.setImgUrl(modelDTO.getImgUrl());

        return modelCars;
    }

    public ModelDTO map (ModelCars modelCars){
        ModelDTO modelDTO = new ModelDTO();

        modelDTO.setId(modelCars.getId());
        modelDTO.setName(modelCars.getName());
        modelDTO.setBrand(modelCars.getBrand());
        modelDTO.setBody(modelCars.getBody());
        modelDTO.setManufactureYear(modelCars.getManufactureYear());
        modelDTO.setValueCar(modelCars.getValueCar());
        modelDTO.setConsume(modelCars.getConsume());
        modelDTO.setDescription(modelCars.getDescription());
        modelDTO.setImgUrl(modelCars.getImgUrl());

        return modelDTO;
    }
}