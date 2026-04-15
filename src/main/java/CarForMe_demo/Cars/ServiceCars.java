package CarForMe_demo.Cars;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCars {
    private final RepositoryCars repositoryCars;
    private final MapperCars mapperCars;

    public ServiceCars(RepositoryCars repositoryCars, MapperCars mapperCars) {
        this.repositoryCars = repositoryCars;
        this.mapperCars = mapperCars;
    }

    public ModelDTO createCars(ModelDTO modelDTO){
        ModelCars cars = mapperCars.map(modelDTO);
        cars = repositoryCars.save(cars);
        return mapperCars.map(cars);
    }

    public List<ModelDTO> listCars(){
        List<ModelCars> cars = repositoryCars.findAll();
        return  cars.stream()
                .map(mapperCars :: map)
                .collect(Collectors.toList());
    }
    public ModelDTO SearchCarsID(Long id){
        Optional<ModelCars> modelCarsID = repositoryCars.findById(id);
        return modelCarsID
                .map(mapperCars::map)
                .orElse(null);
    }
    public ModelDTO UpdateCars(Long id, ModelDTO modelDTO){
        Optional<ModelCars> modelCarsExist = repositoryCars.findById(id);
        if (modelCarsExist.isPresent()){
            ModelCars modelCarsUpdated = mapperCars.map(modelDTO);
            modelCarsUpdated.setId(id);
            ModelCars modelCarsSave = repositoryCars.save(modelCarsUpdated);
            return mapperCars.map(modelCarsSave);
        }else {
        throw new RuntimeException("ID Not found: id" + id +" no exist!");
        }
    }

    public void deleteCars(Long id){
        if (repositoryCars.existsById(id)){
            repositoryCars.deleteById(id);
            return;
        }throw new RuntimeException("ID Not found: id" + id +" no exist!");
    }
}