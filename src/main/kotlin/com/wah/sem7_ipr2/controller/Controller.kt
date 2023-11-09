package com.wah.sem7_ipr2.controller

import com.wah.sem7_ipr2.model.Room
import com.wah.sem7_ipr2.service.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/room")
class Controller(@Autowired val roomService: RoomService) {

    @GetMapping()
    fun getAll(): ResponseEntity<CollectionModel<Room>> {
        return ResponseEntity.ok(CollectionModel.of(roomService.getAll()))
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Room> {
        return ResponseEntity.ok(roomService.getById(id))
    }

    @GetMapping("/{id}/reserve")
    fun reserveRoom(@PathVariable(name = "id") id: Int): ResponseEntity<String> {
        return ResponseEntity.ok(id.toString())
    }

}