package com.home.web.repository

import com.home.web.domain.CityWeather
import java.util.Optional
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CityWeatherRepository : CrudRepository<CityWeather, Long> {
    fun findByCityName(cityName: String): List<CityWeather>
    fun findFirstByCityName(cityName: String): Optional<CityWeather>
}
