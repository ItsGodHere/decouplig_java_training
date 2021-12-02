package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        logger.log("Enter a number...");
        Scanner entree =   new Scanner(System.in);
        return entree.nextInt();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            logger.log("Lower");
        if (!lowerOrGreater)
            logger.log("Greater");
    }
}
