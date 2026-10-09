package Boundary;

import Control.AnnounceTournamentController;
import Entity.Advertiser;
import Entity.LeagueOwner;
import Entity.Player;
import Entity.Spectator;
import Entity.Tournament;

import java.util.List;

/**
 * Boundary của use case AnnounceTournament.
 *
 * Class mô phỏng giao diện mà LeagueOwner sử dụng để tạo và công bố Tournament.
 */
public class TournamentUI {

	/** Controller xử lý use case. */
	private AnnounceTournamentController controller;

	/**
	 * Khởi tạo TournamentUI.
	 *
	 * @param controller Controller của use case
	 */
	public TournamentUI(AnnounceTournamentController controller) {

		this.controller = controller;
	}

	/**
	 * Thực hiện use case AnnounceTournament.
	 *
	 * @param owner LeagueOwner khởi tạo use case
	 */
	public void announceTournament(LeagueOwner owner) {

		System.out.println("===== ANNOUNCE TOURNAMENT =====");

		/*
		 * Bước 1, 2: Kiểm tra LeagueOwner có vượt giới hạn hay không.
		 */
		if (!controller.checkTournamentLimit(owner)) {

			System.out.println("LeagueOwner đã vượt giới hạn Tournament.");

			return;
		}

		/*
		 * Bước 3: Tạo Tournament.
		 */
		Tournament tournament = controller.createTournament(owner, "ARENA Championship", "2026-10-10", "2026-10-20",
				"2026-10-25", "2026-10-30", 32);

		if (tournament == null) {
			System.out.println("Không thể tạo Tournament.");
			return;
		}

		System.out.println("Đã tạo Tournament: " + tournament.getName());

		/*
		 * Bước 4: Lấy danh sách Advertiser quan tâm.
		 */
		List<Advertiser> advertisers = controller.getInterestedAdvertisers();

		System.out.println("\nDanh sách Advertiser quan tâm:");

		for (Advertiser advertiser : advertisers) {
			System.out.println("- " + advertiser.getName());
		}

		/*
		 * Bước 5, 6, 7: Gửi thông báo đến các Advertiser.
		 */
		if (!advertisers.isEmpty()) {

			controller.notifyAdvertisers(tournament, advertisers);
		}

		/*
		 * Bước 8, 9: Giả lập LeagueOwner chọn Advertiser đầu tiên.
		 */
		if (!advertisers.isEmpty()) {

			Advertiser selectedAdvertiser = advertisers.get(0);

			boolean paid = controller.selectExclusiveSponsor(tournament, selectedAdvertiser);

			if (paid) {

				System.out.println("Nhà tài trợ độc quyền: " + selectedAdvertiser.getName());

			} else {

				System.out.println("Advertiser không đủ tiền.");

				controller.useRandomAdvertising(tournament);
			}

		} else {

			/*
			 * Bước 10: Không có Advertiser nên dùng quảng cáo ngẫu nhiên.
			 */
			controller.useRandomAdvertising(tournament);
		}

		/*
		 * Bước 11, 12: Lấy danh sách Player và Spectator.
		 */
		List<Player> players = controller.getPlayers();

		List<Spectator> spectators = controller.getSpectators();

		/*
		 * Bước 13: Tạo trang chủ Tournament.
		 */
		controller.createTournamentHomePage(tournament);

		System.out.println("\nTrang chủ Tournament: " + tournament.getHomePage());

		/*
		 * Bước 14: Thông báo cho Player.
		 */
		controller.notifyPlayers(tournament, players);

		/*
		 * Thông báo cho Spectator.
		 */
		controller.notifySpectators(tournament, spectators);

		System.out.println("\n===== ANNOUNCE TOURNAMENT HOÀN TẤT =====");
	}
}