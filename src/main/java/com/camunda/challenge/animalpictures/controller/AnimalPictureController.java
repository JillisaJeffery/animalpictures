package com.camunda.challenge.animalpictures.controller;

import com.camunda.challenge.animalpictures.model.AnimalPicture;
import com.camunda.challenge.animalpictures.service.AnimalPictureService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/animals")
public class AnimalPictureController {

    private final AnimalPictureService service;

    public AnimalPictureController(AnimalPictureService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public List<AnimalPicture> savePictures(@RequestParam String type, @RequestParam int count) {
        String baseUrl = switch (type) {
            case "bear" -> "https://placebear.com/300/300";
            case "dog" -> "https://dog.ceo/api/breeds/image/random";
            case "duck" -> "https://random-d.uk/api/randomimg";
            default -> throw new IllegalArgumentException("Invalid animal type. Choose bear, dog, or duck.");
        };

        List<AnimalPicture> saved = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            saved.add(service.savePicture(type, baseUrl));
        }
        return saved;
    }

    @GetMapping("/last")
    public AnimalPicture getLastPicture(@RequestParam String type) {
        return service.getLastPicture(type);
    }
}
