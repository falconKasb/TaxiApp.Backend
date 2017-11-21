package com.sk.yandex.taxi.repositories;

import com.sk.yandex.taxi.models.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sanchir on 6/21/2017.
 */
@Repository
public interface CarRepository extends CrudRepository<Car, String> {}
