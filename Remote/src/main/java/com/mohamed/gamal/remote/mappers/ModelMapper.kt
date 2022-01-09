package com.mohamed.gamal.remote.mappers

import com.mohamed.gamal.data.models.Entity
import com.mohamed.gamal.remote.models.RemoteModel

interface ModelMapper<M : RemoteModel, E : Entity> {
    fun mapFromModel(model: M?): E
}