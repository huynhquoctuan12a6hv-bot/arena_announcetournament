package Entity;

/**
 * Đại diện cho LeagueOwner trong hệ thống ARENA.
 *
 * LeagueOwner là actor khởi tạo use case
 * AnnounceTournament.
 */
public class LeagueOwner {

    private String name;
   
    private String email;
   
    private int tournamentLimit;

    private int tournamentCount;

    /**
     * Khởi tạo LeagueOwner.
     *
     * @param name tên LeagueOwner
     * @param email email LeagueOwner
     * @param tournamentLimit giới hạn số Tournament
     */
    public LeagueOwner(
            String name,
            String email,
            int tournamentLimit) {

        this.name = name;
        this.email = email;
        this.tournamentLimit = tournamentLimit;
        this.tournamentCount = 0;
    }

    /**
     * Kiểm tra LeagueOwner còn được phép tạo Tournament hay không.
     *
     * @return true nếu còn được phép tạo
     */
    public boolean canCreateTournament() {
        return tournamentCount < tournamentLimit;
    }

    /**
     * Tăng số lượng Tournament đã tạo.
     */
    public void increaseTournamentCount() {
        tournamentCount++;
    }

    /**
     * Lấy tên LeagueOwner.
     *
     * @return tên LeagueOwner
     */
    public String getName() {
        return name;
    }

    /**
     * Lấy email LeagueOwner.
     *
     * @return email LeagueOwner
     */
    public String getEmail() {
        return email;
    }

    /**
     * Lấy số Tournament đã tạo.
     *
     * @return số Tournament
     */
    public int getTournamentCount() {
        return tournamentCount;
    }
}