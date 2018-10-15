package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL_ITEMS = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    break;
                case SHOW_ALL_ITEMS:
                    break;
                case EDIT:
                    break;
                case DELETE:
                    break;
                case FIND_BY_ID:
                    break;
                case FIND_BY_NAME:
                    break;
                case EXIT:
                    exit = true;
                    break;
                    default:
            }

        }
    }

    private void createItem() {
        System.out.println("------------ Длобавление новой заявки ------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item  = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "------------");
    }

    private void showMenu() {
        System.out.println("--------------- Меню. ----------------\n");
        System.out.println("Введите ниже номер выбранного пункта .\n");
        System.out.println("    0 - Завести новую карточку.");
        System.out.println("    1 - Показать все карточки");
        System.out.println("    2 - Редактировать карточку");
        System.out.println("    3 - Удалить карточку");
        System.out.println("    4 - Найти карточку по индетефикатору Id");
        System.out.println("    6 - Покинуть программу");
    }
}
