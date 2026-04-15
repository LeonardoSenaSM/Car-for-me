package CarForMe_demo.Cars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("CarForMe/ui")
public class ControllerCarsUI {
    private final ServiceCars serviceCars;

    public ControllerCarsUI(ServiceCars serviceCars) {
        this.serviceCars = serviceCars;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/catalog")
    public String allItems(Model model) {
        List<ModelDTO> CarsList = serviceCars.listCars();
        model.addAttribute("cars", CarsList);
        return "catalog";
    }

    @GetMapping("/details/{id}")
    public String itemId(@PathVariable Long id, Model model){
        ModelDTO carsID = serviceCars.SearchCarsID(id);
        if (carsID != null){
            model.addAttribute("car", carsID);
            return "details";
        }else {
            model.addAttribute("mensage", "O modelo não foi encontrado por esse ID"+id+"!");
            return "redirect:/CarForMe/ui/Catalog";
        }
    }

    @GetMapping("/edit/{id}")
    public String FormEditCar(@PathVariable Long id, Model model) {
        ModelDTO car = serviceCars.SearchCarsID(id);
        if (car != null) {
            model.addAttribute("car", car);
            model.addAttribute("brands", CarBrand.values());
            model.addAttribute("bodies", CarBody.values());
            return "register";

        } else {
            return "redirect:/CarForMe/ui/catalog";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable Long id, @ModelAttribute ModelDTO updatedCar, RedirectAttributes redirectAttributes){
            ModelDTO modelChanged = serviceCars.UpdateCars(id, updatedCar);
            redirectAttributes.addFlashAttribute("message","Carro editado com sucesso!");
            return "redirect:/CarForMe/ui/catalog";
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable Long id){
            serviceCars.deleteCars(id);
            return "redirect:/CarForMe/ui/Catalog";
    }

    @GetMapping ("/register")
    public String FormCreateCar(Model model){
        model.addAttribute("car", new ModelDTO());
        model.addAttribute("brands", CarBrand.values());
        model.addAttribute("bodies", CarBody.values());
        return "register";
    }

    @PostMapping("/register")
    public String SaveCreateCar(@ModelAttribute ModelDTO car, RedirectAttributes redirectAttributes){
        serviceCars.createCars(car);
        redirectAttributes.addFlashAttribute("mensage", "Carro cadastrado com sucesso!");
        return "redirect:/CarForMe/ui/catalog";
    }
}