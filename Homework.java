import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
Реализовать консольное приложение, которое:
1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная
была первой в списке, а первая - последней.
3. Если введено revert, удаляет предыдущую введенную строку из памяти.
4. Если введено exit, то программа завершается

> - ввод в консоль (stdin), < - вывод на консоль (stdout)
> java
> python
> c#
> print
< [c#, python, java]
> revert
> print
< [python, java]
> revert
> revert
> print
< []
> revert -> throw new NoSuchElementException
 */

class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> resulList = new LinkedList<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                System.exit(0);
            }

            if (command.equals("print")) {
                for (int i = 0; i < list.size(); i++) {
                    resulList.add((list.get(list.size() - 1 - i)));
                }
                System.out.println(resulList);
                resulList.clear();

            } else if (command.equals("revert")) {
                try {
                    list.removeLast();
                } catch (NoSuchElementException e) {
                    System.out.println("List is empty.");
                }
            } else {
                list.add(command);
            }
        }
    }
}