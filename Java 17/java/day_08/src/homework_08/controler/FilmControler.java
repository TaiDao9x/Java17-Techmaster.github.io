package homework_08.controler;

import homework_08.service.FilmService;

import java.util.Scanner;

public class FilmControler {

    FilmService filmService = new FilmService();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        boolean isQuit = true;

        while (isQuit) {
            showMenu();

            System.out.print("Lựa chọn tính năng : ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> filmService.showFilm();
                case 2 -> {
                    System.out.print("\nNhập tiêu đề phim muốn tìm: ");
                    String title = sc.nextLine();
                    filmService.findFilmByTitle(title);
                }
                case 3 -> isQuit = false;
                default -> System.out.println("\nLựa chọn không phù hợp. Hãy chọn lại!");
            }
        }
    }

    public void showMenu() {
        System.out.println("\n------------MENU------------");
        System.out.println("1. In thông tin phim ra màn hình ");
        System.out.println("2. Tìm phim theo tiêu đề");
        System.out.println("3. Thoát");
    }
}
