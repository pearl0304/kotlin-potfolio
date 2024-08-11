package com.example.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introductioin : BaseEntity() {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "introduction_id")
  var id: Long? = null
}