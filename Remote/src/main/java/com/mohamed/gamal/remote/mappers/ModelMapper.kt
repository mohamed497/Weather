package com.mohamed.gamal.remote.mappers

interface ModelMapper<M , E > {
    fun mapFromModel(model: M?): E
}