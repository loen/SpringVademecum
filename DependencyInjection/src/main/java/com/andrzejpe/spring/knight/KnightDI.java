package com.andrzejpe.spring.knight;

/**
 * Created by jedrek on 2015-09-30.
 */
public class KnightDI implements Knight {

    private Quest quest;

    public KnightDI(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embark() {
        quest.embarkQuest();
    }
}
