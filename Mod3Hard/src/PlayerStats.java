public class PlayerStats {
    String name;
    int totalPoints, totalAssists, totalRebounds, gamesPlayed, jerseyNumber;

    public PlayerStats(String name, int jerseyNumber, int totalPoints, int totalAssists, int totalRebounds, int gamesPlayed) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.totalPoints = totalPoints;
        this.totalAssists = totalAssists;
        this.totalRebounds = totalRebounds;
        this.gamesPlayed = gamesPlayed;
    }
}