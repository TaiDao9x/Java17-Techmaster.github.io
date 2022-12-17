package player_managerment.service;

import player_managerment.model.Player;
import player_managerment.repository.PlayerRepository;

public class PlayerService {
    PlayerRepository playerRepository = new PlayerRepository();

    public void buildTeam(int GKNumber, int DFNumber, int MFNumber, int FWNumber) {

        System.out.println("\nDanh sách cầu thủ tham gia thi đấu: ");
        for (Player player : playerRepository.buildTeam(GKNumber, DFNumber, MFNumber, FWNumber))
            System.out.println(player);
    }
}

