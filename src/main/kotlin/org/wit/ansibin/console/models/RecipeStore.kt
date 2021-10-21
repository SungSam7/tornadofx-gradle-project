package org.wit.ansibin.console.models

interface RecipeStore {
    fun findAll(): List<RecipeModel>
    fun findOne(id: Long): RecipeModel?
    fun create(recipe: RecipeModel)
    fun update(recipe: RecipeModel)
    fun delete(recipe: RecipeModel)
}