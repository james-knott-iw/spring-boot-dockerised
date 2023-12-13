package works.integration.demoapi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import works.integration.demoapi.entity.Pet;
import works.integration.demoapi.service.PetService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/pet")
public class PetController {

    PetService petService;

    @PostMapping("/person/{id}")
    public ResponseEntity<Pet> postPet(@PathVariable Long id, @RequestBody Pet pet) {

        return new ResponseEntity<>(petService.savePet(pet, id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {

        return new ResponseEntity<>(petService.getPet(id), HttpStatus.OK);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Pet> putPet(@PathVariable Long id, @RequestBody Pet pet) {

        return new ResponseEntity<>(petService.updatePet(id, pet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
