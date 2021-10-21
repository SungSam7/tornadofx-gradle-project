package org.wit.ansibin.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

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
        var foundRecipe: RecipeModel? = recipes.find { p -> p.id == id }
        return foundRecipe
    }

    override fun create(recipe: RecipeModel) {
        recipe.id = getId()
        recipes.add(recipe)
        logAll()
    }

    override fun update(recipe: RecipeModel) {
        var foundRecipes = findOne(recipe.id!!)
        if (foundRecipes != null) {
            foundRecipes.title = recipe.title
            foundRecipes.description = recipe.description
        }
    }

    override fun delete(recipe: RecipeModel) {
        recipes.remove(recipe)
    }

    internal fun logAll() {
        recipes.forEach { logger.info("${it}") }
    }
}