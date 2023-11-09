package com.wah.sem7_ipr2.service

import com.wah.sem7_ipr2.repository.UserRepository
import com.wah.sem7_ipr2.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.OAuth2Error
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    @Autowired val oAuth2UserFactory: Oauth2UserFactory,
    @Autowired val userRepository: UserRepository
) {

    @Bean
    fun oAuth2UserService(): OAuth2UserService<OAuth2UserRequest, OAuth2User> {
        val delegate = DefaultOAuth2UserService()

        return OAuth2UserService<OAuth2UserRequest, OAuth2User> {
            val oAuth2User = delegate.loadUser(it)

            val id = oAuth2User.getAttribute<Int>("id")
            val name = oAuth2User.getAttribute<String>("name")

            if (Objects.isNull(id) || Objects.isNull(name)) {
                throw OAuth2AuthenticationException(OAuth2Error("corrupted_user"))
            }
            val stringId = id.toString()

            val databaseUser = userRepository.findById(stringId).orElseGet {
                val nameArray = name!!.split(" ")
                userRepository.save(User(stringId, nameArray[0], nameArray[1], 1))
            }
            oAuth2UserFactory.create(oAuth2User, databaseUser)
        }
    }

}