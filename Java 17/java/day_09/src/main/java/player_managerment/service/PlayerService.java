package player_managerment.service;

import player_managerment.model.Player;
import player_managerment.repository.PlayerRepository;

public class PlayerService {
    PlayerRepository playerRepository = new PlayerRepository();

    public void buildTeam(int GKNumber, int DFNumber, int MFNumber, int FWNumber) {
        for (Player p : playerRepository.buildTeam(GKNumber, DFNumber, MFNumber, FWNumber)) {
            System.out.println(p);
        }
    }
}
