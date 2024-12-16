package com.example.foodrecipe.domain.usecase.recipe.general

import com.example.foodrecipe.data.data_source.api.dto.meal.toMeal
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class GetRandomMealsUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<Unit, List<Meal>>() {
    override suspend fun execute(params: Unit): List<Meal> {

        return repository.getRandomMeal().map { it.toMeal() }
    }
}