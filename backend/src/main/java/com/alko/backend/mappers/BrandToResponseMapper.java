package com.alko.backend.mappers;

import com.alko.backend.data.Brand;
import com.alko.backend.requests.BrandResponse;
import org.springframework.stereotype.Component;

@Component
public class BrandToResponseMapper {
    public BrandResponse toResponse(Brand brand){
        return new BrandResponse(
                brand.getId(),
                brand.getName()
        );
    }
}
