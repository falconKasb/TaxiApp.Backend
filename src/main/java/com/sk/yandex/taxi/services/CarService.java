package com.sk.yandex.taxi.services;

import com.sk.yandex.taxi.models.Car;
import com.sk.yandex.taxi.repositories.CarRepository;
import com.sk.yandex.taxi.utils.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sanchir on 6/21/2017.
 */

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car create(Car car) throws AppException {
        return carRepository.save(car);
    }

    public Iterable<Car> getAll() throws AppException {
        return carRepository.findAll();
    }

    public Car get(String id) throws AppException  {
        return carRepository.findOne(id);
    }

    public void delete(String id) throws AppException  {
        carRepository.delete(id);
    }

    public Car update(Car car) throws AppException  {
        return carRepository.save(car);
    }
}
