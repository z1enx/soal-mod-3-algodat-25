public class TeamData {
    String teamName;
    int gamesPlayed, wins, losses, totalPoints, totalRebounds, totalAssists;

    public TeamData(String teamName, int gamesPlayed, int wins, int losses, int totalPoints, int totalRebounds, int totalAssists) {
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.totalPoints = totalPoints;
        this.totalRebounds = totalRebounds;
        this.totalAssists = totalAssists;
    }
}
