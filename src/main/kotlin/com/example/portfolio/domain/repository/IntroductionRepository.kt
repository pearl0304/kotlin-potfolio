package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Introductioin
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introductioin, Long> {
  fun findAllByIsActive(isActive: Boolean): List<Introductioin>
}