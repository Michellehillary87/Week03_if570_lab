package example.myapp

class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}
//class Plecostomus: FishAction, FishColor by GoldColor{
//    //override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}
class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("Eat algae"),
    FishColor by fishColor{ //fishColor
    override fun eat() {
        println("eat algae")
    }
}
class PrintingFishAction(val food : String) : FishAction {
    override fun eat (){
        println(food)
    }
}
interface FishAction{
    fun eat()
}
interface FishColor {
    val color: String
}
abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum")
    }
object GoldColor : FishColor {
    override val color = "gold"
}
//Shark: grey
//hunt and eat fish
//Plecostomus: gold
//eat algae
//Shark : grey
//Plecostomus: gold
