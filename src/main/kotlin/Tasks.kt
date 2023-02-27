import java.util.Calendar
fun evenOrOdd(number: Int) {
    if (number % 2 == 0) {
        println("Even")
    } else {
        println("Odd")
    }
}
fun multiply(number: Int){
    if (number % 2 == 0) {
        val res1 = number * 4
        println("$number * 4 = $res1")
    } else {
        val res2 = number * 5
        println("$number * 5 = $res2")
    }
}
fun negative(number: Int){
    println(-number)
}
fun age(year: Int){
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val age = currentYear - year
    println(age)
}
fun minNumber(array: IntArray){
    var min = array[0]
    for (i in 1 until array.size){
        if (array[i] < min){
            min = array[i]
        }
    }
    println("Найменше число масиву: $min")
}
fun twoMaxNumbers(array: IntArray) {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    for (i in array.indices){
        if (array[i] > max1){
            max2 = max1
            max1 = array[i]
        }else
            if (array[i] > max2){
                max2 = array[i]
            }
    }
    println("Два найбільші числа у масиві: $max1 та $max2")
}
fun arrayIntNumbers(array: IntArray){
    var positive = 0
    var negative = 0
    for (number in array){
        if (number > 0){
            positive++
        }else
            if (number < 0){
                negative += number
            }
    }
    println("Кількість позитивних чисел $positive, а сума негативних складає $negative")
}
fun countVowels(array: String){
    var count = 0
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y')
    val arr = array.toCharArray()
    for (char in arr){
        if (char in vowels){
            count++
        }
    }
    println("Кількість голосних букв складає $count")
}
fun middle(array: String){
    val middle = array.length / 2
    if (array.length % 2 == 0){
        val chars = array.substring(middle - 1, middle + 1)
        println("Середні два символи рядка: $chars")
    }else{
        val char = array.substring(middle, middle + 1)
        println("Середній символ рядка: $char")
    }

}
fun multiplicationTable(size: Int): Array<IntArray>{
    val multipleTable = Array(size) {IntArray(size)}
    for (i in 0 until size){
        for (j in 0 until size){
            multipleTable[i][j] = (i + 1) * (j + 1)
        }
    }
    return multipleTable
}
fun main(){
    println("Введіть число:")
    val num1 = readln().toInt()
    evenOrOdd(num1)
    println("\nВведіть число:")
    val num2 = readln().toInt()
    multiply(num2)
    println("\nВведіть число:")
    val num3 = readln().toInt()
    negative(num3)
    println("\nВведіть ваш рік народження:")
    val year = readln().toInt()
    age(year)
    println("\nВведіть масив цілих чисел")
    val inputLine1 = readln()
    val arr1 = inputLine1.split(" ").map{it.toInt()}.toIntArray()
    minNumber(arr1)
    println("\nВведіть масив цілих чисел")
    val inputLine2 = readln()
    val arr2 = inputLine2.split(" ").map{it.toInt()}.toIntArray()
    twoMaxNumbers(arr2)
    println("\nВведіть масив цілих чисел")
    val inputLine3 = readln()
    val arr3 = inputLine3.split(" ").map{it.toInt()}.toIntArray()
    arrayIntNumbers(arr3)
    println("\nВведіть рядок символів")
    val inputLine4 = readln()
    countVowels(inputLine4)
    println("\nВведіть рядок символів")
    val inputLine5 = readln()
    middle(inputLine5)
    println("\nВведіть розмір таблиці множення")
    val size = readln().toInt()
    val table = multiplicationTable(size)
    println(table.contentDeepToString())
}
