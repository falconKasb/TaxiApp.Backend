package com.sk.yandex.taxi.services;

import com.sk.yandex.taxi.models.Car;
import com.sk.yandex.taxi.models.Point;
import com.sk.yandex.taxi.repositories.PointRepository;
import com.sk.yandex.taxi.utils.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oleg on 6/21/2017.
 */

@Service
public class PointService {
    @Autowired
    private PointRepository pointRepository;

    public Point create(Point point) throws AppException {
        return pointRepository.save(point);
    }

    public Iterable<Point> getAll() throws AppException {
        return pointRepository.findAll();
    }

    public Point get(String id) throws AppException  {
        return pointRepository.findOne(id);
    }

    public void delete(String id) throws AppException  {
        pointRepository.delete(id);
    }

    public Point update(Point point) throws AppException  {
        return pointRepository.save(point);
    }
}
