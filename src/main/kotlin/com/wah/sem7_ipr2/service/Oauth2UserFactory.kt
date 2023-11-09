package com.wah.sem7_ipr2.service

import com.wah.sem7_ipr2.model.Role
import com.wah.sem7_ipr2.model.OAuth2UserImpl
import com.wah.sem7_ipr2.model.User
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class Oauth2UserFactory {

    fun create(oAuth2User: OAuth2User, databaseUser: User): OAuth2UserImpl {
        val grantedAuthorities = oAuth2User.authorities.stream()
            .map { SimpleGrantedAuthority(it.authority) }
            .collect(Collectors.toCollection(::ArrayList))
        grantedAuthorities.add(SimpleGrantedAuthority(Role.getById(databaseUser.roleId).name))

        return OAuth2UserImpl(databaseUser.id, databaseUser.firstname, databaseUser.lastname, databaseUser.roleId,
            oAuth2User.name, oAuth2User.attributes, grantedAuthorities)
    }

}