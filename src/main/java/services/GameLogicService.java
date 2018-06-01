package services;

import database.ScoreDAO;
import database.ScoreDAOImpl;
import database.WordDAO;
import database.WordDAOImpl;
import model.Game;
import model.Score;
import model.User;
import model.Word;

import java.sql.SQLException;

public class GameLogicService {

    public Game gameInit(User user) {
        Game game = new Game();
        WordDAO wordDAO = new WordDAOImpl();

        //User
        game.setUser(user);

        //Score
        Score score = new Score();
        score.setUserId(user.getUserId());
        score.setScore(100);
        game.setScore(score);

        //Word
        game.setWord(wordDAO.getRandomWord());

        //Solution placeholder
        game.setSolutionPlaceholder(setupSolutionPlaceholder(game.getWord()));

        //Misses
        game.setMisses(0);

        //Used letters
        game.setUsedLetters(" ");

        return game;
    }

    public String updateGame(Game game, String guess) {
        String response;
        guess = guess.toUpperCase();

        if (guess.equals("") || guess.equals(" ") || guess == null ) {
            guess = "*";
        }

        if (guess.length() == 1) {
            char letter = guess.charAt(0);
            boolean guessedRight = false;
            StringBuilder solutionPlaceholder = new StringBuilder(game.getSolutionPlaceholder());

            if (game.getUsedLetters().indexOf(letter) >= 0) {
                return "continue";
            }

            if (!Character.isLetter(letter)) {
                return "continue";
            }

            for (int i = 0 ; i < game.getWord().getWord().length() ; i++) {
                if (game.getWord().getWord().charAt(i) == letter) {
                    solutionPlaceholder.setCharAt(i,letter);
                    guessedRight = true;
                }
            }

            if (guessedRight) {
                game.setSolutionPlaceholder(solutionPlaceholder.toString());
                response = "guessed letter";
            }
            else {
                String usedLetters = game.getUsedLetters();
                if (letter != '*') {
                    if(usedLetters.length() == 1) {
                        usedLetters = usedLetters + letter;
                    }
                    else {
                        usedLetters = usedLetters + ", " + letter;
                    }
                }
                game.setUsedLetters(usedLetters);
                game.setMisses(game.getMisses() + 1);

                Score score = game.getScore();

                if (game.getMisses() < 4) {
                    score.setScore(score.getScore() - 20);
                }
                else {
                    score.setScore(score.getScore() - 10);
                }

                response =  "didnt guess letter";
            }

        }
        else {
            if (game.getWord().getWord().equals(guess)) {
                return "won";
                //TODO sacuvat score u bazu
            }
            else {
                game.setMisses(game.getMisses() + 1);

                Score score = game.getScore();

                if (game.getMisses() < 4) {
                    score.setScore(score.getScore() - 20);
                }
                else {
                    score.setScore(score.getScore() - 10);
                }
                response = "didnt won";
            }
        }

        if (game.getMisses() == 6) {
            Score score = game.getScore();
            score.setScore(0);
            game.setScore(score);
            return "lost";
        }

        if (game.getSolutionPlaceholder().equals(game.getWord().getWord())) {
            return "won";
        }

        return response;
    }

    private String setupSolutionPlaceholder(Word word) {
        String placeholder = "";

        for (int i = 0 ; i < word.getWord().length() ; i++) {
            placeholder = placeholder + "_";
        }

        return placeholder;
    }

    public void endGame(Game game) {
        ScoreDAO scoreDAO = new ScoreDAOImpl();
        Score score = game.getScore();
        try {
            scoreDAO.addScore(score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        game = null;
    }

    public String picturePath(Game game) {

        switch (game.getMisses()) {
            case 0:
                return "/png/Gallow1.png";
            case 1:
                return "/png/011.png";
            case 2:
                return "/png/022.png";
            case 3:
                return "/png/033.png";
            case 4:
                return "/png/044.png";
            case 5:
                return "/png/055.png";
            case 6:
                return "/png/066.png";

            default:
                return "/png/066.png";
        }
    }





}
