package ru.netimen.m3test

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import ru.netimen.itemslib.data.ItemsLoader

@HiltAndroidApp
class MainApplication : Application()

@Module
@InstallIn(ActivityComponent::class)
abstract class Module {
    @Binds abstract fun bindItemsLoader(loaderImpl: ItemsLoaderImpl): ItemsLoader
}