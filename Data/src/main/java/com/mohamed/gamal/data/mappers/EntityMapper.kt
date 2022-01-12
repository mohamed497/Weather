package com.mohamed.gamal.data.mappers

interface EntityMapper<E, D> {
    fun mapToDomain(entity: E?): D
}