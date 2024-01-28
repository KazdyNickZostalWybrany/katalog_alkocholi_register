package com.alko.backend.services;

import com.alko.backend.requests.BrandResponse;
import com.alko.backend.mappers.BrandToResponseMapper;
import com.alko.backend.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImplementation implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandToResponseMapper brandToResponseMapper;

    @Override
    public List<BrandResponse> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brandToResponseMapper::toResponse)
                .collect(Collectors.toList());
    }
}
