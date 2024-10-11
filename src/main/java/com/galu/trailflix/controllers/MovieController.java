package com.galu.trailflix.controllers;

import com.galu.trailflix.service.MockMovieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MockMovieService movieService = MockMovieService.getInstance();

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
//
//        return new ResponseEntity<>(UserTranslator.mapToUserResponseDTO(userFound), HttpStatus.OK);
//    }

    @GetMapping("/all")
    public String getAllMovies(){
        return movieService.getMockMoviesJson();
    }
}
