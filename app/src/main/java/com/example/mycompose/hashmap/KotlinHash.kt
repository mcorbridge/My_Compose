package com.example.mycompose.hashmap

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class KotlinHash {


    @Composable
    fun DoKotlinHash(navController: NavController) {
        //A simple example of HashMap class define
        // with empty "HashMap of <String, Int>"
        var hashMap: HashMap<String, NHLTeam> = HashMap()

        //printing the Empty hashMap
        printHashMap(hashMap)

        //adding elements to the hashMap using
        // put() function
        hashMap.put("Patrice Bergeron", NHLTeam("Boston","Bruins",37, "C",BirthPlace("L'Ancienne-Lorette, QC", "CAN")))
        hashMap.put("Anton Blidh", NHLTeam("Boston","Bruins",81, "LW",BirthPlace("Molnlycke", "SWE")))
        hashMap.put("Charlie Coyle", NHLTeam("Boston","Bruins",13, "C",BirthPlace("East Weymouth, MA", "USA")))
        hashMap.put("Jake DeBrusk", NHLTeam("Boston","Bruins",74, "LW",BirthPlace("Edmonton, AB", "CAN")))
        hashMap.put("Trent Frederic", NHLTeam("Boston","Bruins",11, "C",BirthPlace("St. Louis, MO", "USA")))
        hashMap.put("Taylor Hall", NHLTeam("Boston","Bruins",71, "LW",BirthPlace("Calgary, AB", "CAN")))
        hashMap.put("Cameron Hughes", NHLTeam("Boston","Bruins",53, "C",BirthPlace("Edmonton, AB", "CAN")))
        hashMap.put("Ondrej Kase", NHLTeam("Boston","Bruins",28, "RW",BirthPlace("Kadan", "CZE")))
        hashMap.put("David Krejci", NHLTeam("Boston","Bruins",46, "C",BirthPlace("Sternberk", "CZE")))
        hashMap.put("Karson Kuhlman", NHLTeam("Boston","Bruins",83, "C",BirthPlace("Esko, MN", "USA")))
        hashMap.put("Sean Kuraly", NHLTeam("Boston","Bruins",52, "C",BirthPlace("Dublin, OH", "USA")))
        hashMap.put("Curtis Lazar", NHLTeam("Boston","Bruins",20, "C",BirthPlace("Salmon Arm, BC", "CAN")))
        hashMap.put("Brad Marchand", NHLTeam("Boston","Bruins",63, "LW",BirthPlace("Halifax, NS", "CAN")))
        hashMap.put("Greg McKegg", NHLTeam("Boston","Bruins",18, "C",BirthPlace("St. Thomas, ON", "CAN")))
        hashMap.put("David Pastrnak", NHLTeam("Boston","Bruins",88, "RW",BirthPlace("Havirov", "CZE")))
        hashMap.put("Nick Ritchie", NHLTeam("Boston","Bruins",21, "LW",BirthPlace("Orangeville, ON", "CAN")))
        hashMap.put("Zach Senyshyn", NHLTeam("Boston","Bruins",19, "RW",BirthPlace("Ottawa, ON", "CAN")))
        hashMap.put("Craig Smith", NHLTeam("Boston","Bruins",12, "C",BirthPlace("Madison, WI", "USA")))
        hashMap.put("Oskar Steen", NHLTeam("Boston","Bruins",62, "C",BirthPlace("Karlstad", "SWE")))
        hashMap.put("Jack Studnicka", NHLTeam("Boston","Bruins",23, "C",BirthPlace("Windsor, ON", "CAN")))
        hashMap.put("Chris Wagner", NHLTeam("Boston","Bruins",14, "RW",BirthPlace("Walpole, MA", "USA")))
        hashMap.put("Jack Ahcan", NHLTeam("Boston","Bruins",54, "R",BirthPlace("Savage, MN", "USA")))
        hashMap.put("Brandon Carlo", NHLTeam("Boston","Bruins",25, "R",BirthPlace("Colorado Springs, CO", "USA")))
        hashMap.put("Connor Clifton", NHLTeam("Boston","Bruins",75, "L",BirthPlace("Long Branch, NJ", "USA")))
        hashMap.put("Matt Grzelcyk", NHLTeam("Boston","Bruins",48, "L",BirthPlace("Charlestown, MA", "USA")))
        hashMap.put("Jeremy Lauzon", NHLTeam("Boston","Bruins",55, "R",BirthPlace("Val-d'Or, QC", "CAN")))
        hashMap.put("Charlie McAvoy", NHLTeam("Boston","Bruins",73, "R",BirthPlace("Long Beach, NY", "USA")))
        hashMap.put("Kevan Miller", NHLTeam("Boston","Bruins",86, "L",BirthPlace("Los Angeles, CA", "USA")))
        hashMap.put("John Moore", NHLTeam("Boston","Bruins",27, "L",BirthPlace("Winnetka, IL", "USA")))
        hashMap.put("Mike Reilly", NHLTeam("Boston","Bruins",6, "L",BirthPlace("Chicago, IL", "USA")))
        hashMap.put("Jarred Tinordi", NHLTeam("Boston","Bruins",84, "L",BirthPlace("Millersville, MD", "TK")))
        hashMap.put("Urho Vaakanainen", NHLTeam("Boston","Bruins",58, "L",BirthPlace("Joensuu", "FIN")))
        hashMap.put("Jakub Zboril", NHLTeam("Boston","Bruins",67, "L",BirthPlace("Brno", "CZE")))
        hashMap.put("Jaroslav Halak", NHLTeam("Boston","Bruins",41, "G",BirthPlace("Bratislava", "SVK")))
        hashMap.put("Tuukka Rask", NHLTeam("Boston","Bruins",40, "G",BirthPlace("Savonlinna", "FIN")))
        hashMap.put("Jeremy Swayman", NHLTeam("Boston","Bruins",1, "G",BirthPlace("Anchorage, AK", "USA")))
        hashMap.put("Dan Vladar", NHLTeam("Boston","Bruins",80, "G",BirthPlace("Prague", "CZE")))

        // --------------------------------------------------------------------------------

        hashMap.put("Pierre Engvall", NHLTeam("Toronto", "Maple Leafs", 47,"LW",BirthPlace("Ljungby", "SWE")))
        hashMap.put("Nick Foligno", NHLTeam("Toronto", "Maple Leafs", 71,"LW",BirthPlace("Buffalo, NY", "USA")))
        hashMap.put("Alex Galchenyuk", NHLTeam("Toronto", "Maple Leafs", 12,"C",BirthPlace("MILWAUKEE, WI","USA")))
        hashMap.put("Zach Hyman", NHLTeam("Toronto", "Maple Leafs",11,"LW",BirthPlace("Toronto, ON", "CAN")))
        hashMap.put("Alexander Kerfoot", NHLTeam("Toronto", "Maple Leafs",15,"C",BirthPlace("Vancouver, BC","CAN")))
        hashMap.put("Kalle Kossila", NHLTeam("Toronto", "Maple Leafs", 48,"C",BirthPlace("Kauniainen","FIN")))
        hashMap.put("Denis Malgin", NHLTeam("Toronto", "Maple Leafs", 62,"C",BirthPlace("Olten","CHE")))
        hashMap.put("Mitchell Marner", NHLTeam("Toronto", "Maple Leafs",16,"RW",BirthPlace("Markham, ON","CAN")))
        hashMap.put("Auston Matthews", NHLTeam("Toronto", "Maple Leafs",  34,"C",BirthPlace("San Ramon, CA","USA")))
        hashMap.put("Ilya Mikheyev", NHLTeam("Toronto", "Maple Leafs", 65,"RW",BirthPlace("Omsk","RUS")))
        hashMap.put("Riley Nash", NHLTeam("Toronto", "Maple Leafs", 20,"C",BirthPlace("Consort, AB","CAN")))
        hashMap.put("Stefan Noesen", NHLTeam("Toronto", "Maple Leafs", 26,"RW",BirthPlace("Plano, TX","USA")))
        hashMap.put("William Nylander", NHLTeam("Toronto", "Maple Leafs", 88,"RW",BirthPlace("Calgary, AB","CAN")))
        hashMap.put("Scott Sabourin", NHLTeam("Toronto", "Maple Leafs", 49,"RW",BirthPlace("Orleans, ON", "CAN")))
        hashMap.put("Wayne Simmonds", NHLTeam("Toronto", "Maple Leafs", 24,"RW",BirthPlace("Scarborough, ON","CAN")))
        hashMap.put("Jason Spezza", NHLTeam("Toronto", "Maple Leafs", 19,"C",BirthPlace("Toronto, ON","CAN")))
        hashMap.put("John Tavares", NHLTeam("Toronto", "Maple Leafs", 91,"C",BirthPlace("Mississauga, ON","CAN")))
        hashMap.put("Joe Thornton", NHLTeam("Toronto", "Maple Leafs", 97,"C",BirthPlace("London, ON","CAN")))
        hashMap.put("Zach Bogosian", NHLTeam("Toronto", "Maple Leafs", 22,"D",BirthPlace("Massena, NY","USA")))
        hashMap.put("TJ Brodie", NHLTeam("Toronto", "Maple Leafs", 78,"D",BirthPlace("Chatham, ON","CAN")))
        hashMap.put("Travis Dermott", NHLTeam("Toronto", "Maple Leafs",  23,"D",BirthPlace("Newmarket, ON","CAN")))
        hashMap.put("Justin Holl", NHLTeam("Toronto", "Maple Leafs", 3,"D",BirthPlace("Tonka Bay, MN"," USA")))
        hashMap.put("Mac Hollowell", NHLTeam("Toronto", "Maple Leafs", 81,"D",BirthPlace("Niagara Falls, ON","CAN")))
        hashMap.put("Ben Hutton", NHLTeam("Toronto", "Maple Leafs", 55,"D",BirthPlace("Brockville, ON","CAN")))
        hashMap.put("Martin Marincin", NHLTeam("Toronto", "Maple Leafs", 52,"D",BirthPlace("Kosice","SVK")))
        hashMap.put("Jake Muzzin", NHLTeam("Toronto", "Maple Leafs", 8,"D",BirthPlace("Woodstock, ON","CAN")))
        hashMap.put("Morgan Rielly", NHLTeam("Toronto", "Maple Leafs", 44,"D",BirthPlace("Vancouver, BC","CAN")))
        hashMap.put("Calle Rosen", NHLTeam("Toronto", "Maple Leafs", 48,"D",BirthPlace("Vaxjo","SWE")))
        hashMap.put("Rasmus Sandin", NHLTeam("Toronto", "Maple Leafs", 38,"D",BirthPlace("Uppsala","SWE")))
        hashMap.put("Frederik Andersen", NHLTeam("Toronto", "Maple Leafs", 31,"G",BirthPlace("Herning", "DNK")))
        hashMap.put("Jack Campbell", NHLTeam("Toronto", "Maple Leafs",36,"G",BirthPlace("Port Huron, MI","USA")))
        hashMap.put("Michael Hutchinson", NHLTeam("Toronto", "Maple Leafs",30,"G",BirthPlace("Barrie, ON","CAN")))
        hashMap.put("David Rittich", NHLTeam("Toronto", "Maple Leafs", 33,"G",BirthPlace("Jihlava","CZE")))
        hashMap.put("Veini Vehvilainen", NHLTeam("Toronto", "Maple Leafs",35,"G",BirthPlace("Jyväskylä","FIN")))
        hashMap.put("Joseph Woll", NHLTeam("Toronto", "Maple Leafs", 60,"G",BirthPlace("Dardenne Prairie, MO","USA")))

        //printing the non-Empty hashMap
        printHashMap(hashMap)
        //using the overloaded print function of
        //Kotlin language to get the same results
        println("hashMap : $hashMap\n")

        //hashMap traversal using a for loop
        for (key in hashMap.keys) {
            println("Element at key $key : ${hashMap[key]}")
        }

        //creating another hashMap object with
        // the previous version of hashMap object
        var secondHashMap: HashMap<String, NHLTeam> = HashMap(hashMap)

        println("\n" + "Second HashMap : ")
        for (key in secondHashMap.keys) {
            //using hashMap.get() function to fetch the values
            println("Element at key $key : ${hashMap.get(key)}")
        }

        //this will clear the whole map and make it empty
        println("hashMap.clear()")
        hashMap.clear()

        println("After Clearing : $hashMap")

    }

    //function to print the hashMap
    fun printHashMap(hashMap: HashMap<String, NHLTeam>) {
        // isEmpty() function to check whether
        // the hashMap is empty or not
        if (hashMap.isEmpty()) {
            println("hashMap is empty")
        } else {
            println("hashMap : $hashMap")
        }
    }


}

data class NHLTeam(val city:String, val team:String, val num:Int, val position:String, val birthPlace:BirthPlace){

}

data class BirthPlace(val city: String, val country:String){}