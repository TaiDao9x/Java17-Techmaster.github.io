package player_managerment.repository;

import player_managerment.database.PlayerDatabase;
import player_managerment.model.Player;
import player_managerment.model.Position;

import java.util.ArrayList;
import java.util.Random;

public class PlayerRepository {
    Random rand = new Random();

    // Tạo danh sách cầu thủ với số lượng cầu thủ mỗi vị trí đã được chỉ định sẵn
    public ArrayList<Player> buildTeam(int GKNumber, int DFNumber, int MFNumber, int FWNumber) {
        ArrayList<Player> team = new ArrayList<>();
        for (int i = 0; i < GKNumber; i++) {
            int random = rand.nextInt(PlayerDatabase.GK.size() - 1);
            team.add(PlayerDatabase.GK.get(random));
        }

        for (int i = 0; i < DFNumber; i++) {
            int random = rand.nextInt(PlayerDatabase.DF.size() - 1);

            team.add(PlayerDatabase.DF.get(random));
            PlayerDatabase.DF.remove(random);
        }

        for (int i = 0; i < MFNumber; i++) {
            int random = rand.nextInt(PlayerDatabase.MF.size() - 1);
            team.add(PlayerDatabase.MF.get(random));
            PlayerDatabase.MF.remove(random);
        }

        for (int i = 0; i < FWNumber; i++) {
            int random = rand.nextInt(PlayerDatabase.FW.size() - 1);
            team.add(PlayerDatabase.FW.get(random));
            PlayerDatabase.FW.remove(random);
        }

        return team;
    }

    //     Phương thức lấy số lượng cầu thủ bất kỳ thuộc vị trí được chỉ định
    private ArrayList<Player> getPlayers(Position position, int number) {
        ArrayList<Player> lineUp = new ArrayList<>();

        if (position == Position.GK) {
            for (int i = 0; i < number; i++) {
                int random = rand.nextInt(PlayerDatabase.GK.size());
                lineUp.add(PlayerDatabase.GK.get(random));
            }
        }



        return lineUp;
    }
}
