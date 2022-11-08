package com.example.desafiosetup.adapter.web.v1.controller

import com.example.desafiosetup.adapter.web.v1.api.ContaApi
import com.example.desafiosetup.adapter.web.v1.request.CorrentistaTransferenciaRequest
import com.example.desafiosetup.adapter.web.v1.request.TransferenciaRequest
import com.example.desafiosetup.adapter.web.v1.response.CorrentistaResponse
import com.example.desafiosetup.adapter.web.v1.response.TransferenciaResponse
import com.example.desafiosetup.aplicacao.porta.input.ContaUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class ContaApiController(
    @Autowired
    private val contaUseCase: ContaUseCase
) : ContaApi {
    override fun transferenciaConta(transferenciaRequest: TransferenciaRequest): TransferenciaResponse {
        return contaUseCase.transferir(transferenciaRequest)
    }

    override fun confirmaTransferenciaConta(correntistaTransferenciaRequest: CorrentistaTransferenciaRequest): TransferenciaResponse {
        return contaUseCase.confirmarTransferencia(correntistaTransferenciaRequest)
    }
}