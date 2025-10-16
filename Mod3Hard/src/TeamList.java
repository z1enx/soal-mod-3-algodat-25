public class TeamList {
    TeamNode head, tail;

    public TeamList() {
        this.head = null;
        this.tail = null;
    }

    public void addTeam(String teamName, int gamesPlayed, int wins, int losses, int totalPoints, int totalRebounds, int totalAssists) {
        TeamNode newTeam = new TeamNode(teamName, gamesPlayed, wins, losses, totalPoints, totalRebounds, totalAssists);
        if (head == null) {
            head = newTeam;
            tail = newTeam;
        } else {
            tail.next = newTeam;
            newTeam.prev = tail;
            tail = newTeam;
        }
    }

    public TeamNode findTeam(String teamName) {
        TeamNode current = head;
        while (current != null) {
            if (current.data.teamName.equals(teamName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printTeams() {
        System.out.println();
        System.out.printf("%-25s | %-4s | %-4s | %-4s | %-8s | %-8s | %-8s%n", 
                          "TEAM NAME", "GP", "W", "L", "PPG", "APG", "RPG");
        System.out.println("----------------------------------------------------------------------------------");

        TeamNode current = head;
        while (current != null) {
            System.out.printf("%-25s | %-4d | %-4d | %-4d | %-8.2f | %-8.2f | %-8.2f%n",
                    current.data.teamName,
                    current.data.gamesPlayed,
                    current.data.wins,
                    current.data.losses,
                    current.getPPG(),
                    current.getAPG(),
                    current.getRPG());
            current = current.next;
        }
    }

    public void printAllPlayers() {
        System.out.println();
        TeamNode current = head;
        while (current != null) {
            System.out.println(current.data.teamName);
            current.players.printPlayers();
            System.out.println();
            current = current.next;
        }
    }

    public void quickSort() {
        head = quickSortRec(head, tail);
        
        TeamNode temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }
    private TeamNode quickSortRec(TeamNode left, TeamNode right) {
        if (left == null || right == null || left == right || left.prev == right) {
            return left;
        }

        TeamNode pivot = partition(left, right);

        if (pivot != null) {
            quickSortRec(left, pivot.prev);
            quickSortRec(pivot.next, right);
        }
        return left;
    }
    private TeamNode partition(TeamNode left, TeamNode right) {
        int pivotValue = right.data.wins;
        TeamNode i = left.prev;

        for (TeamNode j = left; j != right; j = j.next) {
            if (j.data.wins >= pivotValue) {
                i = (i == null) ? left : i.next;
                swapData(i, j);
            }
        }
        
        i = (i == null) ? left : i.next;
        swapData(i, right);
        
        return i;
    }
    private void swapData(TeamNode a, TeamNode b) {
        TeamData tempData = a.data;
        PlayerList tempPlayers = a.players;

        a.data = b.data;
        a.players = b.players;

        b.data = tempData;
        b.players = tempPlayers;
    }
}
