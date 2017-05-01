package com.homefit.android.homefit.database;

import java.util.UUID;

public class HomeFitDbSchema {

	public static final class CustomerTable {
		public static final String TABLE_NAME = "customers";

		public static final class Cols {
			public static final String UUID = "uuid";
			public static final String NAME = "name";
			public static final String ADDRESS_ONE = "address_one";
			public static final String ADDRESS_TWO = "address_two";
			public static final String CITY = "city";
			public static final String STATE = "state";
			public static final String ZIP = "zip";
			public static final String PHONE = "phone";
			public static final String EMAIL = "email";
		}
	}

	public static final class SessionTable {
		public static final String TABLE_NAME = "sessions";

		public static final class Cols {
			public static final String UUID = "uuid";
			public static final String CUSTOMER_ID = "customer_id";
			public static final String DATE = "date";
			public static final String SESSION_PLAN = "session_plan";
			public static final String COST = "cost";
			public static final String IS_COMPLETE = "is_complete";
			public static final String IS_PAID = "is_paid";
		}
	}
}
