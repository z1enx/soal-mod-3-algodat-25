public class PlayerList {
    PlayerNode head;
     PlayerNode tail;

    public PlayerList() {
        head = null;
        tail = null;
    }

    public void addPlayer(String name, int jerseyNumber, int totalPoints, int totalAssists, int totalRebounds, int gamesPlayed) {
        PlayerNode newPlayer = new PlayerNode(name, jerseyNumber, totalPoints, totalAssists, totalRebounds, gamesPlayed);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
        } else {
            tail.next = newPlayer;
            newPlayer.prev = tail;
            tail = newPlayer;
        }
    }

    public void printPlayers() {
            System.out.printf("%-25s %-10s %8s %8s %8s%n", "PLAYER NAME", "JERSEY #", "PPG", "APG", "RPG");
            System.out.println("-----------------------------------------------------------------");

            PlayerNode current = head;
            while (current != null) {
                System.out.printf("%-25s %-10d %8.1f %8.1f %8.1f%n",
                        current.stats.name,
                        current.stats.jerseyNumber,
                        current.getPPG(),
                        current.getAPG(),
                        current.getRPG());
                current = current.next;
            }
        }

    public void mergeSort() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSortRec(head);
        
        PlayerNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        tail = current;
    }

    private PlayerNode mergeSortRec(PlayerNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        PlayerNode middle = getMiddle(node, null);
        PlayerNode nextOfMiddle = middle.next;
        middle.next = null;
        if (nextOfMiddle != null) nextOfMiddle.prev = null;

        PlayerNode left = mergeSortRec(node);
        PlayerNode right = mergeSortRec(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private PlayerNode sortedMerge(PlayerNode a, PlayerNode b) {
        if (a == null) return b;
        if (b == null) return a;
        PlayerNode result;
        
        if (a.getPPG() >= b.getPPG()) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        
        if (result.next != null) {
            result.next.prev = result;
        }
        result.prev = null;
        
        return result;
    }

    private PlayerNode getMiddle(PlayerNode start, PlayerNode end) {
        if (start == null) return null;
        PlayerNode slow = start;
        PlayerNode fast = start;
        while (fast.next != end && fast.next != null && fast.next.next != end && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

public PlayerList findMVPCandidate(double minPPG) {
        PlayerList results = new PlayerList();
        if (head == null) {
            return results;
        }

        PlayerNode aMatch = binarySearch(head, tail, minPPG); 
        if (aMatch != null) {
            PlayerNode current = aMatch;
            while (current != null && current.getPPG() >= minPPG) {
                results.addPlayer(current.stats.name, current.stats.jerseyNumber, current.stats.totalPoints, 
                                  current.stats.totalAssists, current.stats.totalRebounds, current.stats.gamesPlayed);
                current = current.prev;
            }
            current = aMatch.next;
             while (current != null && current.getPPG() >= minPPG) {
                results.addPlayer(current.stats.name, current.stats.jerseyNumber, current.stats.totalPoints, 
                                  current.stats.totalAssists, current.stats.totalRebounds, current.stats.gamesPlayed);
                current = current.next;
            }

        } else {
             System.out.println("Tidak ada pemain yang memenuhi kriteria PPG >= " + minPPG);
        }
        results.mergeSort();
        return results;
    }

    private PlayerNode binarySearch(PlayerNode low, PlayerNode high, double minPPG) {
         while (low != null && high != null && low != high.next && low.prev != high) {
            PlayerNode mid = getMiddle(low, high);
            if (mid == null) break;

            if (mid.getPPG() >= minPPG) {
                return mid;
            } else {
                high = mid.prev;
            }
        }
        if (low != null && low.getPPG() >= minPPG) {
            return low;
        }
        return null;
    }
}