public class TeamNode {
    TeamData data;
    PlayerList players;
    TeamNode next;
    TeamNode prev;

    public TeamNode(String teamName, int gamesPlayed, int wins, int losses, int totalPoints, int totalRebounds, int totalAssists) {
        this.data = new TeamData(teamName, gamesPlayed, wins, losses, totalPoints, totalRebounds, totalAssists);
        this.players = new PlayerList();
        this.next = null;
        this.prev = null;
    }

    public double getPPG() {
        if (data.gamesPlayed == 0) {
            return 0;
        } else if (data.totalPoints == 0) {
            return 0;
        } else {
            return (double) data.totalPoints / data.gamesPlayed;
        }
    }

    public double getAPG() {
        if (data.gamesPlayed == 0) {
            return 0;
        } else if (data.totalAssists == 0) {
            return 0;
        } else {
            return (double) data.totalAssists / data.gamesPlayed;
        }
    }

    public double getRPG() {
        if (data.gamesPlayed == 0) {
            return 0;
        } else if (data.totalRebounds == 0) {
            return 0;
        } else {
            return (double) data.totalRebounds / data.gamesPlayed;
        }
    }
}
