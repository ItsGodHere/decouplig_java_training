package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long player_number = this.player.askNextGuess();
        if (player_number == this.numberToGuess)
            return true;
        else {
            player.respond(player_number <= this.numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long max_nb_iteration) {
        boolean winOrLoose;
        long start_time = System.currentTimeMillis();
        while ((!(winOrLoose = this.nextRound())) && (max_nb_iteration != 0)) {
            max_nb_iteration--;
        }
        long end_time = System.currentTimeMillis();
        long total_time = end_time - start_time;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SSS");
        String time = sdf.format(total_time);
        logger.log(time);
        if(winOrLoose)
            logger.log("WIN");
        if(!winOrLoose)
            logger.log("LOOSE");
    }
}
