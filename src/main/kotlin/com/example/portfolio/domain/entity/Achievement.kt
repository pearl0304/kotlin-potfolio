package com.example.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(
  title: String,
  description: String,
  achievedDate: LocalDate?,
  host: String,
  isAchieve: Boolean
) : BaseEntity() {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "achievement_id")
  var id: Long? = null

  var title: String = title
  var description: String = description
  var achievedDate: LocalDate? = achievedDate
  var host: String = host
  var isAchieve: Boolean = isAchieve

}