package aadc.qk;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

// A repository class is typically used in the context of data access and persistence.
// It is responsible for interacting with a database or any other data source.


@ApplicationScoped // the bean instance is created once for the duration of the application and can be used multiple times in the application once created
public class CarRepository {

    @ConfigProperty(name = "car.condition", defaultValue = "0 km") // see more in application.properties
    String condition;

    public List<Car> getAllCars() {
        return List.of(
                new Car(1, "VW", "Polo", 2022, condition),
                new Car(2, "Fiat", "Argo", 2021, condition),
                new Car(3, "Peugeot", "208", 2023, condition),
                new Car(4, "VW", "Nivus", 2023, condition),
                new Car(5, "Chevrolet", "Onix", 2020, condition)
        );
    }


    public Optional<Car> getSpecificCar(int id) {
        return getAllCars().stream().filter(car -> car.id == id).findFirst();
    }


}


