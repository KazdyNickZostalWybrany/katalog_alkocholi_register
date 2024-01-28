package com.alko.backend.mappers;

import com.alko.backend.data.Alcohol;
import com.alko.backend.requests.AlcoholResponse;
import org.springframework.stereotype.Component;

@Component
public class AlcoholToResponseMapper {

    public AlcoholResponse toResponse(Alcohol alcohol){
        return new AlcoholResponse(
                alcohol.getId(),
                alcohol.getBrand().getName(),
                alcohol.getName()
        );
    }
}
