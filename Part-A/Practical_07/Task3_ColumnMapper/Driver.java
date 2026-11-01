public class Driver {
    public static void main(String[] args) throws Exception {
        String[] headers = {"customer_name", "email_address"};
        String[] row = {"Rydham Desai", "rydham@example.com"};
        System.out.println(ColumnMapper.map(CustomerRow.class, headers, row));
    }
}
