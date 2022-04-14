package grupo1.demo.services;

import org.springframework.web.bind.annotation.RestController;

import grupo1.demo.models.Dog;
import grupo1.demo.repositories.DogRepository;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class DogService {
    
    private final DogRepository dogRepository;
    DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    @GetMapping("/dogs/count")
    public String countDogs(){
        int total = dogRepository.countDogs();
        return String.format("Tienes %s perros!", total);
    }
}
