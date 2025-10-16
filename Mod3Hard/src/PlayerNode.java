public class PlayerNode {
    PlayerStats stats;
    PlayerNode prev, next;

    public PlayerNode(String name, int jerseyNumber, int totalPoints, int totalAssists, int totalRebounds, int gamesPlayed) {
        this.stats = new PlayerStats(name, jerseyNumber, totalPoints, totalAssists, totalRebounds, gamesPlayed);
        this.prev = null;
        this.next = null;
    }
    public double getPPG() {
        if (stats.gamesPlayed == 0) {
            return 0;
        } else if (stats.totalPoints == 0) {
            return 0;
        } else {
            return (double) stats.totalPoints / stats.gamesPlayed;
        }
    }
    public double getAPG() {
        if (stats.gamesPlayed == 0) {
            return 0;
        } else if (stats.totalAssists == 0) {
            return 0;
        } else {
            return (double) stats.totalAssists / stats.gamesPlayed;
        }
    }
    public double getRPG() {
        if (stats.gamesPlayed == 0) {
            return 0;
        } else if (stats.totalRebounds == 0) {
            return 0;
        } else {
            return (double) stats.totalRebounds / stats.gamesPlayed;
        }
    }

}
