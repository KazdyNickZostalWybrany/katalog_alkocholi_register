package com.alko.backend.services;

import com.alko.backend.requests.BrandResponse;

import java.util.List;

public interface BrandService {

    List<BrandResponse> getAllBrands();
}
