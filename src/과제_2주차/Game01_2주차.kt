package 과제_2주차

open class Object(var hp: Int,var gold: Int)

class Char: Object{
    var atk: Int
    var exp: Int
    constructor(hp:Int, gold:Int, atk:Int, exp:Int):super(hp,gold){
        this.atk=atk
        this.exp=exp
    }
}
fun main() {
    println("== 게임 시작 ==")
    val player = makeChar()
    val monster = makeChar()
    var cnt = 1 //전투 횟수

    while (true) { //a 또는 b가 이길 때까지 전투 반복
        println("\n[전투 ${cnt}회]")
        val play = combat(player, monster)
        if (play == 0) {
            break
        }
        cnt += 1
    }
    println()
}

fun makeChar(): Char{   //캐릭터 생성 메서드
    println("\n[ 캐릭터 생성 ]")
    print("hp: ")
    val hp: Int = readLine()!!.toInt()
    print("atk: ")
    val atk: Int = readLine()!!.toInt()
    print("exp: ")
    val exp: Int = readLine()!!.toInt()
    print("gold: ")
    val gold: Int = readLine()!!.toInt()
    return Char(hp, atk, exp, gold)
}

fun critical(): Double{ //크리티컬 공격 메서드 (1/5 확률)
    val randNum = (Math.random() * 5).toInt()
    if (randNum == 0) {
        println("☆ 크리티컬 공격! ☆")
        return 2.5
    }
    return 1.0
}

fun combat(a: Char,b: Char): Int{   //전투 메서드
    println("a가 b를 공격했다!")
    var res = 1
    b.hp -= a.atk * critical().toInt()
    if (b.hp <= 0) {
        println("전투 종료!")
        println("\n==========☆★☆★==========")
        println("\t\t[a 승리]")
        a.exp += b.exp
        a.gold += b.gold
        println("   a의 exp: ${a.exp}")
        println("   a의 gold: ${a.gold}")
        println("==========☆★☆★==========")
        res = 0
    } else {
        println("b의 체력 = ${b.hp}")
        println("b가 a를 공격했다!")
        a.hp -= b.atk * critical().toInt()
        if (a.hp <= 0) {
            println("전투 종료!")
            println("\n==========☆★☆★==========")
            println("\t\t[b 승리]")
            b.exp += a.exp
            b.gold += a.gold
            println("   b의 exp: ${b.exp}")
            println("   b의 gold: ${b.gold}")
            println("==========☆★☆★==========")
            res = 0
        } else {
            println("a의 체력 = ${a.hp}")
        }
    }
    return res
}
/*
2. 다음의 순서대로 작동하는 코드를 작성하시오.
a. 'object' 클래스를 선언하고, 그 속성으로 'hp', 'gold'을 선언한다.
b. 'char' 클래스는 'object' 클래스에서 'hp', 'gold'을 상속하고, 추가로 'atk'과 'exp'라는 값을 선언한다.
c. 'char' 클래스를 이용한 객체 'player'와 'monster'를 선언하고, hp, atk, exp, gold를 유저 인풋으로 받는다.
d. 'combat(a, b)' 함수(또는 메소드)를 정의한다. 처리 과정은 다음과 같다.
    1) "a가 b를 공격했다!"를 출력한다.
    2) a의 atk만큼 b의 hp을 감소시킨다.
    3) 만약 b의 hp가 0 이하가 되었다면, "전투 종료!"를 출력한다.
        그렇지 않다면, "b의 체력 = b.hp"을 출력한다.
e. player과 monster간의 전투를 combat(player, monster)를 이용하여 구현하되, player의 공격 이후에
monster의 공격이 이어지도록 코드를 작성한다.
이때, combat 메소드를 변형해도 좋다.
f. 전투 종료시 hp가 0이 된 측의 exp와 gold를 이긴 사람의 exp와 gold에 더하고, 가지고 있는 총 골드와 exp를 출력해준다.
+보너스 문제: 공격력에 랜덤 요소를 집어넣어 크리티컬 공격(데미지 250%)을 구현하여라.
+추가 점수 요소: 화면을 꾸밀 수 있을 만큼 게임스럽게 꾸며 보시오.
*/