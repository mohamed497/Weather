package com.mohamed.gamal.presentation.mapper

interface PresentationMapper<D, V> {
    fun mapToPresentation(domain: D?): V
}