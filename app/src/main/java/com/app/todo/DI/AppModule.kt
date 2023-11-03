package com.app.todo.DI

import android.app.Application
import androidx.room.Room
import com.app.todo.DataSource.LocalDataSource.Remote.Repository.BuyItemRepositoryImp
import com.app.todo.DataSource.LocalDataSource.Remote.Repository.CallsRepositoryImp
import com.app.todo.DataSource.LocalDataSource.Repository.SellItemRepositoryImp
import com.app.todo.DataSource.LocalDataSource.TodoDatabase
import com.app.todo.Domain.Repositories.SellItemUseCase.AddItem
import com.app.todo.Domain.Repositories.SellItemUseCase.GetItems
import com.app.todo.Domain.Repositories.SellItemUseCase.RemoveItem
import com.app.todo.Domain.Repositories.SellItemUseCase.SellItemUseCase
import com.app.todo.Domain.Repositories.SellItemUseCase.UpdateItem
import com.app.todo.Domain.Repository.Repositories.BuyItemRepository
import com.app.todo.Domain.Repository.Repositories.CallsRepository
import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideSellRepository(db: TodoDatabase): SellItemRepository {
        return SellItemRepositoryImp(db.todoDao)
    }

    @Provides
    @Singleton
    fun provideCallsRepository(): CallsRepository {
        return CallsRepositoryImp()
    }

    @Provides
    @Singleton
    fun provideBuyRepository(): BuyItemRepository {
        return BuyItemRepositoryImp()
    }

    @Provides
    @Singleton
    fun provideSellItemUseCases(repository: SellItemRepository): SellItemUseCase {
        return SellItemUseCase(
            addItem = AddItem(repository),
            getItems = GetItems(repository),
            removeItem = RemoveItem(repository),
            updateItem = UpdateItem(repository)
        )
    }
}