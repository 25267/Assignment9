package kz.example.controller;

import kz.example.entity.PersonalData;
import kz.example.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personalData")
public class PersonalDataController {

    @Autowired
    private PersonalDataRepository personalDataRepository;


    @PutMapping("/{id}")
    public PersonalData updateUser(@PathVariable Long id, @RequestBody PersonalData personalData){
        personalData.setId(id);
        return  personalDataRepository.saveAndFlush(personalData);
    }

    @PostMapping("")
    public PersonalData createUser(@RequestBody PersonalData personalData){
        return personalDataRepository.saveAndFlush(personalData);
    }


    @DeleteMapping("/{id}")
    public void deletePersonalData(@PathVariable Long id) {

        personalDataRepository.deleteById(id);
    }
}
