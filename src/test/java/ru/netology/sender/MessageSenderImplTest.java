package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);


    @Test
    void sendRusIP() {
        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP)).thenReturn(new Location(null, Country.RUSSIA, null,0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        String expected = "Добро пожаловать";
        String result = messageSender.send(headers);
        Assertions.assertEquals(expected,result);
    }
    @Test
    void sendEngIP() {
        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP)).thenReturn(new Location(null, Country.USA, null,0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        String expected = "Welcome";
        String result = messageSender.send(headers);
        Assertions.assertEquals(expected,result);
    }
}