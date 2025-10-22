package ui;

import util.InputValidator;

public enum MainMenuOptions extends InputValidator {
        eViewAccount (1),
        eViewMusicSelection(2);

        private final int value;
        MainMenuOptions(int value){
            this.value = value;
        }

        public int getValue(){ return value; }
}
