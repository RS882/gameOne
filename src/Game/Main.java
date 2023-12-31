package Game;


import Game.Entity.Entity;
import Game.Entity.Monster;
import Game.Entity.Player;
import Game.Players.Archer;
import Game.Players.Mage;
import Game.Players.Warrior;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Hi! Choose a class: ");
        System.out.println(" enter 1 to Warrior;");
        System.out.println(" enter 2 to Mage;");
        System.out.println(" enter 3 to Archer;");
           char numClass = sc.nextLine().charAt(0);

         sc.nextLine();
        System.out.println("Enter your character's name: ");
     String charName = sc.nextLine();

        Player player = null;
        switch (numClass) {
            case '1':
                player = new Warrior(charName);
                break;
            case '2':
                player = new Mage(charName);
                break;
            case '3':
                player = new Archer(charName);
                break;
            default:
                System.out.println("wrong choice(");
        }

        Monster monster = new Monster("Tyzik");

        if (player != null) {
            System.out.println(player);
            System.out.println(monster);
            System.out.println("-----------Fight!------------------------");

            while (true) {
                player.attack(monster);
                monster.takeDamage(player);

                if (winOrLos(player, monster) !=null) {
                    System.out.println("--------------");
                    System.out.println(winOrLos(player, monster));
                    break;
                }
                monster.attack(player);
                player.takeDamage(monster);

                if (winOrLos(player, monster) !=null) {
                    System.out.println("--------------");
                    System.out.println(winOrLos(player, monster));
                    break;
                }
                System.out.println("Do you want to keep fighting?");
                System.out.println(" Enter 1 - yes");
                System.out.println(" Enter any key - no");
                char go = sc.nextLine().charAt(0);
                if (go != '1') {
                    System.out.println("Draw");
                    break;
                }

            }
        } else {
            System.out.println("There will be no fight. The player didn't show up.");
            System.out.println(monster);
        }


    }

    public static String winOrLos(Entity p, Entity m) {
        if (!p.isAlive()) return "You lost (";
        else if (!m.isAlive()) return "You win!";
        return null;
    }
}


//Сложность: легко (3/10)
//
//        Создаем свою первую игру.
//
//        Разработать абстрактный класс Существо (Game.Entity.Entity), для него определить поля имя (String),
//        количество здоровья (int) и сила атаки (int).
//        Добавить метод isAlive() возвращающий true если здоровье существа выше 0 и false
//        если равно или ниже 0.
//        Применить инкапсуляцию, переопределить методы equals, hashCode и toString.
//
//        Добавить классы Монстр и Игрок, которые будут наследовать класс Существо.
//        Класс Игрок должен быть абстрактным.
//        task part 2
//
//        Сложность: средне (4/10)
//
//        Наследовать от класса Игрок три класса - Маг, Воин и Лучник.
//        Для мага определить поле количество маны (double).
//        Для воина определить поле количество брони (int).
//        Применить инкапсуляцию, переопределить методы equals, hashCode и toString так
//        чтобы в них были учтены новые поля.
//        task part 3
//
//        Сложность: средне (6/10)
//
//        Создать интерфейс Attackable. В нем определить методы:
//        1. void attack(Attackable target) - позволяет атаковать кого-то, кого можно атаковать
//        2. void takeDamage(Attackable source) - позволяет получить урон от кого-то
//
//        Сделать так чтобы классы Монстр, Маг, Воин и Лучник реализовывали этот интерфейс.
//
//        Правила игры (должны быть отображены в реализации методов из интерфейса):
//
//        Монстр - атакует и получает урон как есть.
//        Т.е. если монстра с 10 здоровья атаковать с силой 5, у монстра отнимется 5 здоровья,
//        а если монстр атакует, то его сила атаки равна исходной силе атаки, указаной в соответствующем поле.
//
//        Маг - атакует в два раза больше силы атаки если у него достаточно маны. Каждую атаку тратится
//        1 маны.
//        Если у мага меньше 1 маны, не наносит урон вообще.
//        Когда маг получает урон, он восстанавливает 0.2 маны.
//
//        Воин - атакует ровно с такой же силой как и значение его силы атаки.
//        Получаемый урон уменьшается на половину значения брони.
//        Т.е. если у воина 10 здоровья и 2 брони, и его атакуют с силой 4, ему нанесется 3 единицы
//        урона вместо 4.
//
//        Лучник - атакует и получает урон без модификаций.
//        При атаке имеет шанс 20% нанести двойной урон.
//
//        Подсказка: вы можете подумать самостоятельно как реализовать метод для рассчета шанса,
//        либо можете воспользоваться
//        методом в дополнении к заданию (внизу).
//
//        При получении урона Лучник имеет шанс 25% уклониться от атаки и получить 0 единиц урона.
//
//        Все произошедшее в этих методах должно быть выведено в консоль.
//
//        Например:
//
//        Монстр (имя) получил 4 урона! Теперь его здоровье - 1.
//        Лучник (имя) уклонился от атаки!
//        Маг (имя) не смог атаковать так как у него закончилась мана!
//        Монстр (имя монстра) атакует игрока (имя игрока) с силой 3!
//        Маг (имя игрока) атакует монстра (имя монстра) с силой 6!
//        task part 4
//
//        Сложность: средне (6/10)
//
//        Создать класс Game.Main, в нем создать метод main.
//        В начале спросить у пользователя, какой боевой класс он хочет выбрать (цифра от 1 до 3)
//        Далее спросить имя игрока.
//        Создать переменную класса Game.Entity.Player, инициализировать объектом соответствующего класса (маг, воин или лучник).
//        Значения атаки, здоровья и уникальных полей для объектов игрока указать фиксированными числами в коде.
//        Также создать монстра, с которым игрок будет сражаться.
//        В качестве атаки и здоровья монстра указать случайные числа в диапазоне от 1 до 20.
//
//        Перед началом боя вывести игрока и монстра в консоль для информации.
//
//        Бой должен происходить таким образом: игрок и монстр по очереди атакуют друг друга.
//        После каждого обмена ударами должен выводиться вопрос "продолжить сражение?".
//        Если пользователь введет да, сражение продолжается, если нет, сражение заканчивается ничьей.
//        Сражение происходит до тех пор, пока монстр не будет повержен (вывести сообщение о выигрыше в таком случае),
//        либо пока игрок не будет убит (вывести сообщение о проигрыше в таком случае).
//        Дополнение:
//
//public boolean eventShouldOccur(double chance) {
//        return new Random().nextInt(100) < chance;}