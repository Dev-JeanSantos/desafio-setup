package com.example.desafiosetup.adapter.output.dynamodb.entidade

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.example.desafiosetup.adapter.web.v1.response.CorrentistaResponse
import com.example.desafiosetup.aplicacao.dominio.modelo.ContaType
import com.example.desafiosetup.aplicacao.dominio.modelo.Correntista
import java.math.BigDecimal

@DynamoDBDocument
data class ContaModel(
    @DynamoDBAttribute(attributeName = "saldo")
    var saldo: BigDecimal = BigDecimal.ZERO,
    @DynamoDBAttribute(attributeName = "numero")
    var numero: String = ""
)

fun ContaModel.toDomain(): ContaType {
    return ContaType(this.saldo, this.numero)
}