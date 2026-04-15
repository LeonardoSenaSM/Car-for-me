package CarForMe_demo.Cars;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CarForMe")
public class ControllerCars {

    private final ServiceCars serviceCars;

    public ControllerCars(ServiceCars serviceCars) {
        this.serviceCars = serviceCars;
    }

    @PostMapping("/register")
    public ResponseEntity<ModelDTO> CreateCar(@RequestBody ModelDTO car){
        ModelDTO addCar = serviceCars.createCars(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCar);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ModelDTO>> AllItems(){
        List<ModelDTO> CarsList = serviceCars.listCars();
        return ResponseEntity.ok(CarsList);
    }

    @GetMapping("/itemID/{id}")
    public ResponseEntity<?> ItemId(@PathVariable Long id){
        ModelDTO carsID = serviceCars.SearchCarsID(id);
        if (carsID != null){
            return ResponseEntity.ok(carsID);
        }else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not find this ID: id"+id);
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<?> ChangeCar(@PathVariable Long id, @RequestBody ModelDTO updatedCar ){
        try{
            ModelDTO modelChanged = serviceCars.UpdateCars(id,updatedCar);
            return ResponseEntity.ok("Updated Car" + modelChanged );
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Delete(@PathVariable Long id){
        try{
            serviceCars.deleteCars(id);
            return ResponseEntity.ok("ID successfully deleted: id" + id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
