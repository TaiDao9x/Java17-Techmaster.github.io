package player_managerment;

import player_managerment.service.PlayerService;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean isQuit = true;

        while (isQuit) {
            System.out.println("\nNhập vào đội hình của bạn: ");
            System.out.print("Số lượng thủ môn: ");
            int GKNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Số lượng hậu vệ: ");
            int DFNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Số lượng tiền vệ: ");
            int MFNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Số lượng tiền đạo: ");
            int FWNumber = sc.nextInt();
            sc.nextLine();

            int NUMBER_OF_PLAYER = 11;
            if (GKNumber + DFNumber + MFNumber + FWNumber == NUMBER_OF_PLAYER) {
                PlayerService playerService = new PlayerService();
                playerService.buildTeam(GKNumber, DFNumber, MFNumber, FWNumber);
                isQuit = false;
            } else {
                System.out.println("Số lượng cầu thủ tham gia phải bằng 11.");
                System.out.println("Hãy nhập lại!");
            }
        }
    }
}



