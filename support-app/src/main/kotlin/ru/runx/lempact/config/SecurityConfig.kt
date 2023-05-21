package ru.runx.lempact.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher
import org.springframework.web.server.session.WebSessionManager
import reactor.core.publisher.Mono

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun webSessionManager(): WebSessionManager {
        return WebSessionManager { Mono.empty() }
    }

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http {
            requestCache {
                disable()
            }
            anonymous {
                disable()
            }
            logout {
                disable()
            }
            formLogin {
                disable()
            }
            csrf {
                disable()
            }
            httpBasic {
                disable()
            }

            securityMatcher(PathPatternParserServerWebExchangeMatcher("/api/v1/auth/**"))

            authorizeExchange {
                authorize(anyExchange, authenticated)
            }
        }
    }
}
