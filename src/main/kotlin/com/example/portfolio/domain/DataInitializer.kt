package com.example.portfolio.domain

import com.example.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile(value = ["default"])
class DataInitialize(
  private val achievementRepository: AchievementRepository,
  private val introductionRepository: IntroductionRepository,
  private var linkRepository: LinkRepository,
  private val skillRepository: SkillRepository,
  private val projectRepository: ProjectRepository,
  private val experienceRepository: ExperienceRepository
) {

  @PostConstruct
  fun initializeData() {

  }
}