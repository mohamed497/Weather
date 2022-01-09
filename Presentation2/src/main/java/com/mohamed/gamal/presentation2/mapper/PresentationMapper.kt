package com.mohamed.gamal.presentation2.mapper

interface PresentationMapper<D, V> {
    fun mapToPresentation(domain: D?): V
}