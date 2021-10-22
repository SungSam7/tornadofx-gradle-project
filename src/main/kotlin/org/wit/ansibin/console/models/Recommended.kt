package org.wit.ansibin.console.models

class Recommended{

    fun recommended(protein: String= "") : String
    {
        if(protein == "chicken")
        {
            return println("chicken soup").toString()
        }
        else if (protein == "beef")
        {
            return println("Beef Lasagne").toString()
        }
        else
            return println("please enter a valid protein").toString()
    }


}