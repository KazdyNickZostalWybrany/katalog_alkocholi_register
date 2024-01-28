package com.alko.backend.services;

import com.alko.backend.requests.AlcoholRequest;
import com.alko.backend.requests.AlcoholResponse;
import com.alko.backend.data.Alcohol;
import com.alko.backend.mappers.AlcoholToResponseMapper;
import com.alko.backend.mappers.RequestToAlcoholMapper;
import com.alko.backend.repositories.AlcoholRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlcoholServiceImplementation implements AlcoholService {

    private final AlcoholRepository alcoholRepository;
    private final AlcoholToResponseMapper alcoholToResponseMapper;
    private final RequestToAlcoholMapper requestToAlcoholMapper;

    public List<AlcoholResponse> getAllAlcohol() {
    return alcoholRepository.findAll().stream()
            .map(alcoholToResponseMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public Alcohol addAlcohol(AlcoholRequest alcoholRequest) {
        return alcoholRepository.save(requestToAlcoholMapper.mapToAlcohol(alcoholRequest));
    }
}
