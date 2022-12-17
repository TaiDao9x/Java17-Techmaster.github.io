package player_managerment.database;

import player_managerment.model.Player;
import player_managerment.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PlayerDatabase {
    public static ArrayList<Player> GK = new ArrayList<>(List.of(
            new Player(1, "Courtois", Position.GK),
            new Player(23, "Emiliano Martinez",Position.GK)
    ));

    public static ArrayList<Player> DF = new ArrayList<>(List.of(
            new Player(5, "Kounde",Position.DF),
            new Player(24, "Konate",Position.DF),
            new Player(13, "Romero",Position.DF),
            new Player(11, "Dembele",Position.DF),
            new Player(22, "Theo Hernandez",Position.DF),
            new Player(25, "Ruben Dias",Position.DF),
            new Player(4, "Van dijk",Position.DF)

    ));

    public static ArrayList<Player> MF = new ArrayList<>(List.of(
            new Player(10, "Messi",Position.MF),
            new Player(8, "Tchouameni",Position.MF),
            new Player(12, "Fofana",Position.MF),
            new Player(6, "Mbappe",Position.MF),
            new Player(17, "De Bruyne",Position.MF),
            new Player(20, "Bernardo Silva",Position.MF),
            new Player(18, "Kante",Position.MF),
            new Player(21, "Thiago",Position.MF)
    ));

    public static ArrayList<Player> FW = new ArrayList<>(List.of(
            new Player(9, "Erling Haaland",Position.FW),
            new Player(19, "Julian Alvarez",Position.FW),
            new Player(7, "Ronaldo",Position.FW),
            new Player(14, "Musiala",Position.FW)

    ));

}
