package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @Test
    void localeRus() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, result);
    }
    @Test
    void localeEng() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Welcome";
        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals(expected, result);
    }
}