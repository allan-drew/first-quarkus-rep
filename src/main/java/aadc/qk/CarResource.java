package aadc.qk;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

// A resource class is typically used in the context of building RESTful APIs or web services.
// It handles incoming HTTP requests and generates appropriate HTTP responses.
// (sometimes referred to as a Controller in some frameworks)

// CarResource is a resource class that handles HTTP requests related to car

@Path("/api/car")
public class CarResource {

    @Inject // The @Inject annotation is used to inform the CDI container that it should automatically provide an instance of CarRepository
    CarRepository carRepository;

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        logger.info("returning all cars");
        return carRepository.getAllCars();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllCars() {
        logger.info("returning the number of cars");
        return carRepository.getAllCars().size();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Optional<Car> getSpecificCar(@PathParam("id") int id) {
                                        // @PathParam: It extracts values from the URL path and passes them as arguments to the method.
        logger.info("returning a specific car with id:" + id);
        return carRepository.getSpecificCar(id);
    }


}


