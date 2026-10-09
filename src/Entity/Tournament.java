package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Đại diện cho một Tournament trong hệ thống ARENA.
 * Tournament chứa thông tin về giải đấu,
 * thời gian đăng ký, thời gian tổ chức,
 * số lượng Player tối đa và thông tin tài trợ.
 */
public class Tournament {

    private String name;

    private String applicationStartDate;

    private String applicationEndDate;

    private String tournamentStartDate;

    private String tournamentEndDate;

    private int maximumPlayers;

    /** Trang chủ Tournament. */
    private String homePage;

    /** Thông tin tài trợ. */
    private Sponsorship sponsorship;

    /** Danh sách Player được thông báo. */
    private List<Player> interestedPlayers;

    /** Danh sách Spectator được thông báo. */
    private List<Spectator> interestedSpectators;

    /**
     * Khởi tạo Tournament.
     *
     * @param name tên Tournament
     * @param applicationStartDate ngày bắt đầu đăng ký
     * @param applicationEndDate ngày kết thúc đăng ký
     * @param tournamentStartDate ngày bắt đầu giải đấu
     * @param tournamentEndDate ngày kết thúc giải đấu
     * @param maximumPlayers số Player tối đa
     */
    public Tournament(
            String name,
            String applicationStartDate,
            String applicationEndDate,
            String tournamentStartDate,
            String tournamentEndDate,
            int maximumPlayers) {

        this.name = name;
        this.applicationStartDate = applicationStartDate;
        this.applicationEndDate = applicationEndDate;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentEndDate = tournamentEndDate;
        this.maximumPlayers = maximumPlayers;

        this.interestedPlayers = new ArrayList<>();
        this.interestedSpectators = new ArrayList<>();
    }

    /**
     * Thiết lập thông tin tài trợ.
     *
     * @param sponsorship thông tin tài trợ
     */
    public void setSponsorship(Sponsorship sponsorship) {
        this.sponsorship = sponsorship;
    }

    /**
     * Thiết lập trang chủ Tournament.
     *
     * @param homePage URL trang chủ
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * Thêm Player vào danh sách người được thông báo.
     *
     * @param player Player
     */
    public void addInterestedPlayer(Player player) {
        interestedPlayers.add(player);
    }

    /**
     * Thêm Spectator vào danh sách người được thông báo.
     *
     * @param spectator Spectator
     */
    public void addInterestedSpectator(Spectator spectator) {
        interestedSpectators.add(spectator);
    }

    /**
     * Lấy tên Tournament.
     *
     * @return tên Tournament
     */
    public String getName() {
        return name;
    }

    /**
     * Lấy ngày bắt đầu đăng ký.
     *
     * @return ngày bắt đầu đăng ký
     */
    public String getApplicationStartDate() {
        return applicationStartDate;
    }

    /**
     * Lấy ngày kết thúc đăng ký.
     *
     * @return ngày kết thúc đăng ký
     */
    public String getApplicationEndDate() {
        return applicationEndDate;
    }

    /**
     * Lấy ngày bắt đầu Tournament.
     *
     * @return ngày bắt đầu Tournament
     */
    public String getTournamentStartDate() {
        return tournamentStartDate;
    }

    /**
     * Lấy ngày kết thúc Tournament.
     *
     * @return ngày kết thúc Tournament
     */
    public String getTournamentEndDate() {
        return tournamentEndDate;
    }

    /**
     * Lấy số Player tối đa.
     *
     * @return số Player tối đa
     */
    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    /**
     * Lấy trang chủ Tournament.
     *
     * @return URL trang chủ
     */
    public String getHomePage() {
        return homePage;
    }

    /**
     * Lấy thông tin tài trợ.
     *
     * @return Sponsorship
     */
    public Sponsorship getSponsorship() {
        return sponsorship;
    }

    /**
     * Lấy danh sách Player được thông báo.
     *
     * @return danh sách Player
     */
    public List<Player> getInterestedPlayers() {
        return interestedPlayers;
    }

    /**
     * Lấy danh sách Spectator được thông báo.
     *
     * @return danh sách Spectator
     */
    public List<Spectator> getInterestedSpectators() {
        return interestedSpectators;
    }
}