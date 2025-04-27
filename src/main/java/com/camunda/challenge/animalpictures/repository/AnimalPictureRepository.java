package com.camunda.challenge.animalpictures.repository;

import com.camunda.challenge.animalpictures.model.AnimalPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AnimalPictureRepository extends JpaRepository<AnimalPicture, Long> {
    Optional<AnimalPicture> findTopByTypeOrderByCreatedAtDesc(String type);
}
