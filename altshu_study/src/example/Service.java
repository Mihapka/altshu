package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Service {

    int menuItem;
    String searchData;
    Repository repository = new Repository();
    String mainMenu = """
            1 - Вывести всех людей и их данные.
            2 - Найти человека по имени, номеру телефона, электронной почте.
            3 - Добавить человека.
            4 - Удалить человека с определенным номером телефона.
            5 - Редактировать данные участника с определенным номером телефона.
            6 - Завершить выполнение.""";
    String searchMenu = """
            По какому параметру ищем?
            1 - по имени
            2 - по номеру телефона
            3 - по почте""";

    public void work() {

        repository.addEntry(new Person(
                "999",
                "qq",
                "ww",
                new String[]{"ema", "il", "com"},
                "address"));

        System.out.println(mainMenu);

        while (true) {
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
                menuItem = Integer.parseInt(buffer.readLine());
                switch (menuItem) {
                    case 1 -> menuItemOne();
                    case 2 -> menuItemTwo();
                    case 3 -> menuItemThree();
                    case 4 -> menuItemFour();
                    case 5 -> menuItemFive();
                    case 6 -> menuItemSix();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void menuItemOne() {

        repository.showAllUsers();
        System.out.println("1 - вернуться в главное меню.");

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            if ((menuItem = Integer.parseInt(buffer.readLine())) == 1) {
                work();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void menuItemTwo() {

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(searchMenu);
            menuItem = Integer.parseInt(buffer.readLine());
            System.out.println("Введите данные для поиска.");
            searchData = buffer.readLine();

            if (menuItem == 1) {
                List<Person> list = repository.searchByFirstOrLastName(searchData);
                if (list.size() > 0) {
                    list.forEach(System.out::println);
                    work();
                } else {
                    System.out.println("Запись не найдена." + "\n");
                    work();
                }
            }

            if (menuItem == 2) {
                Person p = repository.searchByPhoneNumber(searchData);
                if (p == null) {
                    System.out.println("Запись не найдена." + "\n");
                    work();
                } else {
                    System.out.println(p);
                    work();
                }
            }

            if (menuItem == 3) {
                Person p = repository.searchByEmail(searchData);
                if (p == null) {
                    System.out.println("Запись не найдена." + "\n");
                    work();
                } else {
                    System.out.println(p);
                    work();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void menuItemThree() {

        System.out.println("Введите номер телефона.");
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            searchData = buffer.readLine();
            if (repository.keyVerification(searchData)) {
                System.out.println("Запись с таким телефоном уже существует:");
                System.out.println(repository.searchByPhoneNumber(searchData));
                System.out.println("""
                        Выберите дальнейшие действия:
                        1 - вернуться в главное меню
                        2 - редактировать имеющегося участника""");


                menuItem = Integer.parseInt(buffer.readLine());
                if (menuItem == 1) {
                    work();
                }
                if (menuItem == 2) {
                    editingUser(searchData);
                }
            } else {
                createNewUser(searchData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menuItemFour() {

        System.out.println("пользователя с каким номером телефона удалить?");

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            searchData = buffer.readLine();
            if (repository.keyVerification(searchData)) {
                System.out.println("Пользователь:" + "\n"
                        + repository.searchByPhoneNumber(searchData) + "\n"
                        + "удален!" + "\n");
                repository.deleteEntryByPhoneNumber(searchData);
            }else {
                System.out.println("Пользователя с таким номером телефона нет.");
            }

            System.out.println("""
                        1- продолжить удаление
                        2- выйти в главное меню""");
            if ((menuItem = Integer.parseInt(buffer.readLine())) == 1) {
                menuItemFour();
            } else {
                work();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (repository.keyVerification(searchData)) {
            repository.deleteEntryByPhoneNumber(searchData);
        }
    }

    public void menuItemFive() {

        System.out.println("Введите номер телефона.");
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            searchData = buffer.readLine();
            editingUser(searchData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menuItemSix() {
        System.out.println("До свидания! Хорошего дня!");
        System.exit(0);
    }

    public void editingUser(String searchData) {

        System.out.println("""
                Какой параметр редактируем?
                1- номер телефона
                2- имя и фамилию
                3- электронную почту
                4- адрес проживания
                5- выйти в главное меню
                """);
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            menuItem = Integer.parseInt(buffer.readLine());
            switch (menuItem) {
                case 1 -> {
                    if (repository.keyVerification(searchData)) {
                        System.out.println("""
                                Такой пользователь существует.
                                1- редактировать другие параметры
                                2- выйти в главное меню""");
                    }
                    if (((menuItem = Integer.parseInt(buffer.readLine())) == 1)) {
                        editingUser(searchData);
                    } else {
                        work();
                    }
                }
                case 2 -> {
                    System.out.println("Введите имя и фамилию, через Ентер");
                    String firstName = buffer.readLine();
                    String surname = buffer.readLine();
                    repository.searchByPhoneNumber(searchData).setFirstname(firstName);
                    repository.searchByPhoneNumber(searchData).setSurname(surname);
                    System.out.println(repository.searchByPhoneNumber(searchData));
                }
                case 3 -> {
                    System.out.println("Список электронных адресов:");
                    String[] emails = repository.searchByPhoneNumber(searchData).getEmails();
                    System.out.println("Выбирете электронный адрес для редактирования:");
                    for (int i = 0; i < emails.length; i++) {
                        System.out.println((i + 1) + "- " + emails[i]);
                    }
                    menuItem = Integer.parseInt(buffer.readLine());
                    System.out.println("Выбирете новый адрес.");
                    String email = buffer.readLine();
                    repository.searchByPhoneNumber(searchData).setEmails(menuItem - 1, email);
                    System.out.println(repository.searchByPhoneNumber(searchData));
                    System.out.println("""
                            1- редактировать другие параметры
                            2- выйти в главное меню""");

                    if (((menuItem = Integer.parseInt(buffer.readLine())) == 1)) {
                        editingUser(searchData);
                    } else {
                        work();
                    }
                    System.out.println(repository.searchByPhoneNumber(searchData));
                }
                case 4 -> {
                    System.out.println("Введите новый адрес.");
                    String address = buffer.readLine();
                    repository.searchByPhoneNumber(searchData).setAddress(address);
                    System.out.println(repository.searchByPhoneNumber(searchData));
                }
                case 5 -> work();
            }

            System.out.println("1- продолжить редактировать текущую запись" + "\n"
                    + "2- выйти в главное меню");
            if (((menuItem = Integer.parseInt(buffer.readLine())) == 1)) {
                editingUser(searchData);
            } else {
                work();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNewUser(String searchData) {
        System.out.println("введите данные нового пользователя через Ентер:" + "\n"
                + "имя, фамилию, электронный адрес, адрес"
        );
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strings = new String[4];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = buffer.readLine();
            }
            repository.addEntry(new Person(searchData, strings[0], strings[1], new String[]{strings[2]}, strings[3]));
            System.out.println("Новый пользователь сохранен:" + "\n"
                    + repository.searchByPhoneNumber(searchData));
            work();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
