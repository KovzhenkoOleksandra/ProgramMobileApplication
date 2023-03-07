fun makingCoffee(){
    println(
        "Starting to make a coffee in NIX office\n" +
            "Grinding coffee beans\n" +
            "Boiling water\n" +
            "Mixing boiled water with crushed coffee beans\n" +
            "Pouring coffee into the cup\n" +
            "Pouring some milk into the cup\n" +
            "Coffee is ready! Go to work!"
    )
}
fun calculationOfTheNumberOfIngredients(count: Int){
    println("For $count cups of coffee you will need:")
    val amountOfWater = 200 * count
    val amountOfMilk = 50 * count
    val amountOfCoffeeBeans = 15 * count
    println(
        "$amountOfWater ml of water\n" +
            "$amountOfMilk ml of milk\n" +
            "$amountOfCoffeeBeans g of coffee beans"
    )
}
fun checkingTheQuantityOfIngredients(hasWater: Int, hasMilk: Int, hasCoffeeBeans: Int, needCups: Int){
    val cupsByWater = hasWater / 200
    val cupsByMilk = hasMilk / 50
    val cupsByCoffeeBeans = hasCoffeeBeans / 15
    val cupsCanBeMade = minOf(cupsByWater, cupsByMilk, cupsByCoffeeBeans)
    when {
        needCups == cupsCanBeMade -> println("Yes, I can make that amount of coffee")
        needCups < cupsCanBeMade -> {
            val additionalCups = cupsCanBeMade - needCups
            println("Yes, I can make that amount of coffee (and even $additionalCups more than that)")
        }
        else -> println("No, I can make only $cupsCanBeMade cups of coffee")
    }
}
fun  controlledCoffeeMachine(){
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var cups = 9
    var money = 550
    println(
        "The coffee machine has:\n" +
            "$water of water\n" +
            "$milk of milk\n" +
            "$coffeeBeans of coffee beans\n" +
            "$cups of disposable cups\n" +
            "$money of money\n" +
            "Write action (buy, fill, take):"
    )
    when (readln()) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
            when (readln().toInt()) {
                1 -> {
                    water -= 250
                    coffeeBeans -= 16
                    money += 4
                    cups -= 1
                }

                2 -> {
                    water -= 350
                    milk -= 75
                    coffeeBeans -= 20
                    money += 7
                    cups -= 1
                }

                3 -> {
                    water -= 200
                    milk -= 100
                    coffeeBeans -= 12
                    money += 6
                    cups -= 1
                }
            }
        }
        "fill" -> {
            println("Write how many ml of water you want to add:")
            water += readln().toInt()
            println("Write how many ml of milk you want to add:")
            milk += readln().toInt()
            println("Write how many grams of coffee beans you want to add:")
            coffeeBeans += readln().toInt()
            println("Write how many disposable coffee cups you want to add:")
            cups += readln().toInt()
        }
        "take" -> {
            println("I gave you $money\n")
            money = 0
        }
    }
    println("The coffee machine has:\n" +
            "$water of water\n" +
            "$milk of milk\n" +
            "$coffeeBeans of coffee beans\n" +
            "$cups of disposable cups\n" +
            "$money of money")
}

class CoffeeMachine(var water: Int, var milk: Int, var coffeeBeans: Int, var cups: Int, var money: Int){
    fun status(){
        println(
            "The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$coffeeBeans of coffee beans\n" +
                "$cups of disposable cups\n" +
                "$money of money"
        )
    }
    fun makeEspresso(){
        if (water < 250){
            println("Sorry, not enough water!")
        }
        else if (coffeeBeans < 16){
            println("Sorry, not enough coffee beans!")
        }
        else if (cups < 1){
            println("Sorry, not enough disposable cups!")
        }
        else {
            println("I have enough resources, making you a coffee!")
            water -= 250
            coffeeBeans -= 16
            cups -= 1
            money += 4
        }
    }
    fun makeLatte(){
        if (water < 350){
            println("Sorry, not enough water!")
        }
        else if (milk < 75){
            println("Sorry, not enough milk!")
        }
        else if (coffeeBeans < 20){
            println("Sorry, not enough coffee beans!")
        }
        else if (cups < 1){
            println("Sorry, not enough disposable cups!")
        }
        else {
            println("I have enough resources, making you a coffee!")
            water -= 350
            milk -= 75
            coffeeBeans -= 20
            cups -= 1
            money += 7
        }
    }
    fun makeCappuccino(){
        if (water < 200){
            println("Sorry, not enough water!")
        }
        else if (milk < 100){
            println("Sorry, not enough milk!")
        }
        else if (coffeeBeans < 12){
            println("Sorry, not enough coffee beans!")
        }
        else if (cups < 1){
            println("Sorry, not enough disposable cups!")
        }
        else {
            println("I have enough resources, making you a coffee!")
            water -= 200
            milk -= 100
            coffeeBeans -= 12
            cups -= 1
            money += 6
        }
    }
    fun fill(addWater: Int, addMilk: Int, addCoffeeBeans: Int, addCups: Int){
        water += addWater
        milk += addMilk
        coffeeBeans += addCoffeeBeans
        cups += addCups
    }
    fun take(){
        println("I gave you $money")
        money = 0
    }
}
fun main(){
//    makingCoffee()
//    println()
//    println("Write how many cups of coffee you will need:")
//    val count = readln().toInt()
//    calculationOfTheNumberOfIngredients(count)
//    println()
//    println("Write how many ml of water the coffee machine has:")
//    val hasWater = readln().toInt()
//    println("Write how many ml of milk the coffee machine has:")
//    val hasMilk = readln().toInt()
//    println("Write how many grams of coffee beans the coffee machine has:")
//    val hasCoffeeBeans = readln().toInt()
//    println("Write how many cups of coffee you will need:")
//    val needCups = readln().toInt()
//    checkingTheQuantityOfIngredients(hasWater, hasMilk, hasCoffeeBeans, needCups)
//    controlledCoffeeMachine()
    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)
    while (true){
        println()
        println("Write action (buy, fill, take, remaining, exit): ")
        val action = readln()
        println()
        when (action) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                when (readln()){
                    "1" -> coffeeMachine.makeEspresso()
                    "2" -> coffeeMachine.makeLatte()
                    "3" -> coffeeMachine.makeCappuccino()
                    "back" -> return
                }
            }
            "fill" -> {
                println("Write how many ml of water you want to add:")
                val addWater = readln().toInt()
                println("Write how many ml of milk you want to add:")
                val addMilk = readln().toInt()
                println("Write how many grams of coffee beans you want to add:")
                val addCoffeeBeans = readln().toInt()
                println("Write how many disposable coffee cups you want to add:")
                val addCups = readln().toInt()
                coffeeMachine.fill(addWater, addMilk, addCoffeeBeans, addCups)
            }
            "take" -> {
                coffeeMachine.take()
            }
            "remaining" -> {
                coffeeMachine.status()
            }
            "exit" -> {
                break
            }
        }
    }
}