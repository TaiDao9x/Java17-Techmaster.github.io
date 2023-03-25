package team_managerment;

import team_managerment.model.Player;
import team_managerment.service.PlayerService;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        PlayerService playerService = new PlayerService();

        ArrayList<Player> players = playerService.buildTeam(1, 4, 4, 2);

        for (Player player : players) {
            System.out.println(player);
        }
    }
}
