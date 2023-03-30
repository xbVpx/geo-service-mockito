package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.entity.Country;

class GeoServiceImplTest {

    @Test
    void byIpRus() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Country expected = Country.RUSSIA;
        Country result = geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCountry();
        Assertions.assertEquals(expected, result);
    }
    @Test
    void byIpEng() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Country expected = Country.USA;
        Country result = geoService.byIp(GeoServiceImpl.NEW_YORK_IP).getCountry();
        Assertions.assertEquals(expected, result);
    }
}