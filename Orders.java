package com.example.cms;



	import java.sql.Date;

	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.Id;

	@Entity
	public class Orders {

		@Id
		private int ord_id;
		private int cus_id;
		private int ven_Id;
		private int men_id;
		private String wal_source;
		private Date ord_date;
		private int ord_quantity;
		private double ord_billamount;
		private String ord_status;
		private String ord_comments;
		public int getOrd_id() {
			return ord_id;
		}
		public void setOrd_id(int ord_id) {
			this.ord_id = ord_id;
		}
		public int getCus_id() {
			return cus_id;
		}
		public void setCus_id(int cus_id) {
			this.cus_id = cus_id;
		}
		public int getVen_Id() {
			return ven_Id;
		}
		public void setVen_Id(int ven_Id) {
			this.ven_Id = ven_Id;
		}
		public int getMen_id() {
			return men_id;
		}
		public void setMen_id(int men_id) {
			this.men_id = men_id;
		}
		public String getWal_source() {
			return wal_source;
		}
		public void setWal_source(String wal_source) {
			this.wal_source = wal_source;
		}
		public Date getOrd_date() {
			return ord_date;
		}
		public void setOrd_date(Date ord_date) {
			this.ord_date = ord_date;
		}
		public int getOrd_quantity() {
			return ord_quantity;
		}
		public void setOrd_quantity(int ord_quantity) {
			this.ord_quantity = ord_quantity;
		}
		public double getOrd_billamount() {
			return ord_billamount;
		}
		public void setOrd_billamount(double ord_billamount) {
			this.ord_billamount = ord_billamount;
		}
		//@Enumerated(EnumType.STRING)
		public String getOrd_status() {
			return ord_status;
		}
		public void setOrd_status(String ord_status) {
			this.ord_status = ord_status;
		}
		public String getOrd_comments() {
			return ord_comments;
		}
		public void setOrd_comments(String ord_comments) {
			this.ord_comments = ord_comments;
		}
		
		
	}



