package main;

import Boundary.TournamentUI;
import Control.AnnounceTournamentController;
import Entity.Advertiser;
import Entity.LeagueOwner;
import Entity.Player;
import Entity.Spectator;

/**
 * Lớp chính dùng để chạy chương trình mô phỏng use case AnnounceTournament.
 */
public class Main {

	/**
	 * Phương thức main của chương trình.
	 *
	 * @param args tham số dòng lệnh
	 */
	public static void main(String[] args) {

		/*
		 * Tạo Controller.
		 */
		AnnounceTournamentController controller = new AnnounceTournamentController();

		/*
		 * Tạo các Advertiser.
		 */
		Advertiser advertiser1 = new Advertiser("Tech Company", "tech@gmail.com", 5000, true);

		Advertiser advertiser2 = new Advertiser("Sport Company", "sport@gmail.com", 3000, true);

		controller.addAdvertiser(advertiser1);
		controller.addAdvertiser(advertiser2);

		/*
		 * Tạo các Player.
		 */
		Player player1 = new Player("Nguyen Van An", "an@gmail.com");

		Player player2 = new Player("Tran Van Binh", "binh@gmail.com");

		controller.addPlayer(player1);
		controller.addPlayer(player2);

		/*
		 * Tạo các Spectator.
		 */
		Spectator spectator1 = new Spectator("Le Van Minh", "minh@gmail.com");

		Spectator spectator2 = new Spectator("Pham Thi Hoa", "hoa@gmail.com");

		controller.addSpectator(spectator1);
		controller.addSpectator(spectator2);

		/*
		 * Tạo LeagueOwner.
		 */
		LeagueOwner owner = new LeagueOwner("ARENA League Owner", "owner@arena.com", 5);

		/*
		 * Tạo Boundary.
		 */
		TournamentUI ui = new TournamentUI(controller);

		/*
		 * Thực hiện use case.
		 */
		ui.announceTournament(owner);
	}
}