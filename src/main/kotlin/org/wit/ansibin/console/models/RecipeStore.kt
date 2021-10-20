package org.wit.ansibin.console.models

interface RecipeStore {

    fun findAll(): List<RecipeModel>
    fun findOne(id: Long): RecipeModel?
    fun create(ansibin: RecipeModel)
    fun update(ansibin: RecipeModel)
    fun delete(ansibin: RecipeModel)
}