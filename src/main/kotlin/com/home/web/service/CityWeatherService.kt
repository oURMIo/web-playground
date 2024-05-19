package com.home.web.service

import com.home.web.domain.CityWeather
import com.home.web.exeption.DatabaseException
import com.home.web.repository.CityWeatherRepository
import java.util.Optional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class CityWeatherService(
    @Autowired
    private val cityWeatherRepository: CityWeatherRepository,
) {

    fun getCities(): List<CityWeather> {
        try {
            return cityWeatherRepository.findAll().toList()
        } catch (e: DatabaseException) {
            logger.error { "Got issue in getCities, $e" }
            return listOf()
        }
    }

    fun findCityWeatherById(userId: Long): Optional<CityWeather> {
        try {
            return cityWeatherRepository.findById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in findCityWeatherById(userId:$userId), $e" }
            return Optional.empty()
        }
    }

    fun findByCityName(username: String): Optional<CityWeather> {
        try {
            return cityWeatherRepository.findFirstByCityName(username)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in findByCityName(username:$username), $e" }
            return Optional.empty()
        }
    }

    fun saveCityWeather(cityName: String, temp: Double, haveRain: Boolean): Optional<out Any> {
        val cityWeather = CityWeather(cityName = cityName, temp = temp, haveRain = haveRain)
        try {
            return Optional.of(cityWeatherRepository.save(cityWeather))
        } catch (e: DatabaseException) {
            logger.error { "Got issue in saveCityWeather(cityName:$cityName, temp:$temp, haveRain:$haveRain), $e" }
            return Optional.empty()
        }
    }

    fun deleteCityById(userId: Long) {
        try {
            cityWeatherRepository.deleteById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in deleteCityById, $e" }
        }
    }
}