package com.sk.yandex.taxi.services;

import com.sk.yandex.taxi.models.Point;
import com.sk.yandex.taxi.models.Travel;
import com.sk.yandex.taxi.repositories.TravelRepository;
import com.sk.yandex.taxi.utils.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sanchir on 6/21/2017.
 */

@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;

    public Travel create(Travel travel) throws AppException {
        return travelRepository.save(travel);
    }

    public Iterable<Travel> getAll() throws AppException {
        return travelRepository.findAll();
    }

    public Travel get(String id) throws AppException  {
        return travelRepository.findOne(id);
    }

    public void delete(String id) throws AppException  {
        travelRepository.delete(id);
    }

    public Travel update(Travel travel) throws AppException  {
        return travelRepository.save(travel);
    }
}
