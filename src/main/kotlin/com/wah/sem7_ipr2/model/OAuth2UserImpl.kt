package com.wah.sem7_ipr2.model

import com.wah.sem7_ipr2.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

class OAuth2UserImpl(id: String?,
                     firstname: String?,
                     lastname: String?,
                     roleId: Int?,
                     private var oAuth2Name: String,
                     private var attributes: MutableMap<String, Any>,
                     private var grantedAuthorities: MutableCollection<out GrantedAuthority>
    ): User(id, firstname, lastname, roleId), OAuth2User {

    override fun getName(): String {
        return oAuth2Name
    }

    override fun getAttributes(): MutableMap<String, Any> {
        return attributes
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return grantedAuthorities
    }

}