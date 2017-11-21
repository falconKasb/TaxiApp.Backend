package com.sk.yandex.taxi.controllers;

import com.sk.yandex.taxi.models.Point;
import com.sk.yandex.taxi.services.PointService;
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
@RequestMapping("/point")
public class PointController {
    @Autowired
    private PointService pointService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Point>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        try {
            Iterable<Point> points = pointService.getAll();
            return new ResponseEntity<Iterable<Point>>(points, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Iterable<Point>>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> getOne(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Point point = pointService.get(id);
            return new ResponseEntity<Point>(point, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Point>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> create(@RequestBody @Valid Point request) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Point point = pointService.create(request);
            return new ResponseEntity<Point>(point, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Point>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> update(@RequestBody @Valid Point request) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Point point = pointService.update(request);
            return new ResponseEntity<Point>(point, headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Point>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            pointService.delete(id);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } catch (AppException e) {
            return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}
