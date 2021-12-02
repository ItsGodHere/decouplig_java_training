package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        if (args.length != 0){
            if (args.length == 1) {
                if (args[0].equals("-interactive")) {
                    Simulation simulation = new Simulation(new HumanPlayer());
                    SecureRandom random = new SecureRandom();
                    long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
                    simulation.initialize(randomNumber);
                    simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
                }else {
                    DisplayHelp();
                }
            }
            if (args.length == 2) {
                if(args[0].equals("-auto")) {
                    if (args[1].matches("[+-]?\\d*(\\.\\d+)?")) {
                        Simulation simulation = new Simulation(new ComputerPlayer());
                        SecureRandom random = new SecureRandom();
                        long randomNumber = random.nextInt(100);
                        simulation.initialize(randomNumber);
                        simulation.loopUntilPlayerSucceed(Integer.parseInt(args[1]));
                    }else {
                        DisplayHelp();
                    }
                }else {
                    DisplayHelp();
                }
            }else {
                DisplayHelp();
            }

        } else {
            DisplayHelp();
        }
    }

    private static void DisplayHelp() {
        System.out.println("    +------------------------+");
        System.out.println("    |   l’age du capitaine   |");
        System.out.println("    +------------------------+");
        System.out.println(">> Bienvenue dans l'aide du jeu...");
        System.out.println(">> '-interactive' : pour lancer le programme avec un joueur Humain ");
        System.out.println(">> '-auto [number]' : pour lancer le programme avec un joueur Ordinateur ");
    }
}
