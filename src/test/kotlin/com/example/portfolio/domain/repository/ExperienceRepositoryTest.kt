package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Experience
import com.example.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(@Autowired val experienceRepository: ExperienceRepository) {
  val DATA_SIZE = 10

  private fun createExperience(n: Int): Experience {
    val experience = Experience(
      title = "${n}",
      description = "테스트 설명${n}",
      startYear = 2024,
      startMonth = 8,
      endYear = 2024,
      endMonth = 9,
      isActive = true

    )

    val details = mutableListOf<ExperienceDetail>()
    for (i in 1..n) {
      val experienceDetail = ExperienceDetail(content = "테스트${i}", isActive = true)
      details.add(experienceDetail)
    }
    experience.addDetails(details)
    return experience
  }

  @BeforeAll
  fun beforeAll() {
    println("------ LOOK UP THE TEST DATA BEFORE START -------- ")
    val beforeInitialize = experienceRepository.findAll()
    assertThat(beforeInitialize).hasSize(0)
    println("------ LOOK UP THE TEST DATA BEFORE FINISH -------- ")

    println("------  BEFORE TEST DATA START -------- ")
    val experiences = mutableListOf<Experience>()
    for (i in 1..DATA_SIZE) {
      val experience = createExperience(i)
      experiences.add(experience)
    }
    println("------ BEFORE TEST DATA FINISH -------- ")
  }

  @Test
  fun testFindAll() {
    println("------ TEST FIND ALL START -------- ")
    val experiences = experienceRepository.findAll()
    assertThat(experiences).hasSize(DATA_SIZE)

    println("experiences size : ${experiences.size}")
    for (experience in experiences) {
      assertThat(experience.details).hasSize(experience.title.toInt())
      println("experiences.details.size : ${experience.details.size}")
    }

    println("------ TEST FIND ALL  FINISH -------- ")
  }

  @Test
  fun testFindAllByIsActive() {
    println("------ TEST FIND ALL BY IS ACTIVE START -------- ")
    val experiences = experienceRepository.findAllByIsActive(isActive = true)
    assertThat(experiences).hasSize(DATA_SIZE)

    println("experiences size : ${experiences.size}")
    for (experience in experiences) {
      assertThat(experience.details).hasSize(experience.title.toInt())
      println("experiences.details.size : ${experience.details.size}")
    }

    println("------ TEST FIND ALL BY IS ACTIVE FINISH -------- ")
  }


}