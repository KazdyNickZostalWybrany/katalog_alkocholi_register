package com.alko.backend.services;

import com.alko.backend.requests.AlcoholRequest;
import com.alko.backend.requests.AlcoholResponse;
import com.alko.backend.data.Alcohol;

import java.util.List;

public interface AlcoholService {
    List<AlcoholResponse> getAllAlcohol();
    Alcohol addAlcohol(AlcoholRequest alcoholRequest);
}
