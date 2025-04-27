package com.camunda.challenge.animalpictures.service;

import com.camunda.challenge.animalpictures.model.AnimalPicture;
import com.camunda.challenge.animalpictures.repository.AnimalPictureRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalPictureService {
    private final AnimalPictureRepository repo;

    public AnimalPictureService(AnimalPictureRepository repo) {
        this.repo = repo;
    }

    public AnimalPicture savePicture(String type, String url) {
        AnimalPicture pic = new AnimalPicture();
        pic.setType(type);
        pic.setUrl(url);
        return repo.save(pic);
    }

    public AnimalPicture getLastPicture(String type) {
        return repo.findTopByTypeOrderByCreatedAtDesc(type).orElse(null);
    }
}
