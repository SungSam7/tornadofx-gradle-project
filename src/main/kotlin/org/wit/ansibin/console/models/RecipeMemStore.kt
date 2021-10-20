package org.wit.ansibin.console.models

import mu.KotlinLogging
import org.wit.ansibin.console.models.RecipeModel
import org.wit.ansibin.console.models.RecipeStore



var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class RecipeMemStore : RecipeStore {

    val recipes = ArrayList<RecipeModel>()

    override fun findAll(): List<RecipeModel> {
        return recipes
    }

    override fun findOne(id: Long) : RecipeModel? {
        var foundRecipes: RecipeModel? = recipes.find { p -> p.id == id }
        return foundRecipes
    }

    override fun create(recipe: RecipeModel) {
        recipe.id = getId()
        recipes.add(recipe)
        logAll()
    }

    override fun update(recipe: RecipeModel) {
        var foundRecipe = findOne(recipe.id!!)
        if (foundRecipe != null) {
            foundRecipe.title = recipe.title
            foundRecipe.description = recipe.description
        }
    }

    override fun delete(recipe: RecipeModel) {
        recipes.remove(recipe)
    }

    internal fun logAll() {
       recipes.forEach { println("${it}") }
    }
}