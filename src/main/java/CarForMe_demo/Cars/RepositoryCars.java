package CarForMe_demo.Cars;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCars extends JpaRepository<ModelCars, Long> {
}
