package com.blackjack.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Collectors;

import com.blackjack.domain.user.Dealer;
import com.blackjack.domain.user.User;

public class GameTable {
	private final Dealer dealer;
	private final List<User> players;

	public GameTable(Dealer dealer, List<User> players) {
		this.dealer = dealer;
		this.players = players;
	}

	public PlayerRecords calculateResult() {
		return players.stream()
			.collect(Collectors.collectingAndThen(toMap(
				player -> player,
				player -> player.compareScoreWithUser(dealer)
			), PlayerRecords::new));
	}
}
