package Entity;

/**
 * Đại diện cho thông tin tài trợ của Tournament.
 * Tournament có thể có một Advertiser tài trợ độc quyền
 * hoặc sử dụng quảng cáo ngẫu nhiên từ hệ thống ARENA.
 */
public class Sponsorship {

    /** Nhà quảng cáo tài trợ độc quyền. */
    private Advertiser exclusiveAdvertiser;

    /** Cho biết Tournament có tài trợ độc quyền hay không. */
    private boolean exclusive;

    /**
     * Khởi tạo Sponsorship.
     */
    public Sponsorship() {
        this.exclusive = false;
    }

    /**
     * Thiết lập nhà tài trợ độc quyền.
     *
     * @param advertiser nhà quảng cáo
     */
    public void setExclusiveAdvertiser(Advertiser advertiser) {
        this.exclusiveAdvertiser = advertiser;
        this.exclusive = true;
    }

    /**
     * Thiết lập quảng cáo ngẫu nhiên.
     */
    public void useRandomAdvertising() {
        this.exclusiveAdvertiser = null;
        this.exclusive = false;
    }

    /**
     * Kiểm tra tài trợ độc quyền.
     *
     * @return true nếu có nhà tài trợ độc quyền
     */
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * Lấy nhà tài trợ độc quyền.
     *
     * @return Advertiser hoặc null
     */
    public Advertiser getExclusiveAdvertiser() {
        return exclusiveAdvertiser;
    }
}