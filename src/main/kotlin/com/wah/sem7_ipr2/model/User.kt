package com.wah.sem7_ipr2.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usr")
open class User() {

    constructor(id: String?,
                firstname: String?,
                lastname: String?,
                roleId: Int?): this() {
        this.id = id
        this.firstname = firstname
        this.lastname = lastname
        this.roleId = roleId
    }

    @Id
    @Column(name = "id")
    open var id: String? = null

    @Column(name = "name")
    open var firstname: String? = null

    @Column(name = "surname")
    open var lastname: String? = null

    @Column(name = "role_id")
    open var roleId: Int? = null
}