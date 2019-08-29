package aw.krauterkiste.camera.controller;

import aw.krauterkiste.camera.repository.PictureRepository;
import aw.krauterkiste.camera.model.PictureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;

@RestController
@RequestMapping("camera")
public class CameraController {

    private final RestTemplate raspiRestTemplate;
    private final PictureRepository pictureRepository;

    @Autowired
    public CameraController(PictureRepository pictureRepository,
                            RestTemplate raspiRestTemplate) {
        this.pictureRepository = pictureRepository;
        this.raspiRestTemplate = raspiRestTemplate;
    }

    @GetMapping("/photo")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public PictureDto readImage() throws IOException {
        PictureDto pictureDto = new PictureDto();

        String fileResponse = raspiRestTemplate.getForObject("/camera/photo", String.class);

        pictureDto.setEncodedImage(fileResponse);

        return pictureDto;
    }
}

