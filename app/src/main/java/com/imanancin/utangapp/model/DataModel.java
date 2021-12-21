package com.imanancin.utangapp.model;

import android.os.Parcel;
import android.os.Parcelable;

// Parcelable digunakan untuk mengirim data object ke dalam Intent
public class DataModel implements Parcelable {

    private String customer_name;
    private String date;
    private Integer total;

    public DataModel(String customer_name, String date, Integer total) {
        this.customer_name = customer_name;
        this.date = date;
        this.total = total;
    }

    protected DataModel(Parcel in) {
        customer_name = in.readString();
        date = in.readString();
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readInt();
        }
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(customer_name);
        parcel.writeString(date);
        if (total == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(total);
        }
    }
}
