package com.wah.sem7_ipr2.repository

import com.wah.sem7_ipr2.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String>