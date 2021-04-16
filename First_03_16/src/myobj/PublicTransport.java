package myobj;

public class PublicTransport {

	
	public int bus_num;
	public int bus_passenger;
	public int bus_revenue;
	public int bus_price;
	public String bus_area;
	
	public int sub_line;
	public int sub_station_count;
	
	public PublicTransport(int sub_line, int sub_station_count) {
		
		this.sub_line = sub_line;
		this.sub_station_count = sub_station_count;
	}
	
	public PublicTransport(int bus_num, int bus_passenger, int bus_price, String bus_area) {
		
		this.bus_num = bus_num;
		this.bus_passenger = bus_passenger;
		this.bus_price = bus_price;
		this.bus_area = bus_area;
		bus_revenue = bus_passenger * bus_price;
	}
	
	
	public void bus_info() {
		System.out.printf("%s %d�� ������ ����� %d�� �°����� %d�� ������ %d�� �Դϴ� .\n ", bus_area, bus_num, bus_price, bus_passenger, bus_revenue);
	}
	public void sub_info() {
		System.out.printf("%dȣ�� ����ö���� �� ������ %d�� �Դϴ�. ", sub_line, sub_station_count);
	}
}
