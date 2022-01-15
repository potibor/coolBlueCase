package com.hsnozan.coolbluecase.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by hsnozan on 15.01.2022.
 */

abstract class UseCase<out Type : Any, in Params> {

    protected abstract suspend fun buildUseCase(params: Params): Type

    suspend fun run(params: Params): Either<Throwable, Type> = withContext(Dispatchers.IO) {
        try {
            Either.Right(buildUseCase(params))
        } catch (failure: Throwable) {
            Either.Left(failure)
        }
    }

    object None {
        override fun toString() = "UseCase.None"
    }
}