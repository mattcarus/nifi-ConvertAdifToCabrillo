package uk.co.mattcarus.ham;

public class Qso {
	public Integer freq;
	public String mode;
	public String date;
	public String time;
	public String call_sent;
	public String rst_sent;
	public String exch_sent;
	public String call_rcvd;
	public String rst_rcvd;
	public String exch_rcvd;
	public Integer tx_num;
	
	public Qso(Integer freq, String mode, String date, String time, String call_sent, String rst_sent, String exch_sent, String call_rcvd, String rst_rcvd, String exch_rcvd, Integer tx_num)
	{
		this.freq = freq;
		this.mode = mode;
		this.date = date;
		this.time = time;
		this.call_sent = call_sent;
		this.rst_sent = rst_sent;
		this.exch_sent = exch_sent;
		this.call_rcvd = call_rcvd;
		this.rst_rcvd = rst_rcvd;
		this.exch_rcvd = exch_rcvd;
		this.tx_num = tx_num;
	}
}