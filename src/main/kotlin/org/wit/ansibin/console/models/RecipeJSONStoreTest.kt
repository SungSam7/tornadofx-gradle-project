package org.wit.ansibin.console.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random
class RecipeJSONStoreTest {
    val recipeStore = RecipeJSONStore()

    @org.junit.jupiter.api.Test
    fun findAll() {
        val test1 = RecipeModel(0,"Rice Krispies", "A bowl of blandness")
        recipeStore.create(test1)
        assertEquals(recipeStore.findAll().size, recipeStore.recipes.size)
    }

    @org.junit.jupiter.api.Test
    fun findOne() {
//        val test1 = RecipeModel(title = "Chicken Fajita",description = "Mexican")
//        recipeStore.create(test1)
//        assertEquals(
//        recipeStore.recipes[recipeStore.recipes.size -1],
//        recipeStore.findOne(recipeStore.recipes[recipeStore.recipes.size - 1].id))
    }

    @org.junit.jupiter.api.Test
    fun create() {
        val test1 = RecipeModel(0,"Chicken Fajita", "Mexican")
        recipeStore.create(test1)
    }

    @org.junit.jupiter.api.Test
    fun update() {
        val updating = recipeStore.recipes[0]
        val newDescription = "Chinese, Indian"
        updating.description = newDescription
        recipeStore.update(updating)
        assertEquals(updating.description, newDescription)
    }

    @org.junit.jupiter.api.Test
    fun delete() {
    }
}