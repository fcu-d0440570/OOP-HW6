package fcu.iecs.oop.pokemon;

public class GYM {
	public static Player fight(Player... players) {
		Player winner;
		int p1 = 0, p2 = 0;
		Pokemon[] player1 = players[0].getPokemons(), player2 = players[1].getPokemons();
		for (int i = 0; i < 3 && p1 < 2 && p2 < 2; i++) {
			if (player1[i].getType() == player2[i].getType()) {
				if (player1[i].getCp() > player2[i].getCp()) {
					p1++;
				} else if (player1[i].getCp() == player2[i].getCp()) {
					if (Math.random() < 0.5)
						p1++;
					else
						p2++;
				} else
					p2++;
			} else if ((player1[i].getType() == PokemonType.FIRE)) {
				switch (player2[i].getType()) {
				case GRASS:
					p1++;
					break;
				case WATER:
					p2++;
					break;
				}
			} else if ((player1[i].getType() == PokemonType.GRASS)) {
				switch (player2[i].getType()) {
				case WATER:
					p1++;
					break;
				case FIRE:
					p2++;
					break;
				}
			} else if ((player1[i].getType() == PokemonType.WATER)) {
				switch (player2[i].getType()) {
				case FIRE:
					p1++;
					break;
				case GRASS:
					p2++;
					break;
				}
			}
		}
		if (p1 > 1)
			winner = players[0];
		else
			winner = players[1];
		winner.setLevel(winner.getLevel() + 1);
		System.out.println(
				"Winner is " + winner.getPlayerName() + ", and his/her level becomes " + winner.getLevel());
		return winner;
	}

}
