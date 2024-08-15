package com.example.portfolio.presentation.dto

import com.example.portfolio.domain.entity.Introduction

class IntroductionDTO(
  val content: String
) {
  constructor(introduction: Introduction) : this(
    content = introduction.content
  )
}