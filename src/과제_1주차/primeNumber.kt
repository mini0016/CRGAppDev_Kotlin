package 과제_1주차


fun main(args:Array<String>){
    // true 500개 넣기
    var number=mutableListOf<Boolean>()
    for (x in 1..500){
        number.add(true)
    }
    // 1,2는 소수 x
    number[0]=false
    number[1]=false

    // m=int(500**0.5)
    val maximum: Double = Math.sqrt(500.toDouble())
    val m: Int = maximum.toInt()

    // 2~m 범위만큼 반복
    for (x in 2..m){
        if (number[x]){
            for (y in x+x..499 step x) {
                number[y] = false
            }
        }
    }
    // 2를 제외한 2의 배수 제거
    var prime=mutableListOf<Int>()
    for (x in 0..499){
        if(number[x]==true){
            prime.add(x)
        }
    }
    println(prime)
}

