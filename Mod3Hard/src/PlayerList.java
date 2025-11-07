public class PlayerList {
    PlayerNode head;
    PlayerNode tail;

    // Counters untuk analisis
    public int comparisonCount = 0;
    public int swapCount = 0;
    public int recursiveCallCount = 0;

    public PlayerList() {
        head = null;
        tail = null;
    }

    public void resetCounters() {
        comparisonCount = 0;
        swapCount = 0;
        recursiveCallCount = 0;
    }

    public void addPlayer(String name, int jerseyNumber, int totalPoints, int totalAssists, int totalRebounds,
            int gamesPlayed) {
        PlayerNode newPlayer = new PlayerNode(name, jerseyNumber, totalPoints, totalAssists, totalRebounds,
                gamesPlayed);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
        } else {
            tail.next = newPlayer;
            newPlayer.prev = tail;
            tail = newPlayer;
        }
    }

    private PlayerList deepCopy() {
        PlayerList copy = new PlayerList();
        PlayerNode curr = this.head;
        while (curr != null) {
            PlayerStats s = curr.stats;
            copy.addPlayer(s.name, s.jerseyNumber, s.totalPoints, s.totalAssists, s.totalRebounds, s.gamesPlayed);
            curr = curr.next;
        }
        return copy;
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

    public PlayerList mergeSort() {
        if (this.head == null) {
            return new PlayerList();
        }
        PlayerList copy = this.deepCopy();
        if (copy.head == null || copy.head.next == null) {
            return copy;
        }

        copy.resetCounters();
        copy.head = copy.mergeSortRec(copy.head);

        PlayerNode current = copy.head;
        PlayerNode prev = null;
        while (current != null) {
            current.prev = prev;
            prev = current;
            current = current.next;
        }
        copy.tail = prev;
        return copy;
    }

    private PlayerNode mergeSortRec(PlayerNode node) {
        recursiveCallCount++;

        if (node == null || node.next == null) {
            return node;
        }

        PlayerNode middle = getMiddle(node, null);
        PlayerNode nextOfMiddle = middle.next;
        middle.next = null;
        if (nextOfMiddle != null)
            nextOfMiddle.prev = null;

        PlayerNode left = mergeSortRec(node);
        PlayerNode right = mergeSortRec(nextOfMiddle);

        return thisMerge(left, right);
    }

    private PlayerNode thisMerge(PlayerNode a, PlayerNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        PlayerNode result;

        comparisonCount++;
        if (a.getPPG() >= b.getPPG()) {
            result = a;
            result.next = thisMerge(a.next, b);
        } else {
            result = b;
            result.next = thisMerge(a, b.next);
        }

        if (result.next != null) {
            result.next.prev = result;
        }
        result.prev = null;

        return result;
    }

    private PlayerNode getMiddle(PlayerNode start, PlayerNode end) {
        if (start == null)
            return null;
        PlayerNode slow = start;
        PlayerNode fast = start;
        while (fast.next != end && fast.next != null && fast.next.next != end && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public PlayerList quickSort() {
        PlayerList copy = this.deepCopy();
        copy.resetCounters();
        copy.quickSortRec(copy.head, copy.tail);
        PlayerNode current = copy.head, prev = null;
        while (current != null) {
            current.prev = prev;
            prev = current;
            current = current.next;
        }
        copy.tail = prev;
        return copy;
    }

    private void quickSortRec(PlayerNode low, PlayerNode high) {
        recursiveCallCount++;

        if (high != null && low != high && low != high.next) {
            PlayerNode pivot = partition(low, high);
            quickSortRec(low, pivot.prev);
            quickSortRec(pivot.next, high);
        }
    }

    private PlayerNode partition(PlayerNode low, PlayerNode high) {
        double pivotValue = high.getPPG();
        PlayerNode i = low.prev;

        for (PlayerNode j = low; j != high; j = j.next) {
            comparisonCount++;
            if (j.getPPG() >= pivotValue) {
                i = (i == null) ? low : i.next;
                swapData(i, j);
            }
        }
        i = (i == null) ? low : i.next;
        swapData(i, high);
        return i;
    }

    private void swapData(PlayerNode a, PlayerNode b) {
        if (a != b) { // Hanya swap jika berbeda node
            swapCount++;
            PlayerStats tempStats = a.stats;
            a.stats = b.stats;
            b.stats = tempStats;
        }
    }

    public PlayerNode linearSearch(double ppg) {
        resetCounters();
        PlayerNode current = this.head;
        while (current != null) {
            comparisonCount++;
            if (current.getPPG() == ppg) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public PlayerNode binarySearch(double ppg) {
        resetCounters();
        PlayerNode low = head;
        PlayerNode high = tail;

        return binarySearch(low, high, ppg);
    }

    public PlayerList findMVPCandidate(double minPPG) {
        PlayerList results = new PlayerList();
        if (this.head == null) {
            return results;
        }

        PlayerNode match = binarySearch(this.head, this.tail, minPPG);
        if (match != null) {
            PlayerNode start = match;
            while (start.prev != null && start.prev.getPPG() >= minPPG) {
                start = start.prev;
            }
            PlayerNode cur = start;
            while (cur != null && cur.getPPG() >= minPPG) {
                results.addPlayer(cur.stats.name, cur.stats.jerseyNumber, cur.stats.totalPoints,
                        cur.stats.totalAssists, cur.stats.totalRebounds, cur.stats.gamesPlayed);
                cur = cur.next;
            }
        } else {
            System.out.println("Tidak ada pemain yang memenuhi kriteria PPG >= " + minPPG);
        }
        return results;
    }

    private PlayerNode binarySearch(PlayerNode low, PlayerNode high, double targetPPG) {
        while (low != null && high != null && low != high.next && low.prev != high) {
            PlayerNode mid = getMiddle(low, high);
            if (mid == null)
                break;

            double midPPG = mid.getPPG();
            comparisonCount++;
            if (midPPG == targetPPG) {
                return mid; // exact match
            } else if (midPPG < targetPPG) {
                high = mid.prev;
            } else {
                low = mid.next;
            }
        }
        return null;
    }
}