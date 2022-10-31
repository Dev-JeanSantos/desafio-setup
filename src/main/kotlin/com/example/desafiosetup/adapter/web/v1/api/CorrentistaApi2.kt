package com.example.desafiosetup.adapter.web.v1.api

import com.example.desafiosetup.adapter.web.v1.request.CorrentistaRequest
import com.example.desafiosetup.adapter.web.v1.response.CorrentistaResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("v1/correntistas2")
interface CorrentistaApi2 {
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun salvarCliente(@RequestBody @Validated clienteRequest: CorrentistaRequest)
}