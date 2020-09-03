import kotlin.math.abs
open class Circle{
    var radius: Double
    var center: MutableList<Double> = mutableListOf<Double>()
    constructor(radius:Double,center:MutableList<Double>){
        this.radius=radius
        this.center=center
    }
}
fun main() {
    println("** 실수 입력 가능 **")
    val c1 = makeCircle()
    val c2 = makeCircle()
    println("c1> 반지름:${c1.radius}, 중심 좌표:${c1.center}")
    println("c2> 반지름:${c2.radius}, 중심 좌표:${c2.center}")

    val distance = distance(c1, c2)
    println("c1과 c2 중심 간의 거리: $distance\n")

    println("원 c1 위의 임의의 점과 원 c2 위의 임의의 점 간의 거리 중 가장 짧은 것의 길이는 ${circleStatus(c1, c2)}\n")
}

fun makeCircle(): Circle {  //반환값 Circle
    println()
    val radius: Double
    var center: MutableList<Double> = mutableListOf<Double>()
    println("[ 원 생성하기 ]")
    print("x좌표: ")
    val x : Double = readLine()!!.toDouble()
    center.add(x)
    print("y좌표: ")
    val y : Double = readLine()!!.toDouble()
    center.add(y)
    print("반지름: ")
    radius = readLine()!!.toDouble()
    return Circle(radius,center)
}

fun distance(c1: Circle,c2: Circle): Double{
    val dX: Double = c1.center.get(0).toDouble()-c2.center.get(0).toDouble()
    val dY: Double = c1.center.get(1).toDouble()-c2.center.get(1).toDouble()
    val distance: Double = Math.sqrt(dX*dX+dY*dY)
    return distance
}

fun circleStatus(c1: Circle, c2: Circle): Double{
    val d = distance(c1,c2)
    val shortestD: Double
    if(c1.radius+c2.radius<d) {
        shortestD=d-c1.radius-c2.radius
        println("원 c1과 원 c2는 서로 밖에 존재한다.")
    }
    else if(c1.radius+c2.radius==d){
        shortestD=0.0
        println("원 c1과 원 c2는 외접한다.")
    }
    else if(Overlaped(c1,c2)<d){
        shortestD=0.0
        println("원 c1과 원 c2는 겹친다.")
    }
    else {
        if(c1.radius>c2.radius) {
            if(c1.radius-c2.radius==d) {
                shortestD=0.0
                println("원 c1과 원 c2는 내접한다.")
            }
            else {
                shortestD=c1.radius-(d+c2.radius);
                println("원 c2가 원 c1 안에 있다.")
            }
        }
        else {
            if(c2.radius-c1.radius==d) {
                shortestD= 0.0
                println("원 c1과 원 c2는 내접한다.")
            }
            else {
                shortestD=c2.radius-(d+c1.radius);
                println("원 c1이 원 c2 안에 있다.")
            }
        }
    }
    return shortestD
}

fun Overlaped(c1: Circle, c2: Circle): Double{
    val subtraction = abs(c1.radius-c2.radius)
    return subtraction
}
/*
a. 'Circle' 클래스를 선언하고, 그 속성으로 "반지름" "중심 좌표"를 각각 int, list로 구현하여라.
b. 사용자에게 1번 원, 2번 원에 대한 속성값을 입력받아 2개의 객체를 생성하여라.
c. 두 원 간의 거리와 반지름을 이용하여 1번 원의 중심과 2번 원의 중심 간의 거리를 구하여라.
d. 1번 원 위의 임의의 점과 2번 원 위의 임의의 점 간의 거리 중 가장 짧은 것의 길이를 구하여라.
+ 보너스 문제: 위에서 구한 정보들을 이용하여 1번 원과 2번 원이 서로 밖에 있는지, 외접하는지,
내접하는지, 겹치는지, 한 원이 다른 원 안에 있는지에 대한 여부를 출력하여라.
 */
