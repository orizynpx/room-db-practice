package io.github.orizynpx.roomdbpractice

import android.app.Application
import io.github.orizynpx.roomdbpractice.data.repository.Repository
import io.github.orizynpx.roomdbpractice.data.source.AppDatabase

class MainApplication : Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val repository by lazy { Repository(database) }
}
