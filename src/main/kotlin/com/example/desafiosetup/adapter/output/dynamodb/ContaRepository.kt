package com.example.desafiosetup.adapter.output.dynamodb

import com.example.desafiosetup.aplicacao.dominio.Conta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContaRepository: JpaRepository<ContaModel, Int>{

    fun findByNumeroConta(numeroConta: Int): ContaModel

}