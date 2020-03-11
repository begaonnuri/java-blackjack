package com.blackjack.domain.user;

import com.blackjack.domain.Score;

public class Player extends User {
	private static final Score DRAW_CONDITION = new Score(21);

	private final Name name;

	Player(Name name) {
		super();
		this.name = name;
	}

	@Override
	public boolean canDraw() {
		Score score = hands.calculateScore();
		return score.isLowerThan(DRAW_CONDITION);
	}
}
