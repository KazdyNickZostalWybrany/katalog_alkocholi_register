package com.alko.backend.controllers;

import com.alko.backend.services.BrandService;
import com.alko.backend.requests.BrandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    List<BrandResponse> getAllBrands() {
        return brandService.getAllBrands();
    }
}
