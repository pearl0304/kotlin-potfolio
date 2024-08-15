package com.example.portfolio.presentation.interceport

import com.example.portfolio.domain.entity.HttpInterface
import com.example.portfolio.domain.repository.HttpInterfaceRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

// 컨트롤러 작동 후에 실행
@Component
class PresentationInterceptor(
  private val httpInterfaceRepository: HttpInterfaceRepository
) : HandlerInterceptor {
  override fun afterCompletion(
    request: HttpServletRequest, response: HttpServletResponse,
    handler: Any, ex: Exception?
  ) {
    val httpInterface = HttpInterface(request)
    httpInterfaceRepository.save(httpInterface)
  }
}