package com.alko.backend.mappers;

import com.alko.backend.data.Alcohol;
import com.alko.backend.data.Brand;
import com.alko.backend.requests.AlcoholRequest;
import com.alko.backend.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestToAlcoholMapper {

    private final BrandService brandService;

    public Alcohol mapToAlcohol(AlcoholRequest request){
//        System.out.println(request);
        Alcohol alcohol = new Alcohol();
        alcohol.setName(request.getName());
        alcohol.setBrand(new Brand(request.getBrandId(), null));
        return alcohol;
    }
}
