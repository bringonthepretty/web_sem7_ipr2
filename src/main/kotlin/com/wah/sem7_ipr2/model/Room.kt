package com.wah.sem7_ipr2.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "room")
class Room {

    @Id
    @SequenceGenerator(name = "idSequenceRoom", sequenceName = "room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "idSequenceRoom")
    var id: Int? = null

    var name: String? = null
    var available: Boolean? = null
}