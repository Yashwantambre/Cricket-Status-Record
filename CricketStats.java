import java.util.Scanner;

class Batsman {
    String name;
    int runs, balls, ones, twos, threes, fours, sixes;
    float str;

    public Batsman() {
        // Default constructor
    }

    public Batsman(String name, int ones, int twos, int threes, int fours, int sixes, int balls) {
        this.name = name;
        this.ones = ones;
        this.twos = twos;
        this.threes = threes;
        this.fours = fours;
        this.sixes = sixes;
        this.balls = balls;
    }

    public void calculateStatistics() {
        runs = (1 * ones) + (2 * twos) + (3 * threes) + (4 * fours) + (6 * sixes);
        str = (runs * 100.0f) / balls;
    }
}

class Bowler {
    String name;
    int runsgv, wkttkn, overs;
    float econ;

    public Bowler() {
        // Default constructor
    }

    public Bowler(String name, int runsgv, int wkttkn, int overs) {
        this.name = name;
        this.runsgv = runsgv;
        this.wkttkn = wkttkn;
        this.overs = overs;
    }

    public void calculateEconomy() {
        econ = runsgv / (float) overs;
    }
}

public class CricketStats {
    public static void main(String[] args) {
        int choice;
        int m, n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Batsman details:");
        System.out.print("Enter the number of batsmen: ");
        m = scanner.nextInt();
        Batsman[] batsmen = new Batsman[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Enter name of batsman " + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Enter the number of ones scored by " + name + ": ");
            int ones = scanner.nextInt();
            System.out.print("Enter the number of twos scored by " + name + ": ");
            int twos = scanner.nextInt();
            System.out.print("Enter the number of threes scored by " + name + ": ");
            int threes = scanner.nextInt();
            System.out.print("Enter the number of fours scored by " + name + ": ");
            int fours = scanner.nextInt();
            System.out.print("Enter the number of sixes scored by " + name + ": ");
            int sixes = scanner.nextInt();
            System.out.print("Enter the balls played by " + name + ": ");
            int balls = scanner.nextInt();

            batsmen[i] = new Batsman(name, ones, twos, threes, fours, sixes, balls);
            batsmen[i].calculateStatistics();
        }

        System.out.println("\nEnter the Bowlers details:");
        System.out.print("Enter the number of bowlers: ");
        n = scanner.nextInt();
        Bowler[] bowlers = new Bowler[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of bowler " + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Enter the runs given by " + name + ": ");
            int runsgv = scanner.nextInt();
            System.out.print("Enter the overs bowled by " + name + ": ");
            int overs = scanner.nextInt();
            System.out.print("Enter the wickets taken by " + name + ": ");
            int wkttkn = scanner.nextInt();

            bowlers[i] = new Bowler(name, runsgv, wkttkn, overs);
            bowlers[i].calculateEconomy();
        }

        System.out.println("Thank you, all details are recorded\n");

        do {
            System.out.println("Enter the choice:");
            System.out.println("1) Batsman detail");
            System.out.println("2) Bowlers detail");
            System.out.println("3) Match summary");
            System.out.println("4) Record");
            System.out.println("5) Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the batsman number to see his details: ");
                    int plno = scanner.nextInt();
                    plno--;

                    if (plno >= 0 && plno < m) {
                        System.out.println("Player Detail");
                        System.out.println("===========================================================================");
                        System.out.println(" Batsman        runs           balls        fours       sixes         sr   ");
                        System.out.println("===========================================================================");
                        System.out.printf(" %-15s %-14d %-13d %-11d %-11d %-9.2f%n%n",
                                batsmen[plno].name, batsmen[plno].runs, batsmen[plno].balls,
                                batsmen[plno].fours, batsmen[plno].sixes, batsmen[plno].str);
                    } else {
                        System.out.println("Invalid batsman number.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the bowler number to see his details: ");
                    plno = scanner.nextInt();
                    plno--;

                    if (plno >= 0 && plno < n) {
                        System.out.println("Player Detail");
                        System.out.println("=================================================================");
                        System.out.println(" Bowler        overs           runs        wicket       economy");
                        System.out.println("=================================================================");

                        System.out.printf(" %-15s %-14d %-13d %-11d %-11.2f%n%n",
                                bowlers[plno].name, bowlers[plno].overs, bowlers[plno].runsgv,
                                bowlers[plno].wkttkn, bowlers[plno].econ);
                    } else {
                        System.out.println("Invalid bowler number.");
                    }
                    break;

                case 3:
                    System.out.println("Match summary");
                    System.out.println("===========================================================================");
                    System.out.println(" Batsman        runs           balls        fours       sixes         sr   ");
                    System.out.println("===========================================================================");

                    int totalRuns = 0;
                    for (int i = 0; i < m; i++) {
                        System.out.printf(" %-15s %-14d %-13d %-11d %-11d %-9.2f%n",
                                batsmen[i].name, batsmen[i].runs, batsmen[i].balls,
                                batsmen[i].fours, batsmen[i].sixes, batsmen[i].str);
                        totalRuns += batsmen[i].runs;
                    }
                    System.out.println("\nTOTAL RUNS: " + totalRuns + "\n\n");

                    System.out.println("=================================================================");
                    System.out.println(" Bowler        overs           runs        wicket       economy");
                    System.out.println("=================================================================");

                    for (int i = 0; i < n; i++) {
                        System.out.printf(" %-15s %-14d %-13d %-11d %-11.2f%n%n",
                                bowlers[i].name, bowlers[i].overs, bowlers[i].runsgv,
                                bowlers[i].wkttkn, bowlers[i].econ);
                    }
                    break;

                case 4:
                    int maxRuns = 0, maxFours = 0, maxSixes = 0, maxWickets = 0;
                    for (int i = 0; i < m; i++) {
                        if (batsmen[i].runs > maxRuns) {
                            maxRuns = batsmen[i].runs;
                        }
                        if (batsmen[i].fours > maxFours) {
                            maxFours = batsmen[i].fours;
                        }
                        if (batsmen[i].sixes > maxSixes) {
                            maxSixes = batsmen[i].sixes;
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        if (bowlers[i].wkttkn > maxWickets) {
                            maxWickets = bowlers[i].wkttkn;
                        }
                    }

                    System.out.println("Highest runs scored by a batsman: " + maxRuns);
                    System.out.println("Maximum fours scored by a batsman: " + maxFours);
                    System.out.println("Maximum sixes scored by a batsman: " + maxSixes);
                    System.out.println("Maximum wickets taken by a bowler: " + maxWickets);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Enter the correct choice.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
