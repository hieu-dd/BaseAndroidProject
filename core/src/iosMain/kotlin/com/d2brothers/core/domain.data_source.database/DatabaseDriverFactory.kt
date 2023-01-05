package com.d2brothers.core.domain.data_source.database

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PokemonDatabases.Schema, "pokemon.db")
    }
}