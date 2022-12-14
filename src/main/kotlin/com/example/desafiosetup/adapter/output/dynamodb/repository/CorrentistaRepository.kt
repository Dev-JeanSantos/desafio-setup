package com.example.desafiosetup.adapter.output.dynamodb.repository

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.example.desafiosetup.adapter.output.dynamodb.entidade.CorrentistaModel
import com.example.desafiosetup.aplicacao.dominio.modelo.Correntista
import com.example.desafiosetup.aplicacao.porta.output.CorrentistaRepositorioPorta
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class CorrentistaRepository(
    private val dynamoDBMapper: DynamoDBMapper
) : CorrentistaRepositorioPorta {
    override fun salvar(correntista: Correntista): Correntista {
        dynamoDBMapper.save(correntista.toModel())
        return correntista
    }


    override fun buscarCorrentistaPorNumeroConta(numeroConta: String): CorrentistaModel {
        return dynamoDBMapper.query(
                CorrentistaModel::class.java,
                DynamoDBQueryExpression<CorrentistaModel>()
                    .withKeyConditionExpression("pk = :pk")
                    .withExpressionAttributeValues(mapOf(":pk" to AttributeValue().withS(numeroConta)))
        ).first()
    }
}