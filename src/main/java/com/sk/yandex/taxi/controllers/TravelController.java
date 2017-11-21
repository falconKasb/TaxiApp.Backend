package com.sk.yandex.taxi.controllers;

import com.sk.yandex.taxi.models.Travel;
import com.sk.yandex.taxi.services.TravelService;
import com.sk.yandex.taxi.utils.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Oleg on 6/21/2017.
 */
@RestController
@RequestMapping("/travel")
public class TravelController {
    @Autowired
    private TravelService travelService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Travel>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        try {
            Iterable<Travel> points = travelService.getAll();
            return new ResponseEntity<Iterable<Travel>>(points, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Iterable<Travel>>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Travel> getOne(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Travel travel = travelService.get(id);
            return new ResponseEntity<Travel>(travel, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Travel>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Travel> create(@RequestBody @Valid Travel request) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Travel travel = travelService.create(request);
            return new ResponseEntity<Travel>(travel, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Travel>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Travel> update(@RequestBody @Valid Travel request) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Travel travel = travelService.update(request);
            return new ResponseEntity<Travel>(travel, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Travel>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            travelService.delete(id);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}
