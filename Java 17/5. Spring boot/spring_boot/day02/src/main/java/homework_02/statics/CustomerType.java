package homework_02.statics;

public enum CustomerType {
    CA_NHAN(1),
    DAI_DIEN_DON_VI_HANH_CHINH(2),
    DAI_DIEN_DON_VI_KINH_DOANH(3),
    ;

    public int value;

    CustomerType(int value) {
        this.value = value;
    }
}
