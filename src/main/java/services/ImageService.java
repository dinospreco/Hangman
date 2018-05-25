package services;

import model.Game;

public class ImageService {

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
