package com.naver.dbtjd122.domain;

import java.sql.Date;

public class PasingVO {
	
		String param1;
		String param2;
		public String getParam1() {
			return param1;
		}
		public void setParam1(String param1) {
			this.param1 = param1;
		}
		public String getParam2() {
			return param2;
		}
		public void setParam2(String param2) {
			this.param2 = param2;
		}
		@Override
		public String toString() {
			return "PasingVO [param1=" + param1 + ", param2=" + param2 + "]";
		}

		
		}