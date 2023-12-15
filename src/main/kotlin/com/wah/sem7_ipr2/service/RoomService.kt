package com.wah.sem7_ipr2.service

import com.wah.sem7_ipr2.model.Room
import com.wah.sem7_ipr2.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoomService(@Autowired val roomRepository: RoomRepository) {

    fun getAll(): List<Room> {
        return roomRepository.findAll()
    }

    fun getById(id: Int): Room {
        return roomRepository.findById(id).orElse(Room())
    }

    fun delete(id: Int): Int {
        roomRepository.deleteById(id)
        return id
    }

}