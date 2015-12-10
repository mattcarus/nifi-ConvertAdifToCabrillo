package uk.co.mattcarus.ham.fileformat;

import java.util.List;

import uk.co.mattcarus.ham.Qso;

public class CabrilloFile {
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
		this.qso.add(new Qso(freq, mode, date, time, call_sent, rst_sent, exch_sent, call_rcvd, rst_rcvd, exch_rcvd, tx_num));
	}
	
	@Override
	public String toString()
	{
		StringBuilder out = new StringBuilder();
		
		out.append("START-OF-LOG: " + this.version + "\n");
		out.append("CALLSIGN: " + this.callsign + "\n");
		out.append("CONTEST: " + this.contest + "\n");
		out.append("CATEGORY-OPERATOR: " + this.category_operator + "\n");
		out.append("CATEGORY-ASSISTED: " + this.category_assisted + "\n");
		out.append("CATEGORY-BAND: " + this.category_band + "\n");
		out.append("CATEGORY-POWER: " + this.category_power + "\n");
		out.append("CATEGORY-MODE: " + this.category_mode + "\n");
		out.append("CATEGORY-TRANSMITTER: " + this.category_transmitter + "\n");
		out.append("CATEGORY-OVERLAY: " + this.category_overlay + "\n");
		out.append("CLAIMED-SCORE: " + this.claimed_score + "\n");
		if ( this.certificate )
		{
			out.append("CERTIFICATE: YES\n");
		} else {
			out.append("CERTIFICATE: NO\n");
		}
		out.append("CLUB: " + this.club + "\n");
		out.append("LOCATION: " + this.location + "\n");
		out.append("CREATED-BY: " + this.created_by + "\n");
		out.append("NAME: " + this.name + "\n");
		for ( String address : this.address)
		{
			out.append("ADDRESS: " + address + "\n");
		}
		out.append("ADDRESS-CITY: " + this.address_city + "\n");
		out.append("ADDRESS-STATE-PROVINCE: " + this.address_state_province + "\n");
		out.append("ADDRESS-POSTALCODE: " + this.address_postalcode + "\n");
		out.append("ADDRESS-COUNTRY: " + this.address_country + "\n");
		StringBuilder operators = new StringBuilder();
		for ( String op : this.operators )
		{
			operators.append(op + " ");
		}
		out.append("OPERATORS: " + operators + "\n");
		for ( String soapboxLine : this.soapbox )
		{
			out.append("SOAPBOX: " + soapboxLine + "\n");
		}
		for ( Qso qsoLine : this.qso )
		{
			out.append("QSO: " + String.format("%d %s %s %s %s %s %s %s %s %s %d\n", qsoLine.freq, qsoLine.mode, qsoLine.date, qsoLine.time, qsoLine.call_sent, qsoLine.rst_sent, qsoLine.exch_sent, qsoLine.call_rcvd, qsoLine.rst_rcvd, qsoLine.exch_rcvd, qsoLine.tx_num) + "\n");
		}
		out.append("END-OF-LOG: ");
		
		return out.toString();
	}
}