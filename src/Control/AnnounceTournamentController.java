package Control;

import Entity.Advertiser;
import Entity.LeagueOwner;
import Entity.Player;
import Entity.Spectator;
import Entity.Sponsorship;
import Entity.Tournament;

import java.util.ArrayList;
import java.util.List;

/**
 * Control của use case AnnounceTournament.
 *
 * Class này điều khiển các nghiệp vụ chính của use case:
 *
 * Kiểm tra giới hạn Tournament Tạo Tournament. Xử lý tài trợ. Tạo trang chủ
 * Tournament Thông báo cho Player và Spectator
 */
public class AnnounceTournamentController {

	/** Phí tài trợ độc quyền. */
	private static final double SPONSORSHIP_FEE = 1000.0;

	/** Danh sách Advertiser. */
	private List<Advertiser> advertisers;

	/** Danh sách Player. */
	private List<Player> players;

	/** Danh sách Spectator. */
	private List<Spectator> spectators;

	/**
	 * Khởi tạo Controller.
	 */
	public AnnounceTournamentController() {
		advertisers = new ArrayList<>();
		players = new ArrayList<>();
		spectators = new ArrayList<>();
	}

	/**
	 * Thêm Advertiser vào hệ thống.
	 *
	 * @param advertiser Advertiser
	 */
	public void addAdvertiser(Advertiser advertiser) {
		advertisers.add(advertiser);
	}

	/**
	 * Thêm Player vào hệ thống.
	 *
	 * @param player Player
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}

	/**
	 * Thêm Spectator vào hệ thống.
	 *
	 * @param spectator Spectator
	 */
	public void addSpectator(Spectator spectator) {
		spectators.add(spectator);
	}

	/**
	 * Kiểm tra LeagueOwner có vượt giới hạn Tournament hay không.
	 *
	 * @param owner LeagueOwner
	 * @return true nếu được phép tạo Tournament
	 */
	public boolean checkTournamentLimit(LeagueOwner owner) {
		return owner.canCreateTournament();
	}

	/**
	 * Tạo một Tournament mới.
	 *
	 * @param owner                LeagueOwner tạo Tournament
	 * @param name                 tên Tournament
	 * @param applicationStartDate ngày bắt đầu đăng ký
	 * @param applicationEndDate   ngày kết thúc đăng ký
	 * @param tournamentStartDate  ngày bắt đầu giải đấu
	 * @param tournamentEndDate    ngày kết thúc giải đấu
	 * @param maximumPlayers       số Player tối đa
	 * @return Tournament nếu tạo thành công, null nếu thất bại
	 */
	public Tournament createTournament(LeagueOwner owner, String name, String applicationStartDate,
			String applicationEndDate, String tournamentStartDate, String tournamentEndDate, int maximumPlayers) {

		if (!checkTournamentLimit(owner)) {
			return null;
		}

		Tournament tournament = new Tournament(name, applicationStartDate, applicationEndDate, tournamentStartDate,
				tournamentEndDate, maximumPlayers);

		owner.increaseTournamentCount();

		return tournament;
	}

	/**
	 * Lấy danh sách Advertiser quan tâm tài trợ độc quyền.
	 *
	 * @return danh sách Advertiser
	 */
	public List<Advertiser> getInterestedAdvertisers() {

		List<Advertiser> result = new ArrayList<>();

		for (Advertiser advertiser : advertisers) {
			if (advertiser.isInterestedInExclusiveSponsorship()) {
				result.add(advertiser);
			}
		}

		return result;
	}

	/**
	 * Gửi thông báo đến Advertiser.
	 *
	 * @param tournament          Tournament
	 * @param selectedAdvertisers danh sách Advertiser
	 */
	public void notifyAdvertisers(Tournament tournament, List<Advertiser> selectedAdvertisers) {

		for (Advertiser advertiser : selectedAdvertisers) {

			System.out.println("Thông báo đến Advertiser: " + advertiser.getName());

			System.out.println("Tournament: " + tournament.getName());

			System.out.println("Phí tài trợ: " + SPONSORSHIP_FEE);
		}
	}

	/**
	 * Chọn Advertiser làm nhà tài trợ độc quyền.
	 *
	 * @param tournament Tournament
	 * @param advertiser Advertiser được chọn
	 * @return true nếu thanh toán thành công
	 */
	public boolean selectExclusiveSponsor(Tournament tournament, Advertiser advertiser) {

		if (advertiser == null) {
			return false;
		}

		if (!advertiser.charge(SPONSORSHIP_FEE)) {
			return false;
		}

		Sponsorship sponsorship = new Sponsorship();

		sponsorship.setExclusiveAdvertiser(advertiser);

		tournament.setSponsorship(sponsorship);

		return true;
	}

	/**
	 * Sử dụng banner quảng cáo ngẫu nhiên.
	 *
	 * @param tournament Tournament
	 */
	public void useRandomAdvertising(Tournament tournament) {

		Sponsorship sponsorship = new Sponsorship();

		sponsorship.useRandomAdvertising();

		tournament.setSponsorship(sponsorship);
	}

	/**
	 * Tạo trang chủ cho Tournament.
	 *
	 * @param tournament Tournament
	 */
	public void createTournamentHomePage(Tournament tournament) {

		String page = "https://arena.com/tournament/" + tournament.getName().toLowerCase().replace(" ", "-");

		tournament.setHomePage(page);
	}

	/**
	 * Lấy danh sách Player.
	 *
	 * @return danh sách Player
	 */
	public List<Player> getPlayers() {
		return new ArrayList<>(players);
	}

	/**
	 * Lấy danh sách Spectator.
	 *
	 * @return danh sách Spectator
	 */
	public List<Spectator> getSpectators() {
		return new ArrayList<>(spectators);
	}

	/**
	 * Thông báo Tournament cho các Player.
	 *
	 * @param tournament      Tournament
	 * @param selectedPlayers Player được chọn
	 */
	public void notifyPlayers(Tournament tournament, List<Player> selectedPlayers) {

		for (Player player : selectedPlayers) {

			tournament.addInterestedPlayer(player);

			System.out.println("Thông báo Player " + player.getName() + ": " + tournament.getHomePage());
		}
	}

	/**
	 * Thông báo Tournament cho các Spectator.
	 *
	 * @param tournament         Tournament
	 * @param selectedSpectators Spectator được chọn
	 */
	public void notifySpectators(Tournament tournament, List<Spectator> selectedSpectators) {

		for (Spectator spectator : selectedSpectators) {

			tournament.addInterestedSpectator(spectator);

			System.out.println("Thông báo Spectator " + spectator.getName() + ": Tournament " + tournament.getName());
		}
	}
}
