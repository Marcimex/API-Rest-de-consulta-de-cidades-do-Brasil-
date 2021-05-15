package com.dio.marcimex.cidadesAPI.distances.service;


import java.util.Arrays;
import java.util.List;
import com.dio.marcimex.cidadesAPI.cities.City;
import com.dio.marcimex.cidadesAPI.cities.RepositoryCity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final RepositoryCity repositoryCity;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final RepositoryCity cityRepository) {
        this.repositoryCity = cityRepository;
    }


    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        return repositoryCity.distanceByPoints(city1, city2);
    }


    public Double distanceByCubeInMeters(Long city1, Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = repositoryCity.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return repositoryCity.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
