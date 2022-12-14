package com.example.desafiosetup.adapter.output.dynamodb.entidade

import com.amazonaws.services.dynamodbv2.datamodeling.*
import com.example.desafiosetup.adapter.web.v1.response.CorrentistaResponse
import com.example.desafiosetup.aplicacao.dominio.modelo.Conta
import java.math.BigDecimal

@DynamoDBTable(tableName = "ContaCorrente")
data class CorrentistaModel(
    @DynamoDBHashKey(attributeName = "pk")
    var pk: String = "",
    @DynamoDBRangeKey(attributeName = "sk")
    @DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
    var sk: String? = null,
    @DynamoDBAttribute(attributeName = "nome")
    var nome: String = "",
    @DynamoDBAttribute(attributeName = "conta")
    var conta: ContaModel = ContaModel(BigDecimal.ZERO)
) {
    fun toResponse():CorrentistaResponse{
        return CorrentistaResponse(this.nome, this.pk, this.pk, this.conta.saldo)
    }

    fun toConta() = Conta(
           numeroConta =  conta.numero,
            saldo = conta.saldo,
            correntista = nome
    )
}