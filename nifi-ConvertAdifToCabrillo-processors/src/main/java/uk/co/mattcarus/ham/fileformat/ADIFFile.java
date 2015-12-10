package uk.co.mattcarus.ham.fileformat;

import java.util.List;

import uk.co.mattcarus.ham.Qso;

public class ADIFFile {
	public double version = 3.0;
	public String callsign;
	public String contest;
	public String category_operator;
	public String category_assisted;
	public String category_band;
	public String category_power;
	public String category_mode;
	public String category_transmitter;
	public String category_overlay;
	public Integer claimed_score;
	public Boolean certificate = true;
	public String club;
	public String location;
	public String created_by = "Apache Nifi";
	public String name;
	public List<String> address;
	public String address_city;
	public String address_state_province;
	public String address_postalcode;
	public String address_country;
	public List<String> operators;
	public List<String> soapbox;
	public List<String> additional_headers;
	public List<Qso> qso;
	public List<Qso> x_qso;
	
	public CabrilloFile()
	{
		
	}
	
	public void addQso(Integer freq, String mode, String date, String time, String call_sent, String rst_sent, String exch_sent, String call_rcvd, String rst_rcvd, String exch_rcvd, Integer tx_num)
	{
		this.qso.add(String.format("%d %s %s %s %s %s %s %s %s %s %d\n", freq, mode, date, time, call_sent, rst_sent, exch_sent, call_rcvd, rst_rcvd, exch_rcvd, tx_num));
	}
	
	public String generateAdifLine(String field, String value)
	{
		return String.format("<%s:%d>%s", field, field.length(), value);
	}
	
	@Override
	public String toString()
	{
		StringBuilder out = new StringBuilder();
		
		out.append(this.generateAdifLine("ADIF_VER", this.version) + "\n");
		out.append(this.generateAdifLine("CREATED_TIMESTAMP", ) + "\n");
		out.append(this.generateAdifLine("PROGRAMID", "Apache Nifi") + "\n");
		out.append(this.generateAdifLine("PROGRAMVERSION", "1.0") + "\n");
		
		for ( String qsoLine : this.qso )
		{
			// TODO: Fix this to use Qso Objects
			out.append("QSO: " + qsoLine + "\n");
		}
		out.append("END-OF-LOG: ");
		
		return out.toString();
	}
}