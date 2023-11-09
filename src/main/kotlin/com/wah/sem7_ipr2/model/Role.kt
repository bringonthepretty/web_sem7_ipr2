package com.wah.sem7_ipr2.model

import java.util.*

enum class Role(val id: Int) {
    USER(1), ADMIN(2);

    companion object {
        fun getById(id: Int?): Role {
            return Arrays.stream(values())
                .filter { role -> Objects.equals(role.id, id) }
                .findFirst().orElse(null)
        }

        fun getByName(name: String?): Role {
            return Arrays.stream(values()).filter { role -> role.name.equals(name, true) }.findFirst()
                .orElse(null)
        }
    }
}