package com.sk.yandex.taxi.controllers;

import com.sk.yandex.taxi.models.Car;
import com.sk.yandex.taxi.services.CarService;
import com.sk.yandex.taxi.utils.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Sanchir on 6/21/2017.
 */

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Car>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        try {
            Iterable<Car> cars = carService.getAll();
            return new ResponseEntity<Iterable<Car>>(cars, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Iterable<Car>>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getOne(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Car car = carService.get(id);
            return new ResponseEntity<Car>(car, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Car>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> create(@RequestBody @Valid Car request) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Car car = carService.create(request);
            return new ResponseEntity<Car>(car, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Car>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> update(@RequestBody @Valid Car request) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Car car = carService.update(request);
            return new ResponseEntity<Car>(car, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Car>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            carService.delete(id);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}
