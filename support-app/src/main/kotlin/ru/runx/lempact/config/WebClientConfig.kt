package ru.runx.lempact.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import reactor.netty.http.client.HttpClient
import ru.runx.lempact.service.yt.*


@Configuration
class WebClientConfig {
    @Bean
    fun webClient(authorizedClientManager: ReactiveOAuth2AuthorizedClientManager): WebClient {
        val httpClient = HttpClient
            .create()
            .wiretap(true)

        val oauth2 = ServerOAuth2AuthorizedClientExchangeFilterFunction(
            authorizedClientManager
        )
        oauth2.setDefaultOAuth2AuthorizedClient(true)
        oauth2.setDefaultClientRegistrationId("google")

        return WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .baseUrl(YOUTUBE_V3_API)
            .filter(oauth2)
            .build()
    }

    @Bean
    fun videosClient(webclient: WebClient): YtVideos {
        val factory = HttpServiceProxyFactory.builder(
            WebClientAdapter.forClient(webclient)
        ).build()
        return factory.createClient(YtVideos::class.java)
    }

    @Bean
    fun channelsClient(webclient: WebClient): YtChannels {
        val factory = HttpServiceProxyFactory.builder(
            WebClientAdapter.forClient(webclient)
        ).build()
        return factory.createClient(YtChannels::class.java)
    }

    @Bean
    fun liveChatClient(webclient: WebClient): YtLiveChat {
        val factory = HttpServiceProxyFactory.builder(
            WebClientAdapter.forClient(webclient)
        ).build()
        return factory.createClient(YtLiveChat::class.java)
    }

    @Bean
    fun searchClient(webclient: WebClient): YtSearch {
        val factory = HttpServiceProxyFactory.builder(
            WebClientAdapter.forClient(webclient)
        ).build()
        return factory.createClient(YtSearch::class.java)
    }

    companion object {
        const val YOUTUBE_V3_API = "https://www.googleapis.com/youtube/v3"
    }
}
