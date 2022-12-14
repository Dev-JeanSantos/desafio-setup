package com.example.desafiosetup.unidade.servico

import com.example.desafiosetup.aplicacao.dominio.modelo.Conta
import com.example.desafiosetup.aplicacao.dominio.modelo.NegocioException
import com.example.desafiosetup.aplicacao.servico.TransferenciaService
import org.junit.jupiter.api.BeforeEach
import java.math.BigDecimal

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TesteTransferenciaService {

    private val cem: BigDecimal = BigDecimal(100)
    private val vinte: BigDecimal = BigDecimal(20)
    private lateinit var transferenciaService: TransferenciaService
    private lateinit var contaDebito: Conta
    private lateinit var contaCredito: Conta

    @BeforeEach
    fun setup(){
        contaDebito = Conta("1", cem, "Jean Santos")
        contaCredito = Conta("2", cem, "Camilla Santos")
        transferenciaService = TransferenciaService()
    }

    @Test
    fun `Deve retornar uma exceção obrigatória quando uma transferência recebe um valor for nulo`() {
        val exception = assertThrows<NegocioException> {
            transferenciaService.processar(null, contaDebito, contaCredito)
        }
        assertThat(exception.message).isEqualTo("Valor da Transferência é Obrigatório")
    }

    @Test
    fun `Deve retornar uma exceção obrigatória quando uma transferência recebe um conta de crédito nula`() {
        val exception = assertThrows<NegocioException> {
            transferenciaService.processar(BigDecimal.TEN, null, contaCredito)
        }
        assertThat(exception.message).isEqualTo("Conta Débito é Obrigatório")
    }

    @Test
    fun `Deve retornar uma exceção obrigatória quando uma transferência recebe um conta de débito nula`() {
        val exception = assertThrows<NegocioException> {
            transferenciaService.processar(BigDecimal.TEN, contaDebito, null)
        }
        assertThat(exception.message).isEqualTo("Conta Crédito é Obrigatório")
    }

    @Test
    fun `Deve retornar sucesso para uma transferência de 20 reais`() {

        transferenciaService.processar(vinte, contaDebito, contaCredito)

        assertThat(contaDebito.saldo).isEqualTo(cem.subtract(vinte))
        assertThat(contaCredito.saldo).isEqualTo(cem.add(vinte))
        println(contaCredito)
        println(contaDebito)
    }

}