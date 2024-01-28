package com.alko.backend.controllers;

import com.alko.backend.services.AlcoholService;
import com.alko.backend.requests.AlcoholRequest;
import com.alko.backend.requests.AlcoholResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alcohol")
public class AlcoholController {

    private final AlcoholService alcoholService;

    @GetMapping
    public List<AlcoholResponse> getAllAlcohol(){
        return alcoholService.getAllAlcohol();
    }

    @PostMapping
    public List<AlcoholResponse> addNewAlcohol(@RequestBody AlcoholRequest alcoholRequest) {
        ArrayList<AlcoholResponse> list = new ArrayList<>();
        var alcohol = alcoholService.addAlcohol(alcoholRequest);

        //list.add(new AlcoholResponse(alcohol.getId(),alcohol.getBrand().getId(),alcohol.getName()));
        return list;
    }
}
