package dk.kea.herokumandatory.controllers;

import dk.kea.herokumandatory.models.Animal;
import dk.kea.herokumandatory.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalController {

    @Autowired
    AnimalRepository animals;

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals() {
        return animals.findAll();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimal(@PathVariable Long id) {
        return animals.findById(id).get();
    }

    @PostMapping("/animals")
    public Animal createAnimal(@RequestBody Animal animal) {
        return animals.save(animal);
    }

    //Update all columns
    @PutMapping("/animals/{id}")
    public String updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        if (animals.existsById(id))
        {
            animal.setId(id);
            animals.save(animal);
            return "Animal was created!";
        }
        else
        {
            return "Animal not found";
        }
    }

    //Updates only changed columns
    @PatchMapping("/animals/{id}")
    public String patchAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        return animals.findById(id).map(foundAnimal -> {
            if (animal.getAge() !=0) foundAnimal.setAge(animal.getAge());
            if (animal.getName() != null) foundAnimal.setName(animal.getName());
            if (animal.getType() != null) foundAnimal.setType((animal.getType()));
            animals.save(animal);
            return "Animal updated";
        }).orElse("Animal not found");
    }

    @DeleteMapping("/animals/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animals.deleteById(id);
    }
}
