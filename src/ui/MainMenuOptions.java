package ui;

import util.InputValidator;

public enum MainMenuOptions{
        eViewAccount (1),
        eViewMusicSelection(2),
        eRateSong(3),
        eExit(4);

        private final int value;
        MainMenuOptions(int value){
            this.value = value;
        }

        public int getValue(){ return value; }
}
