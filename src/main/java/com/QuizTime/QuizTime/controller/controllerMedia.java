package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.service.serviceInterface.mediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medias")
@CrossOrigin
public class controllerMedia {

    @Autowired
    private mediaService Media_service;

    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@Valid @RequestBody MediaDTO mediaDto) {
        MediaDTO createdMedia = Media_service.saveMedia(mediaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable Integer id) {
        Media_service.delete(id);
        return new ResponseEntity<>("Media deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MediaResDTO>> getMedias() {
        List<MediaResDTO> allMedias = Media_service.getAll();
        return ResponseEntity.ok(allMedias);
    }


}
