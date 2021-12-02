package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        logger.log("Initialising number to guess...");
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
        long count = 0;
        boolean winOrLoose;
        long time_before = System.currentTimeMillis();
        while ((!(winOrLoose = this.nextRound())) && (max_nb_iteration != 0)) {
            count++;
            max_nb_iteration--;
        }
        long time_after = System.currentTimeMillis();
        long time_used = time_after - time_before;
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss:SSS");
        Date d_time_used = new Date(time_used);
        String time = dateFormat.format(d_time_used);
        if(winOrLoose)
            logger.log("SUCCESS");
        if(!winOrLoose)
            logger.log("FAILURE");
        logger.log("Time elapsed: " + time + " | attempts number: " + count);
    }
}
