package com.example.portfolio.presentation.controller

import com.example.portfolio.presentation.dto.IntroductionDTO
import com.example.portfolio.presentation.dto.LinkDTO
import com.example.portfolio.presentation.dto.ProjectDTO
import com.example.portfolio.presentation.dto.ResumeDTO
import com.example.portfolio.presentation.servcie.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
  private val presentationService: PresentationService
) {
  @GetMapping("/test")
  fun test(): String {
    return "Hello World!"
  }

  @GetMapping("/v1/introductions")
  fun getIntroductions(): List<IntroductionDTO> {
    return presentationService.getIntroduction()
  }

  @GetMapping("/v1/links")
  fun getLinks(): List<LinkDTO> {
    return presentationService.getLink()
  }

  @GetMapping("/v1/resume")
  fun getResume(): ResumeDTO {
    return presentationService.getResume()
  }

  @GetMapping("/v1/projects")
  fun getProjects(): List<ProjectDTO> {
    return presentationService.getProjects()
  }
}