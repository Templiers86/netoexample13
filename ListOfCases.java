import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfCases {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> wishlist = new ArrayList<>();

        while (true) {

            System.out.println(" Выберите пункт: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");

            String points = sc.nextLine();

            switch (points) {
                case "0":
                    System.out.println("Выход из программы");
                    sc.close();
                    return;

                case "1":
                    System.out.println("Введите дело:");
                    String newTask = sc.nextLine();

                    if (newTask.isEmpty()) {
                        System.out.println("Напиши сюдой чЁнить");
                    } else if (wishlist.contains(newTask)) {
                        System.out.println("Это уже есть");
                    } else {
                        wishlist.add(newTask);
                        System.out.println("Добавил");
                    }
                    showCase(wishlist);
                    break;

                case "2":
                    showCase(wishlist);
                    break;

                case "3":
                    if (wishlist.isEmpty()) {
                        System.out.println(" Как пел Кинчев: Ты свободен ");
                        break;
                    }

                    System.out.println(" Введите номер для удаления дела ");
                    try {
                        int number = Integer.parseInt(sc.nextLine());
                        if (number < 1 || number > wishlist.size()) {
                            System.out.println("Нет таких делов");
                        } else {
                            wishlist.remove(number - 1);
                            System.out.println("Дело удалено");
                        }
                    } catch (Exception e) {
                        System.out.println("Введён некорректный номер");
                    }
                    showCase(wishlist);
                    break;
                case "4":
                    if (wishlist.isEmpty()) {
                        System.out.println(" Как пел Кинчев: Ты свободен ");
                        break;
                    }
                    System.out.println(" Введите какую задачу удалить ");
                    String theVeryTask = sc.nextLine();
                    if (wishlist.remove(theVeryTask)) {
                        System.out.println("Дело удалено");
                    } else {
                        System.out.println("Нет такого дела");
                    }
                    showCase(wishlist);
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
    }

    private static void showCase(List<String> wishlist) {
        if (wishlist.isEmpty()) {
            System.out.println("Нет списка дел");
        } else {
            System.out.println(" Список дел: ");
            for (int i = 0; i < wishlist.size(); i++) {
                System.out.println((i + 1) + ":" + wishlist.get(i));

            }
        }
    }
}
