package player_managerment;


import player_managerment.service.PlayerService;

import java.util.Scanner;

public class test {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào đội hình của bạn: ");
        PlayerService playerService = new PlayerService();
        playerService.buildTeam(1, 4, 4, 2);




    }



}



