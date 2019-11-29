package com.srp.deleterecyclerviewcheckbox;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private String itemName;
    private boolean isSelected;

    Model (){
        this(null,false);
    }

    Model(String itemName, boolean isSelected) {
        this.itemName = itemName;
        this.isSelected = isSelected;
    }

    protected Model(Parcel in) {
        itemName = in.readString();
        isSelected = in.readByte() != 0;
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(itemName);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}
