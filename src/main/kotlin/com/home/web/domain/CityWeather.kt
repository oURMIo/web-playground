package com.home.web.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "city_weather")
data class CityWeather(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @Column(name = "city_name")
    var cityName: String,

    @Column(name = "temp")
    var temp: Double,

    @Column(name = "have_rain")
    var haveRain: Boolean,
)